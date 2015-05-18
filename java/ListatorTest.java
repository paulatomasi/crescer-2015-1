package Listator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListatorTest {

	@Test
	public void buscaTodosArquivos() throws Exception {
	    // Busca todos os arquivos do diret�rio atual 
	    // (a string "." corresponde ao diret�rio atual)
	    String[] files = Listator.buscaArquivosDiretorio(".");
	    boolean possuiDiretorioSrc = false;
	    for(String s: files){
	        if(s.equals("src")){
	            possuiDiretorioSrc = true;
	        }
	    }   
	    assertTrue("Diret�rio src n�o encontrado", possuiDiretorioSrc);
	}

}
