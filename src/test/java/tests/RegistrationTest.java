package tests;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
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
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        driver.findElement(By.name("email")).sendKeys(person.getEmail());
        driver.findElement(By.name("name")).sendKeys(person.getFirstName());
        driver.findElement(By.name("surname")).sendKeys(person.getLastName());
        driver.findElement(By.name("password")).sendKeys(person.getPassword());
        driver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
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