package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZenaAleboMuzTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/zenaalebomuz.php");
    }


    @Test
    public void ItShouldBeNotSelected () {


        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
    }

    @Test
    public void itShouldSelectMale() {

        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        //overit hlasku
        String expectedMessage = "It's wurst";
        String actualMessage = driver.findElement(By.cssSelector("h1.description")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void ItShouldNotBeWoman(){
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());

    }

    @Test
    public void ItShouldImageIsDisplayed (){
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());

    }
}
