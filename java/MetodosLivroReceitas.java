package mestrecuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MetodosLivroReceitas {

	List<Receita> livroReceitas = new ArrayList<Receita>();

	//Inserir nova receita no livro de receitas
	public void inserir(Receita receita){
		boolean receitaSemNome = receita.getNome().isEmpty();
		boolean receitaNula = receita.equals(null);
		if (receitaSemNome != true || receitaNula != true){
			livroReceitas.add(receita);
		}else{
			System.out.println("Receita nula ou sem nome");
		}
	}
	
	//Excluir uma receita
		/*for (int x = 0; x<=livroReceitas.size(); x++){
			if (livroReceitas.get(x).getNome() == nome){
				livroReceitas.remove(x);
			}
		}*/
		public void excluir(String nome){
			Receita receita = buscaReceitaPeloNome(nome);
			int indiceReceita = livroReceitas.indexOf(receita);
			livroReceitas.remove(indiceReceita);
		}

	//Atualizar uma receita
	public void atualizar(String nome, Receita receitaAtualizada){
		for (int x=0; x<=livroReceitas.size(); x++){
			if (livroReceitas.get(x).getNome().equals(nome)){
				livroReceitas.set(x, receitaAtualizada);
				break;
			}
		}
	}

	//Listar todas receitas do livro de receitas
	public List<Receita> getTodasReceitas(){
		return livroReceitas;
	}

	//Buscar receita por nome
	/*for (int x = 0; x<=livroReceitas.size(); x++){
		if (livroReceitas.get(x).getNome() == nome){
			return livroReceitas.get(x);
		}
	}*/
	public Receita buscaReceitaPeloNome(String nome){
		for(Receita receita : livroReceitas){
			if(receita.getNome().equals(nome)){
				return receita;
			}
		}
		throw new ReceitaNaoEncontrada();
	}
	
	//Calcula o preço total da receita
	public void calcularPreco(Receita receita){
		for (int x = 0; x<=receita.getIngredientes().size(); x++){
			double valorTotal =+ receita.getIngredientes().get(x).getPreco();
		}
	}

	//Calcula valor total de uma lista de receitas
	public void valorTotalLista(List<Receita> lista){
		for (int x = 0; x<=lista.size(); x++){
			calcularPreco(lista.get(x));
		}
	}

	//Retorna receitas sem os ingredientes proibidos
	/*for (Receita receitaAtual : livroReceitas){	
		List<Ingrediente> listaIngredientesDaReceitaAtual = receitaAtual.getIngredientes();
		for(int x = 0; x < listaIngredientesDaReceitaAtual.size(); x++){
			Ingrediente ingredienteAtual = listaIngredientesDaReceitaAtual.get(x);
			if(!ingredientesProibidos.contains(ingredienteAtual) && !receitasLegais.contains(receitaAtual)){
				receitasLegais.add(receitaAtual);
				continue;
			} else if(ingredientesProibidos.contains(ingredienteAtual) && receitasLegais.contains(receitaAtual)){
				receitasLegais.remove(receitaAtual);
				break;
			}
			break;
		}
	}*/
	public List<Receita> protecaoAosAlergicos(List<Ingrediente> ingredientesProibidos){
		List<Receita> receitasLegais = new ArrayList<Receita>();
		for (Receita receita : livroReceitas){
			if (!receita.possuiIngredienteProibido(ingredientesProibidos)){
				receitasLegais.add(receita);
			}
		}
		return receitasLegais;
	}

	//Retorna lista de compras
	public List<String> listaCompras (List<Receita> receita){
		List<String> listaCompras = new ArrayList<String>();
		Map<String, Ingrediente> ingrediente = new HashMap<String, Ingrediente>();
		for (Receita receitaAtual : receita) {
			for (Ingrediente ingredienteAtual : receitaAtual.getIngredientes()) {
				String chave = (ingredienteAtual.getMedida().getNome());
				if(ingrediente.containsKey(chave)) {
					double quantidade = ingredienteAtual.getQuantidade() + ingrediente.get(chave).getQuantidade();
					double valor = ingredienteAtual.getPreco() + ingrediente.get(chave).getPreco();
					Ingrediente ingredienteIncremetado = new Ingrediente(ingredienteAtual.getNome(), quantidade, valor, ingredienteAtual.getMedida());
					ingrediente.put(chave, ingredienteIncremetado);
				}else{
					ingrediente.put(chave, ingredienteAtual);
				}
			}
		}
		for (Ingrediente value : ingrediente.values()) {
			listaCompras.add(value.getQuantidade() + " " + value.getMedida().getNome() + " "  +   value.getNome());
		}
		return listaCompras;
	}

}
