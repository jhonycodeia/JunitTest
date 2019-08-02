package co.com.documentacion.rules;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRuleTests {

	@Rule/* Exta regla permite crear un archivo temporar mientras se ejecutan pruebas */
	public final TemporaryFolder folder = new TemporaryFolder();	

	@Test
	public void testUsingTempFolder() throws IOException {		
		File createdFile = folder.newFile("myfile.txt");
		File createdFolder = folder.newFolder("subfolder");
		
		Assert.assertEquals("fallo", "actual", "actual");
	}

}
