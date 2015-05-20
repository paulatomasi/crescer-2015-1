package mestrecuca;

public enum UnidadeMedida {
	GRAMA("grama"), UNIDADE("unidade"), XICARA("xícara"), COLHER_SOPA("colher de sopa");

	
	String nome; 
	private UnidadeMedida( String nome ){
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
}
