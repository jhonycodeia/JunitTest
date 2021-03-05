package co.com.documentacion.rules;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import co.com.documentacion.categories.ATests;
import co.com.documentacion.categories.BTests;


@RunWith(Suite.class)
@SuiteClasses({ATests.class, BTests.class})
public class ClassRuleTests {

	/*
	 * La anotación ClassRule amplía la idea de Reglas a nivel de método, agregando
	 * campos estáticos que pueden afectar el funcionamiento de una clase completa.
	 * Cualquier subclase de ParentRunner, incluidas las clases estándar
	 * BlockJUnit4ClassRunner y Suite, admitirá ClassRules.
	 * 
	 * se ejecutan 1 sola vez antes y despues de realizar las prueba
	 */
	
	@ClassRule
	public static final ExternalResource resource = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			System.out.println("antes");
		};

		@Override
		protected void after() {
			System.out.println("despues");
		};
	};

}
