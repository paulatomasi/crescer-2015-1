package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Netflox {
	
	ArrayList<Filme> listaFilme = new ArrayList<Filme>();
	private Map<Genero, Integer> estatisticas = new HashMap<Genero, Integer>();
	
	public void adicionarFilme(Filme nome){
		listaFilme.add(nome);
	}	
	public void reproduzirFilme(Filme nome){
		if(listaFilme.contains(nome)){
			int temp = estatisticas.getOrDefault(nome.getGenero(), 0);
			temp++;
			estatisticas.put(nome.getGenero(), temp);
			System.out.println("Reproduzindo " + nome);
		}else {
			System.out.println("Filme não encontrado");
		}
		/*if(listaFilme.contains(nome)){
			if (estatisticas.containsKey(nome.getGenero())){
				int temp = estatisticas.get(nome.getGenero());
				temp++;
				estatisticas.put(nome.getGenero(), temp);
				System.out.println("Reproduzindo " + nome);
			}else {
				estatisticas.put(nome.getGenero(), 1);
			}
		}else {
			System.out.println("Filme não encontrado");
		}*/
	}
	public void gerarRelatorio(){
		for (Entry<Genero, Integer> entry : estatisticas.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public Map<Genero, Integer> getEstatisticas() {
		return estatisticas;
	}
}
