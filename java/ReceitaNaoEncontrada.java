package mestrecuca;

public class ReceitaNaoEncontrada extends RuntimeException{
	
	public ReceitaNaoEncontrada(){
		super("Receita n�o encontrada");
	}
}
