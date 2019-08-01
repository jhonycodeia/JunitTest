package co.com.documentacion.assume;

import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class AssumeTests {

	@Test 
	public void filenameIncludesUsername() {
        assumeThat(File.separatorChar, is('/'));
        assertThat("configfiles/optimus.cfg", is("configfiles/optimus.cfg"));
    }

    @Test 
    public void correctBehaviorWhenFilenameIsNull() {
       assumeFalse(true);
       assertThat(("fsfsdfdfds"), is(new String()));
    }

}
