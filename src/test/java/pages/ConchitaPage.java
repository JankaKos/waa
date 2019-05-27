package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConchitaPage {
        WebDriver pageDriver;
    @FindBy (xpath= "//input[@value='wurst']")
    public WebElement wurst;
    @FindBy(xpath="//input[@value='conchita']")
    public WebElement conchita;

        public ConchitaPage(WebDriver driver) {
            this.pageDriver = driver;
            PageFactory.initElements(pageDriver,this);
        }

    public void clickWurst (){
        wurst.click();
    }


    }
