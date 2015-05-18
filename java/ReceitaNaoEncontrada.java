package mestrecuca;

public class ReceitaNaoEncontrada extends RuntimeException{
	
	public ReceitaNaoEncontrada(){
		super("Receita não encontrada");
	}
}
