package co.com.documentacion.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class TimeoutRuleTests {

	public static String log;
	
	/* esta regla permite definir un tiempo limite para todos las pruebas*/

	@Rule
	public final TestRule globalTimeout = Timeout.millis(20);

	@Test
	public void testInfiniteLoop1() {
		log += "ran1";
		for (;;) {
		}
	}

	@Test
	public void testInfiniteLoop2() {
		log += "ran2";
		for (;;) {
		}
	}

}
