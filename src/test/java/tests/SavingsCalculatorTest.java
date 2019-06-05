package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import models.SavingsRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.SavingsCalculatorPage;

public class SavingsCalculatorTest extends TestBase {
    private SavingsCalculatorPage savingsCalculatorPage;
    private Fairy fairy;
    private Person fakePerson ;
    private SavingsRequest savingsCalculatorAdd;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/savingscalculator.php");
        savingsCalculatorPage = new SavingsCalculatorPage(driver);
        fairy = Fairy.create();
        fakePerson = fairy.person();
        savingsCalculatorAdd = new SavingsRequest("Hoggwart's Fund","3000","5",fakePerson);
    }

    @Test
    public void buttonIsEnable() {
        savingsCalculatorPage.fillRequestData(savingsCalculatorAdd);
        Assert.assertTrue(savingsCalculatorPage.buttonApply().isEnabled());

    }

    @Test
    public void itShouldActualIncomes() {
        savingsCalculatorPage.fillRequestData(savingsCalculatorAdd);
        Assert.assertFalse(savingsCalculatorPage.actualTotalIncome().isEmpty());
        Assert.assertFalse(savingsCalculatorPage.actualInterestIncome().isEmpty());

    }

    @Test
    public void itShouldDisplayedRisk() {
        savingsCalculatorPage.fillRequestData(savingsCalculatorAdd);
        Assert.assertFalse(savingsCalculatorPage.actualRisk().isEmpty());

    }

    @Test
    public void itShouldDisplayedNewRecord() {
        for (String actualOption : savingsCalculatorPage.listOfOption()) {
            SavingsRequest savingsCalculatorAdd = new SavingsRequest(actualOption,"3000","5",fakePerson);
            savingsCalculatorPage.fillRequestData(savingsCalculatorAdd);
            savingsCalculatorPage.buttonApply().click();
            Assert.assertTrue(savingsCalculatorPage.lastRecord().isDisplayed());
            Assert.assertTrue(savingsCalculatorPage.lastRecord().getText().contains(actualOption));
        }


    }


}



