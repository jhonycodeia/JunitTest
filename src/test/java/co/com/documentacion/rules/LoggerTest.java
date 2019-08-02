package co.com.documentacion.rules;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;

public class LoggerTest {
	
	/* prueba de regla propia*/

	@Rule
	public final CustomRuleTests logger = new CustomRuleTests();

	@Test
	public void checkOutMyLogger() {
		final Logger log = logger.getLogger();
		log.info("Your test is showing!");
	}

}
