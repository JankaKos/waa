package tests;
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

public class FellowshipTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:81/fellowship.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom");
    }

@Test
    public void itShouldContainNameForEachFellow(){
    List<WebElement> fellowElements =driver.findElements(By.cssSelector("ul.list-of-fellows li"));
    for (WebElement fellowElement : fellowElements) {
        String nameFellow = fellowElement.findElement(By.cssSelector("h1")).getText();

        Assert.assertFalse(nameFellow.isEmpty());
    }
    //System.out.println("ahoj");
}

    @Test
    public void itShouldContainSpecifiedFellow(){
        List<WebElement> fellowElements =driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        List<String> fellowNames = new ArrayList<String>();

        for (WebElement fellowElement : fellowElements) {
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
        }
        //System.out.println("ahoj");

    @Test
    public void itShouldDisplayComplete (){
        String[] fellowToSelected = {"Samwise", "Gimli", "Gandalf", "Aragorn"};
        for (String fellow : fellowToSelected) {
            driver.findElement(By.xpath("//div[h1[contains(text(), '" + fellow + "')]]")).click();
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
        List<WebElement> displayedFellows = driver.findElements(By.cssSelector("ul.list-of-fellows li"));

        for (WebElement displayedFellow : displayedFellows) {
            String actualPoints = displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText();
            Assert.assertEquals(actualPoints.isEmpty());

        }

    }

}
