package co.com.documentacion.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import co.com.categoria.FastTests;
import co.com.categoria.SlowTests;

@Category({SlowTests.class, FastTests.class})
public class BTests {

	@Test
	public void c() {

	}

}
