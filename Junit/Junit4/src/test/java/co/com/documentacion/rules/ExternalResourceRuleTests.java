package co.com.documentacion.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class ExternalResourceRuleTests {
	
	@Rule /* Esta regla simula el mismo comportamiento que los @before and @after */
	public final ExternalResource resource = new ExternalResource(){
	    @Override
	    protected void before() throws Throwable {
	      System.out.println("before");
	    };
	    
	    @Override
	    protected void after() {
	      System.out.println("after");
	    };
	  };
	  

	@Test
	public void testa() {
		System.out.println("a");
	}
	
	@Test
	public void testb() {
		System.out.println("b");
	}

}
