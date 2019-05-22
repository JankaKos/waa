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
import org.openqa.selenium.support.ui.Select;

public class XPathTrainingTest extends TestBase {


    @Before
    public void openPage() {

        driver.get(BASE_URL + "/xpathtrainingcenter.php");
    }

    @Test
    public void itShouldDisplayAction() {
        String buttonText = "One more button";
        driver.findElement(By.xpath("//button[contains(text(), '" + buttonText + "')]")).click();
        Assert.assertEquals("you clicked " + buttonText.toLowerCase(), actualMessage());
    }


    @Test
    public void itShouldDisplayEnteredMessage() {
        String message = "vonku prsi";
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.id("hitme")).click();
        Assert.assertEquals("you entered " + message, actualMessage());
    }

    @Test
    public void itShouldClickAllButtons() {

        String[] selectedButtons = {"First one", "Second button", "Next button", "One more button", "Danger", "Success", "Warning"};

        for (String button : selectedButtons) {
            itShouldClickButton(button);
            String expectedMessage = "you clicked " + button.toLowerCase();
            Assert.assertEquals(expectedMessage, actualMessage());
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
            Assert.assertEquals(expectedMessage, actualMessage());
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
            Assert.assertEquals(expectedMessage, actualMessage());
        }
    }

    private void itShouldClickButton(String button) {
        driver.findElement(By.xpath("//button[contains(text(), '" + button + "')]")).click();
    }

    private String actualMessage() {
        return driver.findElement(By.cssSelector("div.output h2 span")).getText();
    }
}