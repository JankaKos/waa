package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
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

    Fairy fairy = Fairy.create();
    Person fakePerson = fairy.person();

    @Test
    public void buttonIsEnable() {
        savingsCalculatorPage.sendKeysToTable(2,"3000","5",fakePerson.getEmail());
        Assert.assertTrue(savingsCalculatorPage.buttonApply().isEnabled());

    }

    @Test
    public void itShouldActualIncomes() {
        savingsCalculatorPage.sendKeysToTable(2,"3000","5",fakePerson.getEmail());
        Assert.assertFalse(savingsCalculatorPage.actualTotalIncome().isEmpty());
        Assert.assertFalse(savingsCalculatorPage.actualInterestIncome().isEmpty());

    }

    @Test
    public void itShouldDisplayedRisk() {
        savingsCalculatorPage.sendKeysToTable(2,"3000","5",fakePerson.getEmail());
        Assert.assertFalse(savingsCalculatorPage.actualRisk().isEmpty());

    }

    @Test
    public void itShouldDisplayedNewRecord() {
        savingsCalculatorPage.sendKeysToTable(2,"3000","5",fakePerson.getEmail());
        savingsCalculatorPage.buttonApply().click();
        Assert.assertTrue(savingsCalculatorPage.lastRecord().isDisplayed());
        Assert.assertTrue(savingsCalculatorPage.lastRecord().getText().contains("Fund"));
    }

}



