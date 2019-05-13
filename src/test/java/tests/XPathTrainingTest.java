package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XPathTrainingTest {
    WebDriver driver = null;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:81/xpathtrainingcenter.php");


    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom");
    }

    @Test
    public void itShouldDisplayAction() {
        String buttonText = "One more button";
        driver.findElement(By.xpath("//button[contains(text(), '" + buttonText + "')]")).click();
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(), actualMessage
        );
    }


    @Test
    public void itShouldDisplayEnteredMessage() {
        String message = "vonku prsi";

        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.id("hitme")).click();
        //precitam hodnotu zo stranky a ulozim ju do premennej
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();

        Assert.assertEquals(
                "you entered " + message,
                actualMessage);
    }

    @Test
    public void itShouldClickAllButtons() {

        String[] selectedButtons = {"First one", "Second button", "Next button", "One more button", "Danger", "Success", "Warning"};

        for (String button : selectedButtons) {
            WebElement buttonSelect = driver.findElement(By.xpath("//button[contains(text(), '" + button + "')]"));
            buttonSelect.click();
            String expectedMessage = "you clicked " + button.toLowerCase();
            String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    public void itShouldDisplayEverySelect() {
        String[] moznostiSelected = {"vyber si moznost", "Moznost 1", "Moznost 2", "Moznost 3", "Moznost 4", "Moznost 5", "Moznost 6"};
        WebElement selectedMoznost = driver.findElement(By.xpath("//select[1]"));
        for (int i = 6; i >= 0 ; i--) {
            new Select(selectedMoznost).selectByIndex(i);
            String s = moznostiSelected[i];
            String expectedMessage = "you have chosen " + s.toLowerCase();
            String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    public void itShouldDisplayEverySelectNumberTwo() {
        String[] moznostiSelected = {"vyber si option", "Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"};
        WebElement selectedMoznost = driver.findElement(By.xpath("//select[2]"));
        for (int i = 6; i >= 0; i--) {
            new Select(selectedMoznost).selectByIndex(i);
            String s = moznostiSelected[i];
            String expectedMessage = "you have chosen " + s.toLowerCase();
            String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

}