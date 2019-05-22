package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotePage {
    WebDriver pageDriver;


    public NotePage(WebDriver driver) {
        this.pageDriver = driver;
    }
    public void enterNoteData(String titulok, String mojeMeno, String textOdkazu){
        pageDriver.findElement(By.name("title")).sendKeys(titulok);
        pageDriver.findElement(By.name("author")).sendKeys(mojeMeno);
        pageDriver.findElement(By.name("message")).sendKeys(textOdkazu);
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
