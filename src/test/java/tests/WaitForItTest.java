package tests;

import base.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForItTest extends TestBase {

    @Before
    public void openPage(){
        driver.get(BASE_URL+"/waitforit.php");
    }

    @Test
    public void waitForClass(){

        driver.findElement(By.id("startWaitForProperty")).click();
        String expectedClass = "error";
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeContains(driver.findElement(By.id("waitForProperty")),"class", expectedClass));
    }
}
