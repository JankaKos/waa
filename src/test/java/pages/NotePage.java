package pages;

import models.Note;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {
    WebDriver pageDriver;
    @FindBy(name = "title")
    private WebElement titleInput;
    @FindBy(name = "author")
    private WebElement authorInput;
    @FindBy(name = "message")
    private WebElement messageInput;
    @FindBy(css = "div.content")
    private WebElement detail;
    @FindBy (css = "button.btn-block")
    private WebElement submitButton;


    public NotePage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }
    public void enterNoteData(Note note){
        titleInput.sendKeys(note.getTitle());
        authorInput.sendKeys(note.getAuthor());
        messageInput.sendKeys(note.getMessage());
    }
    public void submitNewNote(){
        submitButton.click();
    }

    public WebElement getLastNoteFromList(){
        return pageDriver.findElement(By.cssSelector("ul.list-of-sins li:last-child"));
    }

    public void checkNoteDetail(Note note) {
        Assert.assertEquals(note.getTitle(), detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(note.getAuthor(), detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(note.getMessage(), detail.findElement(By.cssSelector("p")).getText());}
}
