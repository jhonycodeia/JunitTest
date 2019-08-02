package co.com.documentacion.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import co.com.categoria.SlowTests;

public class ATests {

	@Test
	public void a() {
	}

	@Category(SlowTests.class)
	@Test
	public void b() {
	}
}
