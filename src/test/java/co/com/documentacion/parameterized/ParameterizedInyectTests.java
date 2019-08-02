package co.com.documentacion.parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import co.com.fibonacci.Fibonacci;

@RunWith(Parameterized.class)
public class ParameterizedInyectTests {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	@Parameter // first data value (0) is default
	public /* NOT private */ int fInput;

	@Parameter(1)
	public /* NOT private */ int fExpected;

	@Test
	public void test() {
		System.out.println("Expected: " + fExpected);
		System.out.println("Input: " + fInput);
		assertEquals(fExpected, Fibonacci.compute(fInput));
	}

}
