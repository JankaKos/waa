package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.NotePage;

import java.sql.Timestamp;

public class NoteTest extends TestBase {
    private NotePage notePage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
        notePage = new NotePage(driver);
    }

    @Test
    public void addNew() throws InterruptedException {
        String titulok = generateUniqueTitle();
        String mojeMeno = "Moje meno";
        String textOdkazu = "Ahoj, dakujem za prispevok";
        notePage.enterNoteData(titulok,mojeMeno,textOdkazu);
        notePage.submitNewNote();
        checkNoteInList(titulok);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.sin ")).isDisplayed());
        Assert.assertTrue(notePage.getLastNoteFromList().isDisplayed());
        notePage.getLastNoteFromList().click();
        Thread.sleep(3000);
        //bonus
        notePage.checkNoteDetail(titulok, mojeMeno, textOdkazu);
    }



    private String generateUniqueTitle(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "titulok " + timestamp.getTime();
    }

    private void checkNoteInList(String title) {
        WebElement listItem = notePage.getLastNoteFromList();
        //overim ze sa pridal novy zaznam do zoznamu
        Assert.assertTrue(listItem.getText().contains(title));
        //overenie linku
        Assert.assertTrue(listItem.findElement(By.cssSelector("div.description a")).isDisplayed());
        Assert.assertEquals("detail", listItem.findElement(By.cssSelector("div.description a")).getText());
    }
}
