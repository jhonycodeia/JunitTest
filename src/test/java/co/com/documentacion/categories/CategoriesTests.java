package co.com.documentacion.categories;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import co.com.categoria.FastTests;
import co.com.categoria.SlowTests;

public class CategoriesTests {

	@Test
	public void a() {
	}

	@Category(SlowTests.class)
	@Test
	public void b() {
	}
}
/*
@Category({ SlowTests.class, FastTests.class })
public class B {
	@Test
	public void c() {

	}
}*/
 /*
@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses({ CategoriesTests.class, B.class }) // Note that Categories is a kind of Suite
public class SlowTestASuite {
	// Will run A.b and B.c, but not A.a
}

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@ExcludeCategory(FastTests.class)
@SuiteClasses({ B.class }) // Note that Categories is a kind of Suite
public class SlowTestBSuite {
	// Will run A.b, but not A.a or B.c
}*/
