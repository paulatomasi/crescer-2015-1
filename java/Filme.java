package filmator;

import java.util.ArrayList;
import java.util.List;

public class Filme {

	String nome;
	Genero genero;
	List<Ator> listaElenco = new ArrayList<Ator>();

	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}
	public void adicionarAtor(Ator ator){
		listaElenco.add(ator);
	}
	public List<Ator> buscarAtor(String str){
		List<Ator>	listContains = new ArrayList<Ator>();
		for(Ator ator : listaElenco){
			if (ator.getNome().contains(str)){
				listContains.add(ator);
			}
		}
		return listContains;
	}
	public String toString(){
		return this.nome;
	}

	public Genero getGenero() {
		return genero;
	}

}
