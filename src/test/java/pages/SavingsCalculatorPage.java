package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public void sendKeysToTable(Integer number, String investment, String years, String email) {
        new Select(fundSelect).selectByIndex(number);
        investmentInput.sendKeys(investment);
        yearsSelect.sendKeys(years);
        emailInput.sendKeys(email);
    }

    public String actualTotalIncome() {
        return pageDriver.findElement(By.xpath("//div[1]/p")).getText();
    }

    public String actualInterestIncome() {
        return pageDriver.findElement(By.xpath("//div[2]/p")).getText();
    }


    public String actualRisk() {
        return pageDriver.findElement(By.xpath("//div[3]/p")).getText();
    }
}