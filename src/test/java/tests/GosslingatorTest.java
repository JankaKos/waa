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
    public void itShouldAddRyan() {
        //2.kliknut na button Ryan
        addRyan();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("1", actualNumberOfRyans());
        System.out.println("Number of ryans: " + actualNumberOfRyans());

        Assert.assertEquals("ryan", actualDescription());


    }

    @Test
    public void itShouldAddTwoRyan() {
        addRyan();
        addRyan();
        //3.overit pocitanie Ryanov
        Assert.assertEquals("2", actualNumberOfRyans());
        Assert.assertEquals("ryans", actualDescription());
    }

    @Test

    public void itShouldDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }


    @Test
    public void itShouldItDisplayWarningMessage() {
        for (int i = 0; i < 50; i++) {
            Assert.assertEquals(i, getNumberOfRyanImages());
            addRyan();
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans());
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription());
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

        actualNumberOfRyans();
        int clicksLimit= 30;
        int clicks = 0;
        while (!actualNumberOfRyans().equals("50")|| clicks <= clicksLimit ) {
            addRyan();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpe(){

        Assert.assertEquals(0,getNumberOfRyanImages());

    }

    private void addRyan (){
        driver.findElement(By.id("addRyan")).click();
    }
    private String actualNumberOfRyans(){
       return driver.findElement(By.id("ryanCounter")).getText();
    }
    private String actualDescription(){
        return  driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }
    private int getNumberOfRyanImages(){
        return driver.findElements(By.cssSelector("img")).size();
    }
}

