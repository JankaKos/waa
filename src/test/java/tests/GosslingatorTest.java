package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest<http> {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
    }

    @Test
    public void itShouldRyan() {
        //2.kliknut na button Ryan
        driver.findElement(By.id("addRyan")).

                click();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).

                getText());
        //4.zavriet prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();

    }

    @Test
    public void itShouldAddTwoRyan() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        //2.kliknut 2x na button Ryan
        addRyanButton.click();
        addRyanButton.click();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
        //4.zavriet prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();

    }




    @Test
    public void itShouldItDisplayWarningMessage() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();
        addRyanButton.click();


    }

}

