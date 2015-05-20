package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	String nome;
	List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	List<Instrucao> instrucao = new ArrayList<Instrucao>();

	public Receita(String nome, List<Ingrediente> ingredientes, List<Instrucao> instrucao){
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

	public String toString(){
		return getNome();
	}
	public boolean pesquisar(Ingrediente ingrediente){
		boolean pode = true;
		for (Ingrediente ingredienteAtual : ingredientes) {
			if( ingredienteAtual.getNome().equals(ingrediente.getNome())){
				pode = false;
			}
		}
		return pode;
	}
}
