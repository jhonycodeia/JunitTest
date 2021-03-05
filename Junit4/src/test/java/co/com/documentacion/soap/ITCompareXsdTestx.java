/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.documentacion.soap;


import com.predic8.soamodel.Difference;
import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;
import com.predic8.wsdl.diff.WsdlDiffGenerator;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.List;

import org.junit.Test;

/**
 *
 * @author usuario
 *         https://stackoverflow.com/questions/8064101/xml-wsdl-comparison-tool
 */
public class ITCompareXsdTestx {

	private static final String MENSAJE_COMPARE_XSD_SIZE = "verificando lista de diferencias";
	private static final int COMPARE_XSD_SIZE = 1;

	/**
	 * Metodo test que compara XSD's a partir de dos WSDL's, no debe estar
	 * habilotada la autenticación weblogic para los wsdl.
	 */
	@Test
	public void compareTest() throws Exception {

		/*
		 * String cmd = "bash /home/bea/bash/compareXsd.bash";
		 * Runtime.getRuntime().exec(cmd);
		 * 
		 * Thread.sleep(2000);
		 */

		// create a new wsdl parser
		WSDLParser parser = new WSDLParser();

		// parse both wsdl documents
		Definitions url1 = parser.parse(
				new URL("http://10.69.42.35:8001/gatewaydigitalbackendint/GatewayDigitalBackendWS?WSDL").openStream());
		Definitions url2 = parser.parse(
				new URL("http://10.69.42.35:8001/gatewaydigitalbackenddev/GatewayDigitalBackendWS?WSDL").openStream());
		// compare the wsdl documents
		WsdlDiffGenerator diffGen = new WsdlDiffGenerator(url1, url2);
		List<Difference> lst = diffGen.compare();

		// write the differences to the console
		for (Difference diff : lst) {
			System.out.println(diff.dump());
		}

		assertEquals(MENSAJE_COMPARE_XSD_SIZE, COMPARE_XSD_SIZE, lst.get(0).getDiffs().size());

	}
}
