package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorPage {

    WebDriver pageDriver ;

    public SavingsCalculatorPage (WebDriver driver){
        this.pageDriver = driver;}



    public WebElement buttonApply (){
        return pageDriver.findElement(By.cssSelector("button.btn-success"));
    }

    public WebElement lastRecord(){
        return pageDriver.findElement(By.xpath("//ul/li[1]/div"));
    }

    public void sendKeysToTable (){
        WebElement firstSelect = pageDriver.findElement(By.id("fundSelect"));
        new Select(firstSelect).selectByIndex(2);
        WebElement investmentInput = pageDriver.findElement(By.id("oneTimeInvestmentInput"));
        investmentInput.sendKeys("3000");
        WebElement yearsSelect = pageDriver.findElement(By.id("yearsInput"));
        yearsSelect.sendKeys("5");
        WebElement emailInput = pageDriver.findElement(By.id("emailInput"));
        emailInput.sendKeys("gdkf@gmail.com");

    }
}
