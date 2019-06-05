package pages;

import models.Note;
import models.SavingsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SavingsCalculatorPage {

    WebDriver pageDriver;
    @FindBy(id = "fundSelect")
    WebElement fundSelect;
    @FindBy(id = "oneTimeInvestmentInput")
    WebElement investmentInput;
    @FindBy(id = "yearsInput")
    WebElement yearsSelect;
    @FindBy(id = "emailInput")
    WebElement emailInput;
    @FindBy (xpath = "//div[1]/p")
    WebElement totalIncome;
    @FindBy (xpath = "//div[2]/p")
    WebElement interestIncome;
    @FindBy (xpath = "//div[3]/p")
    WebElement risk;



    public SavingsCalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }


    public WebElement buttonApply() {
        return pageDriver.findElement(By.cssSelector("button.btn-success"));
    }

    public WebElement lastRecord() {
        return pageDriver.findElement(By.xpath("//ul/li[1]/div"));
    }


    public void sendKeysToTable(SavingsCalculator savingsCalculator) {
        new Select(fundSelect).selectByVisibleText(savingsCalculator.getTextOfSelect());
        //new Select(fundSelect).selectByIndex(savingsCalculator.getNumberOfSelect());
        investmentInput.sendKeys(savingsCalculator.getInvestment());
        yearsSelect.sendKeys(savingsCalculator.getYears());
        emailInput.sendKeys(savingsCalculator.getEmail());
    }


    public String actualTotalIncome() {
        return totalIncome.getText();
    }

    public String actualInterestIncome() {
        return interestIncome.getText();
    }

    public String actualRisk() {
        return risk.getText();
    }

    public int sizeOfOptions (){
       return new Select(fundSelect).getOptions().size();
    }
}