package Filmator;

public enum Genero {
	ACAO(0),  COMEDIA(0), DRAMA(0), INDEPENDENTES(0), FICCAO(0);
	
	private int qtd;
	private Genero(int qtd){
		this.qtd = qtd;
	}
	public int getQtd() {
		return qtd;
	}
	public void adicionarQtd() {
		this.qtd++;
	}
	public String toString(){
		String resultado = this.name();
		resultado += ": " + this.qtd;
		return resultado;
	}
	
}
