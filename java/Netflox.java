package Filmator;

import java.util.ArrayList;

public class Netflox {
	ArrayList<Filme> listaFilme = new ArrayList<Filme>();
	
	public static void geraRelatorio(){
		Genero[] genero = Genero.values();
		for(Genero g : genero){
			System.out.println(g);
		}
	}
	public static void reproduzirFilme(Filme nome){
		nome.genero.adicionarQtd();
		System.out.println("Reproduzindo " + nome);
	}
	public static void main(String[] args) {
		geraRelatorio();
	}
	
}
