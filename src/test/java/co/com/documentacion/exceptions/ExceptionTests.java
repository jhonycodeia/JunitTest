package co.com.documentacion.exceptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTests {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test(expected = IndexOutOfBoundsException.class) 
	public void empty() { 
		/* ignorar excepcion especifica*/
	     new ArrayList<Object>().get(0); 
	}
	
	@Test
	public void testExceptionMessage() {
	    try {
	    	/* ignorar cualquier exception */
	        new ArrayList<Object>().get(0);
	        fail("Expected an IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	        assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
	    }
	}
	
	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
		/* Ignorar una exception por medio una regla*/
	    List<Object> list = new ArrayList<Object>();	 
	    thrown.expect(IndexOutOfBoundsException.class);
	    thrown.expectMessage(CoreMatchers.containsString("Size: 0"));
	    list.get(0); // execution will never get past this line
	}
	
	  

}
