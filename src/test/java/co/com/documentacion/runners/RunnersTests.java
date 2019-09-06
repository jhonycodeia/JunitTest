package co.com.documentacion.runners;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RunnersTests {

	/* Regla de timeout aplica para todas las pruebas*/
	@Rule
    public Timeout globalTimeout = Timeout.seconds(10);
	
	@Test
	public void test1() {
		System.out.println("Entrando en test1");		
	}
	
	@Test
	public void test2() {
		System.out.println("Entrando en test2");		
	}
	
	@Test
	public void test3() {
		System.out.println("Entrando en test3");		
	}
	/* mandatorio esta forma a la regla*/
	@Test(timeout=1000)	
	public void test4() throws InterruptedException {		
		System.out.println("Entrando en time");		
	}
	
	/* Timeout con regla */
	@Test
    public void testSleepForTooLong() throws Exception {        
        TimeUnit.SECONDS.sleep(1); // sleep for 100 seconds
    }
	
	@Ignore
	@Test
	public void testIgnore() {
		/* Ignora esta prueba*/
		System.out.println("Ignora en test");		
	}
	
	@Test
	public void fomatNumber() {
		DecimalFormat df = new DecimalFormat("0000000");
		System.out.println(df.format(9));
		System.out.println(df.format(99));
		System.out.println(df.format(9999));
		System.out.println(df.format(99999));
		System.out.println(df.format(999999));
		System.out.println(df.format(9999999));
	}
	
	@Before
	public void antes() {
		/* Se ejecuta siempre antes de realizar una prueba*/
		System.out.println("Entrando en Before");
	}
	
	@BeforeClass
	public static void beforeClass() {
		/* Se ejecuta una sola vez antes del before*/
		System.out.println("Entrando en BeforeClass");
	}
		
	@After
	public void despues() {
		/* Se ejecuta despues de cada prueba*/
		System.out.println("Entrando en After");
	}
	
	@AfterClass
	public static void despuesClass() {
		/* Se ejecuta una sola vez cuando termina todas las pruebas*/
		System.out.println("Entrando en AfterClass");
	}

}
