package mestrecuca;

import java.util.ArrayList;
import java.util.List;


public class MetodosLivroReceitas {

	List<Receita> livroReceitas = new ArrayList<Receita>();

	//Inserir nova receita no livro de receitas
	public void inserir(Receita receita){
		if (receita.nome.isEmpty() || receita.equals(null)){
			System.out.println("Erro.");
		}else{
			livroReceitas.add(receita);
		}
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

	//Excluir uma receita
	public void excluir(String nome){
		for (int x = 0; x<=livroReceitas.size(); x++){
			if (livroReceitas.get(x).getNome() == nome){
				livroReceitas.remove(x);
			}
		}
	}
	
	//Listar todas receitas do livro de receitas
	public List<Receita> getTodasReceitas(){
		return livroReceitas;
	}

	//Buscar receita por nome
	public Receita buscaReceitaPeloNome(String nome){
		for (int x = 0; x<=livroReceitas.size(); x++){
			if (livroReceitas.get(x).getNome() == nome){
				return livroReceitas.get(x);
			}
		}
		throw new ReceitaNaoEncontrada();
	}
}
