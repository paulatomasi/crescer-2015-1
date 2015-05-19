package mestrecuca;

public class Ingrediente {


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidade != other.unidade)
			return false;
		return true;
	}

	String nome;
	double quantidade;
	UnidadeMedida unidade;
	double preco;
	
	public Ingrediente(String nome, double quantidade, double preco, UnidadeMedida unidade){
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return this.nome;
	}

}
