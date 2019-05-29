package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalculatorPage {
    WebDriver pageDriver;


    public CalculatorPage (WebDriver driver){
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }

    @FindBy(id = "firstInput")
    private WebElement firstInput;
    @FindBy(id = "secondInput")
    WebElement secondInput;

    public void sendNumbers(String sendFirstNumber, String sendSecondNumber){
        firstInput.sendKeys(sendFirstNumber);
        secondInput.sendKeys(sendSecondNumber);
    }

    public WebElement getFirstInput(){
        return firstInput;
    }

    public WebElement getSecondInput(){
        return secondInput;
    }
    public String actualResult (){
        return pageDriver.findElement(By.id("result")).getText();
    }

    public WebElement getLatestCalculation() {
        return pageDriver.findElement(By.cssSelector("ul.latest-results li"));
    }
    public List<WebElement> getListOfCalculation(){
        return pageDriver.findElements(By.cssSelector("ul.latest-results li"));
    }
}
