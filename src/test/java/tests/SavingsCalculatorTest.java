package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.SavingsCalculatorPage;

import java.util.List;

public class SavingsCalculatorTest extends TestBase {
    private SavingsCalculatorPage savingsCalculatorPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingsCalculatorPage = new SavingsCalculatorPage(driver);
    }


    @Test
    public void buttonIsEnable() {
        savingsCalculatorPage.sendKeysToTable();
        Assert.assertTrue(savingsCalculatorPage.buttonApply().isEnabled());

    }

    @Test
    public void itShouldActualIncomes() {
        savingsCalculatorPage.sendKeysToTable();
        String actualTotalIncome = driver.findElement(By.xpath("//div[1]/p")).getText();
        String actualInterestIncome = driver.findElement(By.xpath("//div[2]/p")).getText();
        Assert.assertFalse(actualTotalIncome.isEmpty());
        Assert.assertFalse(actualInterestIncome.isEmpty());

    }

    @Test
    public void itShouldDisplayedRisk() {
        savingsCalculatorPage.sendKeysToTable();
        String actualRisk = driver.findElement(By.xpath("//div[3]/p")).getText();
        Assert.assertFalse(actualRisk.isEmpty());

    }

    @Test
    public void itShouldDisplayedNewRecord() {
        savingsCalculatorPage.sendKeysToTable();
        savingsCalculatorPage.buttonApply().click();
        Assert.assertTrue(savingsCalculatorPage.lastRecord().isDisplayed());
        Assert.assertTrue(savingsCalculatorPage.lastRecord().getText().contains("Fund"));
    }


}



