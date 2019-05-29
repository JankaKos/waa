package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CalculatorPage;

public class CalculatorTest extends TestBase {
    private CalculatorPage calculatorPage;

    @Before
    public void openPage (){
        driver.get(BASE_URL+"/kalkulacka.php");
        calculatorPage = new CalculatorPage(driver);
    }

    @Test
    public void itShouldCount (){
        calculatorPage.sendNumbers("7", "4");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("11",
                calculatorPage.actualResult());

    }

    @Test
    public void itShouldDeduce(){
        calculatorPage.sendNumbers("7", "4");
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals("3",
                calculatorPage.actualResult());
    }

    @Test
    public void itShouldMultipli(){
        calculatorPage.sendNumbers("7", "3");
        driver.findElement(By.id("multiply")).click();
        Assert.assertEquals("21", calculatorPage.actualResult());
    }

    @Test
    public void itShouldDivide(){
        calculatorPage.sendNumbers("7","3");
        driver.findElement(By.id("divide")).click();
        System.out.println(calculatorPage.actualResult());
        Assert.assertTrue(calculatorPage.actualResult().contains("2.3"));
    }

    @Test
    public void itShouldResetColums(){
        calculatorPage.sendNumbers("7", "4");
        driver.findElement(By.id("deduct")).click();
        driver.findElement(By.id("reset")).click();
        Assert.assertTrue(calculatorPage.getFirstInput().getAttribute("value").isEmpty());
        Assert.assertTrue(calculatorPage.getSecondInput().getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayedLastCalculation(){
        calculatorPage.sendNumbers("7", "2");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("7+2 = 9", calculatorPage.getLatestCalculation().getText());
        Assert.assertEquals(1, calculatorPage.getListOfCalculation().size());
    }



}
