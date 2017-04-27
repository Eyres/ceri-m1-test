package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testing class of IPokedex interface
 * @author Eyres
 */
@RunWith(MockitoJUnitRunner.class)
public class IPokedexTest {

	/*********************************************************************************************/
    /**************************************** ATTRIBUTES *****************************************/
    /*********************************************************************************************/

	@Mock
	private IPokedex pokedex;
		
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	
	public List<Pokemon> pokemonList;

	/*********************************************************************************************/
    /************************************** INITIALIZATION ***************************************/
    /*********************************************************************************************/

	@Before 
	public void setUp() throws PokedexException{
		this.configureIPokedex();
	}

	public void configureIPokedex() throws PokedexException{

		Pokemon bulbizzare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		this.pokemonList = new ArrayList<Pokemon>();
		this.pokemonList.add(bulbizzare);
		
		when(this.pokedex.addPokemon(bulbizzare))
			.thenReturn(0);
		
		when(this.pokedex.size())
			.thenReturn(1);
		
		when(pokedex.getPokemon(0))
		.thenReturn(this.pokemonList.get(0));
		
		when(this.pokedex.getPokemons())
			.thenReturn(this.pokemonList);
			
		when(pokedex.getPokemons(null))
			.thenReturn(this.pokemonList);
	}

	/*********************************************************************************************/
    /******************************************* TESTS *******************************************/
    /*********************************************************************************************/

	@Test
	public void testAddPokemon() throws PokedexException{
		Pokemon bulbizzare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		int index = this.pokedex.addPokemon(bulbizzare);
		
		assertEquals(0, index);
	}

	@Test
	public void testSize() throws PokedexException{
		Pokemon bulbizzare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		this.pokedex.addPokemon(bulbizzare);
		
		assertEquals(1, this.pokedex.size());
	}
	
	@Test
	public void testGetPokemon() throws PokedexException{
		Pokemon bulbizzare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

		this.pokedex.addPokemon(bulbizzare);
		Pokemon pokemon = this.pokedex.getPokemon(0);
		
		assertEquals(pokemonList.get(0), pokemon);

	}
	
	@Test
	public void testGetPokemons() throws PokedexException{
		Pokemon bulbizzare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

		this.pokedex.addPokemon(bulbizzare);
		List<Pokemon> pokeList = this.pokedex.getPokemons();
		
		assertEquals(1, pokeList.size());
		assertTrue(pokeList.contains(this.pokemonList.get(0)));
		assertFalse(pokeList.contains(aquali));
	}

}
