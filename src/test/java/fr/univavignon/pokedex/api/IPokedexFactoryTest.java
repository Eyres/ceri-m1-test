package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testing class of IPokedexFactory interface
 * @author Eyres
 */
@RunWith(MockitoJUnitRunner.class)
public class IPokedexFactoryTest {

    /*********************************************************************************************/
    /**************************************** ATTRIBUTES *****************************************/
    /*********************************************************************************************/

	@Mock
	private IPokedexFactory pokedexFactory;
	
	@Mock
	private IPokemonMetadataProvider pokemonMetadataProvider;
	
	@Mock
	private IPokemonFactory pokemonFactory;
	
	@Mock
	private IPokedex pokedex;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	/*********************************************************************************************/
    /************************************** INITIALIZATION ***************************************/
    /*********************************************************************************************/

	@Before 
	public void setUp() throws PokedexException{
		this.configurePokedexFactory();
	}
	public void configurePokedexFactory(){
		when(this.pokedexFactory.createPokedex(this.pokemonMetadataProvider, this.pokemonFactory))
			.thenReturn(this.pokedex);
	}

	/*********************************************************************************************/
    /******************************************* TESTS *******************************************/
    /*********************************************************************************************/

	@Test
	public void testCreatePokedex(){
		IPokedex pokedex = this.pokedexFactory.createPokedex(this.pokemonMetadataProvider, this.pokemonFactory);
		assertNotNull(pokedex);
	}
}
