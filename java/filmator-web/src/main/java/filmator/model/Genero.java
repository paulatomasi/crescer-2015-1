package filmator.model;

public enum Genero {
	ACAO("Ação"),
	ANIMACAO("Animação"), 
	COMEDIA("Comédia"), 
	DRAMA("Drama"), 
	INDEPENDENTE("Independente"), 
	FICCAO("Ficção"), 
	ROMANCE("Romance");

	private String descricao;

	private Genero(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
