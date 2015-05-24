package filmator.model;

public enum Genero {
	ACAO("Ação"),  COMEDIA("Comédia"), DRAMA("Drama"), INDEPENDENTE("Independente"), FICCAO("Ficção");
	
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
