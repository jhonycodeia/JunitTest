package co.com.documentacion.rules;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class WatchmanRuleTests {

	private static String watchedLog;
	
	/*
	 * Esta regla nos permite tener un control del ciclo de
	 * las pruebas para realizar cualquier accion si se requiere
	 * en los diferentes estados que puede llegar una pruebas
	 * 
	 * */

	@Rule
	public final TestRule watchman = new TestWatcher() {
		
		@Override
		public Statement apply(Statement base, Description description) {
			return super.apply(base, description);
		}

		@Override
		protected void succeeded(Description description) {
			watchedLog = description.getDisplayName() + " " + "success!\n";
			System.out.println(watchedLog);
		}

		@Override
		protected void failed(Throwable e, Description description) {
			watchedLog = description.getDisplayName() + " " + e.getClass().getSimpleName() + " fail\n";
			System.out.println(watchedLog);
		}

		@Override
		protected void skipped(AssumptionViolatedException e, Description description) {
			watchedLog = description.getDisplayName() + " " + e.getClass().getSimpleName() + " skipped\n";
			System.out.println(watchedLog);
		}

		@Override
		protected void starting(Description description) {
			super.starting(description);
		}

		@Override
		protected void finished(Description description) {
			super.finished(description);
		}
	};

	@Test
	public void fails() {
		System.out.println("test fail");
		fail();
	}

	@Test
	public void succeeds() {
		System.out.println("test succes");
	}
	
	@Test
	public void skipped() {
		System.out.println("test skipped");
		Assume.assumeTrue("foo".equals("bar"));
        fail("This should not be reached!");
	}
	
	@Test
	public void error() {
		System.out.println("test error");
		new ArrayList<>().get(0);
	}

}
