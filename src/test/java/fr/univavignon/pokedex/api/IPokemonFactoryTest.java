package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testing class of IPokemonFactory interface
 * @author Eyres
 */
@RunWith(MockitoJUnitRunner.class)
public class IPokemonFactoryTest {

	@Mock
    protected IPokemonFactory pokemonFactory;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    /*********************************************************************************************/
    /************************************** INITIALIZATION ***************************************/
    /*********************************************************************************************/

    /**
     * IPokemonFactory mock's configuration
     * @throws PokedexException
     */
	protected void configurePokemonFactory() throws PokedexException {
		when(this.pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
	}

    @Before
    public void setUp() throws PokedexException {
        this.configurePokemonFactory();
    }

    /*********************************************************************************************/
    /******************************************* TESTS *******************************************/
    /*********************************************************************************************/

    /**
	 * Test of the createPokemon method
	 */
    @Test
	public void testCreatePokemon() {
		int index = 0;
		int cp = 613;
		int hp = 64;
		int dust = 4000;
		int candy = 4;
		
		Pokemon pokemon = this.pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		
		Assert.assertEquals("Bulbizarre", pokemon.getName());
		Assert.assertEquals(126, pokemon.getAttack());
		Assert.assertEquals(126, pokemon.getDefense());
		Assert.assertEquals(90, pokemon.getStamina());
		Assert.assertEquals(56, pokemon.getIv(), 0);
		
		Assert.assertEquals(index, pokemon.getIndex());
		Assert.assertEquals(cp, pokemon.getCp());
		Assert.assertEquals(hp, pokemon.getHp());
		Assert.assertEquals(dust, pokemon.getDust());
		Assert.assertEquals(candy, pokemon.getCandy());
	}
}
