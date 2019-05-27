package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {
    WebDriver pageDriver;
    @FindBy(name = "title")
    private WebElement title;
    @FindBy(name = "author")
    private WebElement author;
    @FindBy(name = "message")
    private WebElement message;

    public NotePage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }
    public void enterNoteData(String titulok, String mojeMeno, String textOdkazu){
        title.sendKeys(titulok);
        author.sendKeys(mojeMeno);
        message.sendKeys(textOdkazu);
    }
    public void submitNewNote(){
        pageDriver.findElement(By.cssSelector("button.btn-block")).click();
    }

    public WebElement getLastNoteFromList(){
        return pageDriver.findElement(By.cssSelector("ul.list-of-sins li:last-child"));
    }

    public void checkNoteDetail(String  title, String author, String message ) {
        WebElement detail = pageDriver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());}
}
