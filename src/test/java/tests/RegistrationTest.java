package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {
    private RegistrationPage registrationPage ;
    @Before
    public void openPage() {
        driver.get(BASE_URL + "/registracia.php");

    registrationPage = new RegistrationPage(driver);}

    @Test
    public void itShouldRegisterValidUser() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        driver.findElement(By.name("email")).sendKeys(person.getEmail());
        driver.findElement(By.name("name")).sendKeys(person.getFirstName());
        driver.findElement(By.name("surname")).sendKeys(person.getLastName());
        driver.findElement(By.name("password")).sendKeys(person.getPassword());
        driver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
        registrationPage.clickRobot();
        registrationPage.sendFormular();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());


    }

    @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty(){
        registrationPage.clickRobot();
        registrationPage.sendFormular();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());

    }

}