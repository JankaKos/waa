package pages;

import models.SavingsRequest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SavingsCalculatorPage {

    WebDriver pageDriver;
    @FindBy(id = "fundSelect")
    WebElement fundSelect;
    @FindBy(id = "oneTimeInvestmentInput")
    WebElement investmentInput;
    @FindBy(id = "yearsInput")
    WebElement yearsInput;
    @FindBy(id = "emailInput")
    WebElement emailInput;
    @FindBy (xpath = "//div[@class='result']/div[1]/p")
    WebElement totalIncome;
    @FindBy (xpath = "//div[@class='result']/div[2]/p")
    WebElement interestIncome;
    @FindBy (xpath = "//div[@class='result']/div[3]/p")
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


    public void fillRequestData(SavingsRequest savingsCalculator) {
        new Select(fundSelect).selectByVisibleText(savingsCalculator.getTextOfSelect());
        investmentInput.sendKeys(savingsCalculator.getInvestment());
        yearsInput.sendKeys(savingsCalculator.getYears());
        emailInput.sendKeys(savingsCalculator.getEmail().getEmail());
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

    public List<String> listOfOptions (){
        List <WebElement> optionElement = new Select (fundSelect).getOptions();
        List<String> listOfOptions;
        if (!optionElement.isEmpty()){

        optionElement.remove(0);
        listOfOptions = new ArrayList<String>();
        for (WebElement option : optionElement) {
            listOfOptions.add(option.getText());
        }
            return listOfOptions;
        }
        else
            return null;

}


}