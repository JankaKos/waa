package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PokemonPage {
    WebDriver pageDriver;


    public PokemonPage(WebDriver driver) {
        this.pageDriver = driver;
    }
    public void selectPokemon (String pokemonToSelect){
        WebElement pokemonSelect = pageDriver.findElement(By.cssSelector("select"));
        new Select(pokemonSelect).selectByVisibleText(pokemonToSelect);
    }

    public String actualMessage(){
        return pageDriver.findElement(By.cssSelector("div.pokemon h3")).getText();
    }

    public String getExpectedMessage(String pokemonName){
        return  String.format("I choose you %s !", pokemonName);
    }
}