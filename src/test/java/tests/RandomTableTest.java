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
        System.out.println(itShouldFindLastRow());
    }

    @Test

    public void itShouldPrintOneBeforeLastRow() {
        String oneBeforeLastRow = driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText();
        System.out.println(oneBeforeLastRow);
    }

    @Test
    public void itShoulContainDataForEachRow() {
        for (WebElement tableRow : getTableRows()) {
            Assert.assertFalse(tableRow.getText().isEmpty());
        }
    }

    @Test
    public void itShoulContainNameForEachRow() {
        for (WebElement tableRow : getTableRows()) {
            Assert.assertFalse(tableRow.getText().isEmpty());
            //System.out.println(tableRow.getText());
        }
    }

    private String itShouldFindLastRow() {
        return driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText();
    }

    private List<WebElement> getTableRows(){
        return driver.findElements(By.cssSelector("table tbody tr"));
    }
}