package Filmator;

import java.util.ArrayList;

public class Filme {

	String nome;
	Genero genero;
	ArrayList<Ator> listaAtor = new ArrayList<Ator>();

	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}
	public void listaAtor(Ator ator){
		listaAtor.add(ator);
	}
	public ArrayList<Ator> temAtor(String str){
		ArrayList<Ator>	listContains = new ArrayList<Ator>();
		for(Ator ator : listaAtor){
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
