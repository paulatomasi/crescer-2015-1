package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	String nome;
	List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	List<String> instrucao = new ArrayList<String>();

	public Receita(){
		
	}
	
	public Receita(String nome, List<Ingrediente> ingredientes, List<String> instrucao){
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.instrucao = instrucao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
