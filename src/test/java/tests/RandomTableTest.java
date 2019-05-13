package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RandomTableTest {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost:81/tabulka.php");
    }


    @Test

    public void itShouldPrintLastRow() {

        System.setProperty("webdriver.chrome.driver", "chromedriver74");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:81/tabulka.php");
        // 2. nájdem a vypisem posledny riadok
        driver.findElement(By.xpath("//table/tbody/tr[last()]"));
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }

    @Test

    public void itShouldPrintOneBeforeLastRow() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");

        // 0. spustit prehliadac
        WebDriver driver = new ChromeDriver();
        // 1. otvorit stranku
        driver.get("http://localhost:8888/tabulka.php");
        // 2. nájdem a vypisem meno z predposledného riadku
        driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]"));
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
        //4. zatvorit prehliadac
        driver.close();
        //.5. ukoncit session
        driver.quit();
    }

    @Test
    public void itShoulContainDataForEachRow() {
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement tableRow : tableRows) {
            Assert.assertFalse(tableRow.getText().isEmpty());
            //System.out.println(tableRow.getText());
        }

    }

    @Test
    public void itShoulContainNameForEachRow() {
        List<WebElement> tableRows = driver.findElements(By.xpath("//td[2]"));
        for (WebElement tableRow : tableRows) {
            Assert.assertFalse(tableRow.getText().isEmpty());
            //System.out.println(tableRow.getText());
        }

    }

}