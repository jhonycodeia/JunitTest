package co.com.documentacion.suites;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import co.com.documentacion.assertions.AssertTests;
import co.com.documentacion.runners.RunnersTests;

/*
 * 
 * Permite agrupar las pruebas en suites pero no se
 * puede ejecuta ninguna prueba dentro suite
 * 
 * */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AssertTests.class,
	RunnersTests.class
})
public class SuitesTests {

	@Test
	public void test() {
		/* No se puede ejecutar porque es un suite*/
		fail("Not yet implemented");
	}

}
