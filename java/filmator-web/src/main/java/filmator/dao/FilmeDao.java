package filmator.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {
	
	private static List<Filme> filmesSalvos = new ArrayList<Filme>();
	
	public void salvar(Filme filme){			
		filmesSalvos.add(filme);
	}
	
	public static List<Filme> getFilmes() {
		return filmesSalvos;
	}
}
 