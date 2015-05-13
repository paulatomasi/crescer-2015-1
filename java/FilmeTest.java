package Filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FilmeTest {

	@Test
	public void ator() throws Exception{
		Ator ator1 = new Ator("Ator 1");
		Ator ator2 = new Ator("Ator 2");
		Ator ator3 = new Ator("Sla");
		Filme filme = new Filme("Qualquer filme", Genero.DRAMA);
		
		filme.listaAtor.add(ator1);
		filme.listaAtor.add(ator2);
		filme.listaAtor.add(ator3);
		
		ArrayList<Ator> actual = filme.temAtor("Ator");
		ArrayList<Ator> expected = new ArrayList<Ator>();
		expected.add(ator1);
		expected.add(ator2);
		assertEquals(expected, actual);
	}
	
}
