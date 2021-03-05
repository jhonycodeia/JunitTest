package co.com.documentacion.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class RuleChainTests {

	/*
	 * La regla de la cadena de reglas permite ordenar las reglas de prueba:
	 */
	@Rule
	public final TestRule chain = RuleChain.outerRule(new CustomRuleTests("outer rule"))
			.around(new CustomRuleTests("middle rule")).around(new CustomRuleTests("inner rule"));

	@Test
	public void example() {
		assertTrue(true);
	}

}
