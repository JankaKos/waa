package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FellowshipPage {

    WebDriver pageDriver;


    public FellowshipPage(WebDriver driver) {
        this.pageDriver = driver;}

    public void itShouldClickFellow(String name) {
        pageDriver.findElement(By.xpath("//div[h1[contains(text(), '" + name + "')]]")).click();

    }

    public String itShouldFindElement(WebElement element) {
        return element.findElement(By.cssSelector("h1")).getText();
    }


    public List<WebElement> getElements() {
        return pageDriver.findElements(By.cssSelector("ul.list-of-fellows li"));
    }



}
