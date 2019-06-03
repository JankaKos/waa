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
       sendKeysToTable();
       Assert.assertTrue(buttonApply().isEnabled());

       }
@Test
    public void itShouldActualIncomes(){
        sendKeysToTable();
        String actualTotalIncome = driver.findElement(By.xpath("//div[1]/p")).getText();
        String actualInterestIncome = driver.findElement(By.xpath("//div[2]/p")).getText();
        Assert.assertFalse(actualTotalIncome.isEmpty());
        Assert.assertFalse(actualInterestIncome.isEmpty());

}
@Test
public void itShouldDisplayedRisk (){
        sendKeysToTable();
        String actualRisk = driver.findElement(By.xpath("//div[3]/p")).getText();
        Assert.assertFalse(actualRisk.isEmpty());

}

@Test
public void itShouldDisplayedNewRecord (){
        sendKeysToTable();
        buttonApply().click();
        Assert.assertTrue(lastRecord().isDisplayed());
        Assert.assertTrue(lastRecord().getText().contains("Fund"));
}





public WebElement buttonApply (){
    return driver.findElement(By.cssSelector("button.btn-success"));
}

public WebElement lastRecord(){
        return driver.findElement(By.xpath("//ul/li[1]/div"));
}

public void sendKeysToTable (){
    WebElement firstSelect = driver.findElement(By.id("fundSelect"));
    new Select(firstSelect).selectByIndex(2);
    WebElement investmentInput = driver.findElement(By.id("oneTimeInvestmentInput"));
    investmentInput.sendKeys("3000");
    WebElement yearsSelect = driver.findElement(By.id("yearsInput"));
    yearsSelect.sendKeys("5");
    WebElement emailInput = driver.findElement(By.id("emailInput"));
    emailInput.sendKeys("gdkf@gmail.com");

}
       }



