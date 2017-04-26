package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Testing class of IPokemonMetadataProvider interface
 * @author Eyres
 */
@RunWith(MockitoJUnitRunner.class)
public class IPokemonMetadataProviderTest {

    @Mock
    protected IPokemonMetadataProvider pokemonMetadataProviderMock;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    /**
     * IPokemonMetadataProvider mock's configuration
     * @throws PokedexException
     */
	protected void configurePokemonMetadataProviderMock() throws PokedexException {
		when(this.pokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
	}

    @Before
    public void setUp() throws PokedexException {
        this.configurePokemonMetadataProviderMock();
    }
    
    /**
	 * Retrieves and returns the metadata for the pokemon
	 * denoted by the given <tt>index</tt>.
	 */
	@Test
	public void testGetPokemonMetadata() {
		try {
			PokemonMetadata metadata = this.pokemonMetadataProviderMock.getPokemonMetadata(0);
			
			Assert.assertEquals("Bulbizarre", metadata.getName());
			Assert.assertEquals(0, metadata.getIndex());
			Assert.assertEquals(126, metadata.getAttack());
			Assert.assertEquals(126, metadata.getDefense());
			Assert.assertEquals(90, metadata.getStamina());
		}
		catch (PokedexException e) {
			e.printStackTrace();
		}
	}
}
