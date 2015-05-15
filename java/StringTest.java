package apis;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void toUpperCase() {
		String valor = "cwi";
		String esperado = "CWI";
		assertEquals(esperado, valor.toUpperCase());
	}

	@Test
	public void replace(){
		String valor = "qualquer coisa";
		String esperado = "qtalqter coisa";
		assertEquals(esperado, valor.replace("u", "t"));
	}
	
	@Test
	public void split(){
		String valor = "qualquer coisa";
		String[] esperado = {"qualquer", "coisa"};
		assertEquals(esperado, valor.split(" "));
	}
	
	@Test
	public void indexOf(){
		String valor = "qualquer coisa que de pra testar";
		int esperado = 9 ;
		assertEquals(esperado, valor.indexOf("coisa"));
	}
	
}
