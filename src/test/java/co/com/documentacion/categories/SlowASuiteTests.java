package co.com.documentacion.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import co.com.categoria.FastTests;
import co.com.categoria.SlowTests;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@ExcludeCategory(FastTests.class)
@SuiteClasses({ ATests.class, BTests.class }) // Note that Categories is a kind of Suite
public class SlowASuiteTests {
	// Will run A.b and B.c, but not A.a
}
