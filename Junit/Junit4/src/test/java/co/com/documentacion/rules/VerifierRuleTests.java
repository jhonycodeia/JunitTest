package co.com.documentacion.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

public class VerifierRuleTests {

	/*
	 * Esta regla puede convertir los métodos de prueba aprobados en pruebas
	 * fallidas si falla una verificación se ejecuta despues de cada prueba
	 * para revisar el resultado si no pasa la verificacion es fallida sin
	 * importar que la prueba sea exitosa
	 * 
	 */

	private static String sequence ="";

	@Rule
	public final Verifier collector = new Verifier() {
		@Override
		protected void verify() {
			sequence += "verify";
			assertEquals("test verify", sequence);
		}
	};	

	@Test
	public void example() {		
		sequence = "test ";		
	}
	
	@Test
	public void example2() {
		sequence = "prueba ";
	}
	
	@Test
	public void example3() {
		sequence = "test ";
	}
	
	
	

	

}
