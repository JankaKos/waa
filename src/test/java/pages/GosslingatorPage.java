package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GosslingatorPage {
    WebDriver pageDriver;

    @FindBy (id = "addRyan")
    private WebElement addRyanButton;
    @FindBy(css="div.ryan-counter h3")
    private WebElement ryanCounter;


    public GosslingatorPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }


    public void addRyan() {
        addRyanButton.click();
    }
    public String actualNumberOfRyans(){
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }
    public String actualDescription(){
        return ryanCounter.getText();
    }
    public int getNumberOfRyanImages(){
        return pageDriver.findElements(By.cssSelector("img")).size();
    }

}
