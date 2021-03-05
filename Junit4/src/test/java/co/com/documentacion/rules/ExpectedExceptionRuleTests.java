package co.com.documentacion.rules;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionRuleTests {

	
	/* 
	 * 
	 * Esta regla permite tener un control de las excepciones para que 
	 * las ignoner y no afecte la pruebas
	 * 
	 */
	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void throwsNothing() {

	}

	@Test
	public void throwsNullPointerException() {
		thrown.expect(NullPointerException.class);
		throw new NullPointerException();
	}

	@Test
	public void throwsNullPointerExceptionWithMessage() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("happened?");
		thrown.expectMessage(startsWith("What"));
		throw new NullPointerException("What happened?");
	}

}
