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
import pages.PokemonPage;

public class PokemonTest extends TestBase {
    private PokemonPage pokemonPage;
    @Before
    public void openPage() {
        driver.get(BASE_URL + "/vybersi.php");
    pokemonPage = new PokemonPage(driver);}

  @Test
    public void itShouldSelectPikachu(){
        String selectedPokemon= "Pikachu";
        String[] selectedPokemons= {"Pikachu", "Bulbasaur","Charmander","Squirtle", "Diglett", "Geodude"};
        for (String pokemon : selectedPokemons) {
            pokemonPage.selectPokemon(pokemon);
            Assert.assertEquals(pokemonPage.getExpectedMessage(pokemon), pokemonPage.actualMessage());
        }
    }


}