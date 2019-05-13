package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickMeBabyOneMoreTime {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //0.spustit prehliadac
        driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom");
    }


@Test
public void itShouldDisplayCorrectText(){
        WebElement addClickButton = driver.findElement(By.id("clickMe"));
        for (int i=0; i<25; i++){
            String actualDescription = driver.findElement(By.cssSelector("p.description")).getText();
            if ( i==0 || i>=5){
                Assert.assertEquals("klikov", actualDescription);
            }
            if (i == 1) {
                Assert.assertEquals("klik", actualDescription);
            }
            if (i >= 2 && i <=4 ) {
                Assert.assertEquals("kliky", actualDescription);
            }
            addClickButton.click();
        }

}
}