package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OdkazovacTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
    }

    @Test
    public void addNew () throws InterruptedException {
        String titulok = "titulok";
        String mojeMeno = "Moje meno";
        String textOdkazu = "Ahoj, dakujem za prispevok";

        driver.findElement(By.name("title")).sendKeys(titulok);
        driver.findElement(By.name("author")).sendKeys(mojeMeno);
        driver.findElement(By.name("message")).sendKeys(textOdkazu);

        driver.findElement(By.cssSelector("button.btn-block")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.sin ")).isDisplayed());
        WebElement detailButton = driver.findElement(By.cssSelector("ul.list-of-sins li:last-child"));
        Assert.assertTrue(detailButton.isDisplayed());
        detailButton.click();
        Thread.sleep(3000);

      //bonus
        WebElement detailOdkazu = driver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(titulok,detailOdkazu.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(mojeMeno, detailOdkazu.findElement(By.cssSelector("h4.recipent")).getText());
        Assert.assertEquals(textOdkazu,detailOdkazu.findElement(By.cssSelector("p")).getText());

    }

}
