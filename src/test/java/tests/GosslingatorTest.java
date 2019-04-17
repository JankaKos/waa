package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest<http> {

 @Test
 public void itShouldAddOneRyan(){
  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  //0.spustit prehliadac
  WebDriver driver = new ChromeDriver();
     //1.otvorit stranku
  driver.get("http://localhost/gosslingator.php");
     //2.kliknut na button Ryan
  driver.findElement(By.id("addRyan")).click();
     //3.overit pocitanie Ryanov
  Assert.assertEquals("1", driver.findElement(By.id("ryanCounter")).getText());
     //4.zavriet prehliadac
  driver.close();
     //5.ukoncit session
  driver.quit();

 }

 @Test
 public void itShouldAddTwoRyan(){
  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
  //0.spustit prehliadac
  WebDriver driver = new ChromeDriver();
  //1.otvorit stranku
  driver.get("http://localhost/gosslingator.php");
  //2.kliknut 2x na button Ryan
  driver.findElement(By.id("addRyan")).click();
  driver.findElement(By.id("addRyan")).click();
  //3.overit pocitanie Ryanov
  Assert.assertEquals("2", driver.findElement(By.id("ryanCounter")).getText());
  //4.zavriet prehliadac
  driver.close();
  //5.ukoncit session
  driver.quit();

 }
}
