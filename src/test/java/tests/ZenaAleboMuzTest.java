package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZenaAleboMuzTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/zenaalebomuz.php");


    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom");
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
