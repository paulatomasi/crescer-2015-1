package apis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void get() {
		List<String> valor = new ArrayList<String>();
		valor.add("qualquer coisa");
		String esperado = "qualquer coisa";
		assertEquals(esperado, valor.get(0));
	}

	@Test
	public void set() {
		List<String> valor = new ArrayList<String>();
		valor.add("qualquer coisa");
		valor.set(0, "outra coisa");
		String esperado = "outra coisa";
		assertEquals(esperado, valor.get(0));
	}
	
	@Test
	public void indexOf() {
		List<String> valor = new ArrayList<String>();
		valor.add("eu nao sei");
		valor.add("outra coisa");
		valor.add("sla");
		int esperado = 2;
		assertEquals(esperado, valor.indexOf("sla"));
	}
	
}
