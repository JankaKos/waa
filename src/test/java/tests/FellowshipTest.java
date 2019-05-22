package tests;
import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FellowshipTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/fellowship.php");
    }


    @Test
    public void itShouldContainNameForEachFellow() {
        List<WebElement> fellowElements = getElements();
        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(itShouldFindElement(fellowElement).isEmpty());
        }
        //System.out.println("ahoj");
    }

    @Test
    public void itShouldContainSpecifiedFellow() {
        List<WebElement> fellowElements = getElements();
        List<String> fellowNames = new ArrayList<String>();

        for (WebElement fellowElement : fellowElements) {
            fellowNames.add(itShouldFindElement(fellowElement));
        }
        System.out.println(fellowNames);
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
    }


    //System.out.println("ahoj");

    @Test
    public void itShouldDisplayComplete() {
        String[] fellowToSelected = {"Samwise", "Gimli", "Gandalf", "Aragorn"};
        for (String fellow : fellowToSelected) {
            itShouldClickFellow(fellow);
        }
        Assert.assertEquals("complete", driver.findElement(By.cssSelector("div.points-left h3"))
                .getText()
                .toLowerCase());
    }

    @Test
    public void itShouldDisplayCountOf() {


        Assert.assertEquals("25", driver.findElement(By.cssSelector("div.points-left h2"))
                .getText());
    }

    @Test
    public void itShouldDisplayPointsForEachFellow() {
        List<WebElement> displayedFellows = getElements();

        for (WebElement displayedFellow : displayedFellows) {
            String actualPoints = displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText();
            Assert.assertFalse(actualPoints.isEmpty());
        }

    }


    private void itShouldClickFellow(String name) {
        driver.findElement(By.xpath("//div[h1[contains(text(), '" + name + "')]]")).click();

    }

    private String itShouldFindElement(WebElement element) {
        return element.findElement(By.cssSelector("h1")).getText();
    }


    private List<WebElement> getElements() {
        return driver.findElements(By.cssSelector("ul.list-of-fellows li"));
    }

}