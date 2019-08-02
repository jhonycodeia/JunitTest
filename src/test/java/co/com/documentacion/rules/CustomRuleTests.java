package co.com.documentacion.rules;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRuleTests implements TestRule{

	/*
	 * 
	 * La mayoría de las reglas personalizadas se 
	 * pueden implementar como una extensión de la 
	 * regla ExternalResource. Sin embargo, si necesita 
	 * más información sobre la clase de prueba o el método 
	 * en cuestión, deberá implementar la interfaz TestRule.
	 * 
	 * */	
	
	public CustomRuleTests(String text) {
		System.out.println(text);
	}
	
	public CustomRuleTests() {
		
	}

	private Logger logger;

	  public Logger getLogger() {
	    return this.logger;
	  }

	  @Override
	  public Statement apply(final Statement base, final Description description) {
	    return new Statement() {
	      @Override
	      public void evaluate() throws Throwable {
	        logger = Logger.getLogger(description.getTestClass().getName() + '.' + description.getDisplayName());
	        base.evaluate();
	      }
	    };
	  }

}
