package co.com.documentacion.parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTests {

	/* Se utilizan los parametros de acuerdo a la posicion o index */
	/*@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}*/

	@Parameters(name = "{index}: fib({0})={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	private int fInput;
	private int fExpected;

	/* se utiliza el constructor para inyectar los parametros {0},{1} */
	public ParameterizedTests(int input, int expected) {
		this.fInput = input;
		this.fExpected = expected;
	}

	@Test
	public void test() {
		System.out.println("Expected: " + fExpected);
		System.out.println("Input: " + fInput);
		assertEquals(fExpected, Fibonacci.compute(fInput));
	}

}

class Fibonacci {
	public static int compute(int n) {
		int result = 0;

		if (n <= 1) {
			result = n;
		} else {
			result = compute(n - 1) + compute(n - 2);
		}

		return result;
	}
}
