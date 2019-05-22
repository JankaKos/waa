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
import pages.GosslingatorPage;

public class GosslingatorTest extends TestBase {


    @Before
    public void openPage() {
        driver.get(BASE_URL + "/gosslingator.php");
    }


    private String actualNumberOfRyans;

    @Test
    public void itShouldAddRyan() {
        //2.kliknut na button Ryan
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        gossPage.addRyan();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("1", gossPage.actualNumberOfRyans());
        System.out.println("Number of ryans: " + gossPage.actualNumberOfRyans());

        Assert.assertEquals("ryan", gossPage.actualDescription());


    }

    @Test
    public void itShouldAddTwoRyan() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        gossPage.addRyan();
        gossPage.addRyan();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("2", gossPage.actualNumberOfRyans());
        Assert.assertEquals("ryans", gossPage.actualDescription());
    }

    @Test

    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }


    @Test
    public void itShouldItDisplayWarningMessage() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        for (int i = 0; i < 50; i++) {
            Assert.assertEquals(i, gossPage.getNumberOfRyanImages());
            gossPage.addRyan();
            Assert.assertEquals(String.valueOf(i + 1), gossPage.actualNumberOfRyans());
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", gossPage.actualDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", gossPage.actualDescription());
            }
        }

        Assert.assertEquals(

                "NUMBER OF\n" +

                        "RYANS\n" +

                        "IS TOO DAMN\n" +

                        "HIGH",

                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        gossPage.actualNumberOfRyans();
        int clicksLimit= 30;
        int clicks = 0;
        while (!gossPage.actualNumberOfRyans().equals("50")|| clicks <= clicksLimit ) {
            gossPage.addRyan();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpe(){
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        Assert.assertEquals(0,gossPage.getNumberOfRyanImages());

    }




}

