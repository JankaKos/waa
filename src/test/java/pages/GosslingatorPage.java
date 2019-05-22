package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GosslingatorPage {
    WebDriver pageDriver;

    public GosslingatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }


    public void addRyan() {
        pageDriver.findElement(By.id("addRyan")).click();
    }
    public String actualNumberOfRyans(){
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }
    public String actualDescription(){
        return  pageDriver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }
    public int getNumberOfRyanImages(){
        return pageDriver.findElements(By.cssSelector("img")).size();
    }

}
