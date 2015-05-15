package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FilmeTest {

	@Test
	public void ator() throws Exception{
		Ator ator1 = new Ator("Ator 1");
		Ator ator2 = new Ator("Ator 2");
		Ator ator3 = new Ator("Sla");
		Filme filme = new Filme("Qualquer filme", Genero.DRAMA);

		filme.listaElenco.add(ator1);
		filme.listaElenco.add(ator2);
		filme.listaElenco.add(ator3);

		List<Ator> actual = filme.buscarAtor("Ator");
		List<Ator> expected = new ArrayList<Ator>();
		expected.add(ator1);
		expected.add(ator2);
		assertEquals(expected, actual);
	}

	@Test
	public void reproduzindo() throws Exception{
		Netflox netflox = new Netflox();
		Filme filme = new Filme("Qualquer filme", Genero.DRAMA);
		netflox.adicionarFilme(filme);
		netflox.reproduzirFilme(filme);
		int actual = netflox.getEstatisticas().get(Genero.DRAMA);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void reproduzindoTresFilmesEUmNaoExiste() throws Exception{
		Netflox netflox = new Netflox();
		Filme filme = new Filme("Filme reproduzido duas vezes", Genero.DRAMA);
		Filme filme2 = new Filme("Filme não adicionado", Genero.ACAO);
		Filme filme3 = new Filme("Filme reproduzido uma vez", Genero.INDEPENDENTES);

		netflox.adicionarFilme(filme);
		netflox.adicionarFilme(filme3);

		netflox.reproduzirFilme(filme);
		netflox.reproduzirFilme(filme);
		netflox.reproduzirFilme(filme2);
		netflox.reproduzirFilme(filme3);

		int filmeReproduzidoDuasVezesAtual = netflox.getEstatisticas().get(Genero.DRAMA);
		int filmeReproduzidoDuasVezesEsperado = 2;
		Integer filmeNaoAdicionadoAtual = netflox.getEstatisticas().get(Genero.ACAO);
		Integer filmeNaoAdicionadoEsperado = null;
		int filmeReproduzidoUmaVezAtual = netflox.getEstatisticas().get(Genero.INDEPENDENTES);
		int filmeReproduzidoUmaVezEsperado = 1;

		assertEquals(filmeReproduzidoDuasVezesEsperado, filmeReproduzidoDuasVezesAtual);
		assertEquals(filmeNaoAdicionadoEsperado, filmeNaoAdicionadoAtual);
		assertEquals(filmeReproduzidoUmaVezEsperado, filmeReproduzidoUmaVezAtual);
	}
}