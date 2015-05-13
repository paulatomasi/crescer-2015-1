package Listator;

import java.io.File;

public class Listator {

	public static void main(String[] args) {
	    // Verifica se um diret�rio foi passado como par�metro
	    validaParametros(args);
	    String dir = args[0];

	    // Busca todos os arquivos de um diret�rio
	    String[] files = buscaArquivosDiretorio(dir);

	    // Imprime os arquivos encontrados
	    imprimeArquivos(files);
	}

	private static void validaParametros(String[] args) {
	    if(args.length == 0){
	        throw new IllegalStateException("Nenhum diret�rio informado");
	    }
	}

	private static void imprimeArquivos(String[] files) {
	    for(String file : files){
	        System.out.println(file);
	    }
	}

	public static String[] buscaArquivosDiretorio(String dir) {
	    return new File(dir).list();
	}
}
