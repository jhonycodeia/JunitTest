package co.com.documentacion.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class NameRuleTests {

	/*
	 * La regla TestName hace que 
	 * el nombre de la prueba actual 
	 * esté disponible dentro de los 
	 * métodos de prueba:
	 * */
	@Rule
	public final TestName name = new TestName();

	@Test
	public void testA() {
		System.out.println(name.getMethodName());
		assertEquals("testA", name.getMethodName());
	}

	@Test
	public void testB() {
		System.out.println(name.getMethodName());
		assertEquals("testB", name.getMethodName());
	}

}
