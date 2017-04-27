package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testing class of IPokemonTrainerFactory interface
 * @author Eyres
 */
@RunWith(MockitoJUnitRunner.class)
public class IPokemonTrainerFactoryTest {
	
	/*********************************************************************************************/
    /**************************************** ATTRIBUTES *****************************************/
    /*********************************************************************************************/

	@Mock
	private IPokedexFactory pokedexFactory;

	@Mock 
	private IPokedex pokedex;

	@Mock
	private IPokemonTrainerFactory pokemonTrainerFactory;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/*********************************************************************************************/
    /************************************** INITIALIZATION ***************************************/
    /*********************************************************************************************/

	@Before 
	public void setUp() throws PokedexException{
		this.configureIPokemonTrainerFactory();
	}

	public void configureIPokemonTrainerFactory() throws PokedexException{
		
		when(pokemonTrainerFactory.createTrainer("red", Team.MYSTIC, pokedexFactory))
			.thenReturn(new PokemonTrainer("red",Team.MYSTIC,pokedex));
	}

	/*********************************************************************************************/
    /******************************************* TESTS *******************************************/
    /*********************************************************************************************/

	@Test
	public void testCreateTrainer(){
		PokemonTrainer red = pokemonTrainerFactory.createTrainer("red", Team.MYSTIC, pokedexFactory);
		assertNotNull(red);
		assertEquals(red.getName(),"red");
		assertEquals(red.getTeam(),Team.MYSTIC);
	}
}
