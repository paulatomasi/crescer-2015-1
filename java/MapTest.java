package apis;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapTest {

	@Test
	public void put(){
		Map<String, Integer> valor = new HashMap<String, Integer>();
		Map<String, Integer> esperado = new HashMap<String, Integer>();
		valor.put("Morango", 9);
		valor.put("Laranja", 17);
		esperado.put("Morango", 9);
		esperado.put("Laranja", 17);
		assertEquals(esperado, valor);
	}
	
	@Test
	public void containsKey(){
		Map<String, Integer> valor = new HashMap<String, Integer>();
		valor.put("Morango", 1);
		valor.put("Laranja", 2);
		assertEquals(true, valor.containsKey("Morango"));
		assertEquals(false, valor.containsKey("Banana");
	}
	
	@Test
	public void containsValue(){
		Map<String, Integer> valor = new HashMap<String, Integer>();
		valor.put("Morango", 1);
		valor.put("Laranja", 2);
		assertEquals(true, valor.containsValue(1));
		assertEquals(false, valor.containsValue(3);
	}
}
