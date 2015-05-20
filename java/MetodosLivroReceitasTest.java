package mestrecuca;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MetodosLivroReceitasTest {
	
	@Test
	public void protecaoAosAlergicos() throws Exception {
		Ingrediente farinha = new Ingrediente("Farinha", 3, 2.5, UnidadeMedida.XICARA);
		Ingrediente fermento = new Ingrediente("Fermento", 1, 2.25, UnidadeMedida.COLHER_SOPA);
		Ingrediente ovo = new Ingrediente("Ovo", 1, 0.5, UnidadeMedida.UNIDADE);
		
		//LISTA DE INGREDIENTES
		List<Ingrediente> listaIngredientesBolo = new ArrayList<Ingrediente>();
		listaIngredientesBolo.add(farinha);
		listaIngredientesBolo.add(fermento);
		listaIngredientesBolo.add(ovo);

		List<Ingrediente> listaIngredientesPanqueca = new ArrayList<Ingrediente>();
		listaIngredientesPanqueca.add(farinha);
		listaIngredientesPanqueca.add(ovo);		

		//LISTA DE INSTRUCAO
		List<Instrucao> instrucaoBolo = new ArrayList<Instrucao>();
		instrucaoBolo.add(new Instrucao("Misturar e por no forno"));
		List<Instrucao> instrucaoPanqueca = new ArrayList<Instrucao>();
		instrucaoPanqueca.add(new Instrucao("Instrucao"));

		//RECEITAS
		Receita bolo = new Receita("Bolo", listaIngredientesBolo, instrucaoBolo);
		Receita panqueca = new Receita("Panqueca", listaIngredientesPanqueca, instrucaoPanqueca);
		
		//LISTA DE RECEITAS
		List<Receita> listaReceitas = new ArrayList<Receita>();
		listaReceitas.add(bolo);
		listaReceitas.add(panqueca);
		
		//LIVRO DE RECEITAS
		MetodosLivroReceitas livroReceitas = new MetodosLivroReceitas();
		livroReceitas.inserir(bolo);
		livroReceitas.inserir(panqueca);
		
		//LISTA DE INGREDIENTES PROIBIDOS
		List<Ingrediente> listaDeIngredienteProibidos = new ArrayList<Ingrediente>();
		listaDeIngredienteProibidos.add(fermento);
		
		System.out.println(livroReceitas.protecaoAosAlergicos(listaDeIngredienteProibidos));
		System.out.println(livroReceitas.listaCompras(listaReceitas));
	}
	
}