package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/registracia.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom");
    }


    @Test
    public void itShouldRegisterValidUser() {
        String email = "hruska@gmail.com";
        String meno = "Hruska";
        String priezvisko = "Zelena";
        String heslo = "123456";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("name")).sendKeys(meno);
        driver.findElement(By.name("surname")).sendKeys(priezvisko);
        driver.findElement(By.name("password")).sendKeys(heslo);
        driver.findElement(By.name("password-repeat")).sendKeys(heslo);
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();


        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());


    }

    @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty(){
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());

    }


}