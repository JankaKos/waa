package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;

public class OdkazovacTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
    }

    @Test
    public void addNew() throws InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String titulok = "titulok " + timestamp.getTime();
        String mojeMeno = "Moje meno";
        String textOdkazu = "Ahoj, dakujem za prispevok";
        enterNoteData(titulok,mojeMeno,textOdkazu);
        submitNewNote();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.sin ")).isDisplayed());
        Assert.assertTrue(getLastNoteFromList().isDisplayed());
        getLastNoteFromList().click();
        Thread.sleep(3000);
        //bonus
        checkNoteDetail(titulok, mojeMeno, textOdkazu);
    }

    private void enterNoteData(String titulok, String mojeMeno, String textOdkazu){
        driver.findElement(By.name("title")).sendKeys(titulok);
        driver.findElement(By.name("author")).sendKeys(mojeMeno);
        driver.findElement(By.name("message")).sendKeys(textOdkazu);
    }
    private void submitNewNote(){
        driver.findElement(By.cssSelector("button.btn-block")).click();
    }

    private WebElement getLastNoteFromList(){
       return driver.findElement(By.cssSelector("ul.list-of-sins li:last-child"));
    }

    private  void checkNoteDetail(String  title, String author, String message ) {
        WebElement detail = driver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(title, detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(author, detail.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(message, detail.findElement(By.cssSelector("p")).getText());
    }

}
