package tests;

import base.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RandomTableTest extends TestBase {

    @Before
    public void openPage() {

        driver.get(BASE_URL + "/tabulka.php");
    }


    @Test

    public void itShouldPrintLastRow() {
        driver.findElement(By.xpath("//table/tbody/tr[last()]"));
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());


    }

    @Test

    public void itShouldPrintOneBeforeLastRow() {
        driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]"));
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
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