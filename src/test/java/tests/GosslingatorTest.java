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

public class GosslingatorTest extends TestBase {


    @Before
    public void openPage() {
        driver.get(BASE_URL + "/gosslingator.php");
    }



    private String actualNumberOfRyans;

    @Test
    public void itShouldRyan() {
        //2.kliknut na button Ryan
        driver.findElement(By.id("addRyan")).

                click();
        //3.overit pocitanie Ryanov
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        Assert.assertEquals("1", actualNumberOfRyans);
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());

        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());


    }

    @Test
    public void itShouldAddTwoRyan() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        //2.kliknut 2x na button Ryan
        addRyanButton.click();
        addRyanButton.click();
        //3.overit pocitanie Ryanov
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDescription);

    }

    @Test

    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());

        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }


    @Test
    public void itShouldItDisplayWarningMessage() {

        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            int numberOfRyanImages = driver.findElements(By.cssSelector("img")).size();
            Assert.assertEquals(i,numberOfRyanImages);
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
        }

        Assert.assertEquals(

                "NUMBER OF\n" +

                        "RYANS\n" +

                        "IS TOO DAMN\n" +

                        "HIGH",

                driver.findElement(By.cssSelector("h1.tooManyRyans")).

                        getText());

    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        int clicksLimit= 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50")|| clicks <= clicksLimit ) {
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpe(){

        Assert.assertEquals(0,driver.findElements(By.cssSelector("img")).size());



    }
}

