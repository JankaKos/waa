package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver pageDriver;

    public RegistrationPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void clickRobot() {
        pageDriver.findElement(By.name("robot")).click();
    }

    public void sendFormular() {
        pageDriver.findElement(By.cssSelector("button.btn-success")).click();
    }

}
