package Filmator;

import java.util.ArrayList;

public class Netflox {
	ArrayList<Filme> listaFilme = new ArrayList<Filme>();

	public static void gerarRelatorio(){
		Genero[] genero = Genero.values();
		for(Genero g : genero){
			System.out.println(g);
		}
	}
	public void adicionarFilme(Filme nome){
		listaFilme.add(nome);
	}	
	public void reproduzirFilme(Filme nome){
		if (listaFilme.contains(nome)){
			nome.genero.adicionarQtd();
			System.out.println("Reproduzindo " + nome);
		}else{
			System.out.println("Filme não encontrado");
		}
	}

}
