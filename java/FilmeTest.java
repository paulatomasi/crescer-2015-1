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
	
	@Test
	public void reproduzindo() throws Exception{
		Filme filme = new Filme("Qualquer filme", Genero.DRAMA);
		Netflox.adicionarFilme(filme);
		Netflox.reproduzirFilme(filme);
		int actual = filme.genero.getQtd();
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void reproduzindoTresFilmesEUmNaoExiste() throws Exception{
		Filme filme = new Filme("Filme reproduzido duas vezes", Genero.DRAMA);
		Filme filme2 = new Filme("Filme não adicionado", Genero.ACAO);
		Filme filme3 = new Filme("Filme reproduzido uma vez", Genero.INDEPENDENTES);
		Netflox.adicionarFilme(filme);
		Netflox.adicionarFilme(filme3);
		Netflox.reproduzirFilme(filme);
		Netflox.reproduzirFilme(filme);
		Netflox.reproduzirFilme(filme2);
		Netflox.reproduzirFilme(filme3);
		int filmeReproduzidoDuasVezesAtual = filme.genero.getQtd();
		int filmeReproduzidoDuasVezesEsperado = 3;
		int filmeNaoAdicionadoAtual = filme2.genero.getQtd();
		int filmeNaoAdicionadoEsperado = 0;
		int filmeReproduzidoUmaVezAtual = filme3.genero.getQtd();
		int filmeReproduzidoUmaVezEsperado = 1;
		assertEquals(filmeReproduzidoDuasVezesEsperado, filmeReproduzidoDuasVezesAtual);
		assertEquals(filmeNaoAdicionadoEsperado, filmeNaoAdicionadoAtual);
		assertEquals(filmeReproduzidoUmaVezEsperado, filmeReproduzidoUmaVezAtual);
	}
}
