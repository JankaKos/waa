package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConchitaPage;

public class ConchitaTest extends TestBase {
    private ConchitaPage conchitaPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/zenaalebomuz.php");

        conchitaPage = new ConchitaPage(driver);
    }

    @Test
    public void ItShouldBeNotSelected () {


        Assert.assertFalse(conchitaPage.wurst.isSelected());
        Assert.assertFalse(conchitaPage.conchita.isSelected());
    }

    @Test
    public void itShouldSelectMale() {

        conchitaPage.clickWurst();
        //overit hlasku
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void ItShouldNotBeWoman(){
        conchitaPage.clickWurst();
        Assert.assertFalse(conchitaPage.conchita.isSelected());

    }

    @Test
    public void ItShouldImageIsDisplayed (){
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());

    }


}
