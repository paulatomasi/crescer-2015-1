package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	
	public Filme(){
	}
	
	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
