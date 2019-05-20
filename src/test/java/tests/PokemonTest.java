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
import org.openqa.selenium.support.ui.Select;

public class PokemonTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/vybersi.php");
    }

  @Test
    public void itShouldSelectPikachu(){
        String selectedPokemon= "Pikachu";
        String[] selectedPokemons= {"Pikachu", "Bulbasaur","Charmander","Squirtle", "Diglett", "Geodude"};
        for (String pokemon : selectedPokemons) {
            selectPokemon(pokemon);
            Assert.assertEquals(getExpectedMessage(pokemon), actualMessage());
        }
    }

    private void selectPokemon (String pokemonToSelect){
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        new Select(pokemonSelect).selectByVisibleText(pokemonToSelect);
    }

    private String actualMessage(){
        return driver.findElement(By.cssSelector("div.pokemon h3")).getText();
    }

    private String getExpectedMessage(String pokemonName){
       return  String.format("I choose you %s !", pokemonName);
    }
}