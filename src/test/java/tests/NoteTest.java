package tests;

import base.TestBase;
import models.Note;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        Note noteToAdd = new Note(titulok,mojeMeno,textOdkazu);

        notePage.enterNoteData(noteToAdd);
        notePage.submitNewNote();
        checkNoteInList(noteToAdd.getTitle());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.sin ")).isDisplayed());
        Assert.assertTrue(notePage.getLastNoteFromList().isDisplayed());
        notePage.openLastNote();
        notePage.checkNoteDetail(noteToAdd);
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
