package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SavingsCalculatorTest extends TestBase {

    @Before
    public void openPage () {
        driver.get(BASE_URL + "/savingscalculator.php");
    }


   @Test
   public void buttonIsEnable (){ 
        WebElement firstSelect = driver.findElement(By.id("fundSelect"));
       new Select(firstSelect).selectByIndex(2);
       WebElement investmentInput = driver.findElement(By.id("oneTimeInvestmentInput"));
       investmentInput.sendKeys("3000");
       WebElement yearsSelect = driver.findElement(By.id("yearsInput"));
       yearsSelect.sendKeys("5");
       WebElement emailInput = driver.findElement(By.id("emailInput"));
       emailInput.sendKeys("gdkf@gmail.com");
       Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-success")).isEnabled());

       }


       }



