package co.com.documentacion.web;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EpaymentTest {

	private static WebDriver driver;
	private static boolean chrome = true;
	private static String url = "http://localhost:18383/epayment/login.seam?parUsuario=CV2016&parContrasena=Q1YxMjM=&parPtoVta=1084&parNitExt=12345&parDocumento=2016&parToken=&parLoginLocal=CV2016&parValidaTAT=N";
	
	
	@BeforeClass
	public static void cargar() {
		if(chrome) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void selenium() throws InterruptedException {	
				
		
			//driver de espera
		try {
			WebElement element;
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			/** open **/
			driver.get("https://jhonycodeia.github.io/portafolio-en/index.html");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:itNumeroIdentificacion\"]")));
			/** find **/
			//busca en el dom por propiedad value return unico
			element = driver.findElement(By.linkText("About Me"));
			//busca en el dom por propiedad name return unico
			element = driver.findElement(By.name("Name"));
			//busca en el dom por propiedad id return unico
			element = driver.findElement(By.id("About Me"));
			//busca en el dom por nombre clase id return multiple
			element = driver.findElement(By.className("proyectos"));
			//busca en el dom por notacion xpath return unico
			element = driver.findElement(By.xpath("//span[contains(text(),'Recaudos')]"));
			//busca en el dom por notacion css id return multiple
			element = driver.findElement(By.cssSelector(".proyectos"));
			
			/** action **/
			//write
			driver.findElement(By.xpath("//span[contains(text(),'Recaudos')]")).sendKeys(Keys.RETURN);
			//click radiobox,checkbox,button, any
			driver.findElement(By.xpath("//span[contains(text(),'Recaudos')]")).click();
			//selector combobox
			Select select = new Select(element);
			select.selectByVisibleText("Colmbia");
			select.selectByIndex(2);
			select.selectByValue("colombia");
			//js
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Ignore
	@Test
	public void pagarIdentificacion() throws InterruptedException {	
				
		
			//driver de espera
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			driver.get(url);	
			//menu
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Recaudos')]"));
			element.click();		
			//submenu
			element = driver.findElement(By.xpath("//span[contains(text(),'Registro Pagos')]"));
			element.click();
			//concepto
			element = driver.findElement(By.xpath("//*[@id=\"formulario:busquedaConcepto\"]"));
			element.sendKeys("CEM_ONLINE_BET_PLAY_RECARGA");
			element.sendKeys(Keys.RETURN);
			//identificacion			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:itNumeroIdentificacion\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:itNumeroIdentificacion\"]"));
			element.sendKeys("5555555010");
			element.sendKeys(Keys.RETURN);			
			//valor
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:valorFormulario\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:valorFormulario\"]"));
			element.clear();
			element.sendKeys("5000");
			//adicionar
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:btnGuardarPago\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnGuardarPago\"]"));
			element.click();			
			//registrar
			Thread.sleep(100);
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnRegistrarPago\"]"));
			element.click();			
			//formapago
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:labelValor\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:labelValor\"]"));
			element.clear();
			element.sendKeys("5000");
			
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"formulario:comboFormaDePago\"]")));
			select.selectByIndex(1);
			
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnAceptar\"]"));
			element.click();
			Thread.sleep(100);
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnRegistrar\"]"));
			element.click();			
			
			driver.switchTo().alert().accept();			
			driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);		
				
		
		Thread.sleep(10000);	
		
	}
	
	@Ignore
	@Test
	public void pagarReferencia() throws InterruptedException {	
				
		
			//driver de espera
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			driver.get(url);	
			//menu
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Recaudos')]"));
			element.click();		
			//submenu
			element = driver.findElement(By.xpath("//span[contains(text(),'Registro Pagos')]"));
			element.click();
			//concepto
			element = driver.findElement(By.xpath("//*[@id=\"formulario:busquedaConcepto\"]"));
			element.sendKeys("UNICAUCA");
			element.sendKeys(Keys.RETURN);
			
			//referencia
			Thread.sleep(1000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:numeroReferencia\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:numeroReferencia\"]"));
			element.sendKeys("41500009008048888020112");
			element.sendKeys(Keys.RETURN);			
			//valor
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:valorFormulario\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:valorFormulario\"]"));
			element.clear();
			element.sendKeys("5000");
			//adicionar
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:btnGuardarPago\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnGuardarPago\"]"));
			element.click();			
			//registrar
			Thread.sleep(100);
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnRegistrarPago\"]"));
			element.click();			
			//formapago
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:labelValor\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:labelValor\"]"));
			element.clear();
			element.sendKeys("5000");
			
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"formulario:comboFormaDePago\"]")));
			select.selectByIndex(1);
			
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnAceptar\"]"));
			element.click();
			Thread.sleep(100);
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnRegistrar\"]"));
			element.click();			
			
			driver.switchTo().alert().accept();			
			driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);	*/	
				
		
		Thread.sleep(10000);	
		
	}
	
	@Ignore
	@Test
	public void pagarBarra() throws InterruptedException {	
				
		
			//driver de espera
			WebDriverWait wait = new WebDriverWait(driver,20);
			
			driver.get(url);	
			//menu
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Recaudos')]"));
			element.click();		
			//submenu
			element = driver.findElement(By.xpath("//span[contains(text(),'Registro Pagos')]"));
			element.click();			
			//referencia
			Thread.sleep(1000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:codigoBarras\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:codigoBarras\"]"));
			//element.sendKeys("41500009008048888020112");
			//element.sendKeys("41500009008048888020415000090080488880201123900000002000096060819");
			element.sendKeys("415000090080488880208888888884390000000200009606082019");
			//element.sendKeys("4150000900804888802012345678953900000002000096060819");
			element.sendKeys(Keys.RETURN);			
			//valor
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:valorFormulario\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:valorFormulario\"]"));
			element.clear();
			element.sendKeys("5000");
			//adicionar
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:btnGuardarPago\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnGuardarPago\"]"));
			element.click();			
			//registrar
			Thread.sleep(100);
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnRegistrarPago\"]"));
			element.click();			
			//formapago
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formulario:labelValor\"]")));
			element = driver.findElement(By.xpath("//*[@id=\"formulario:labelValor\"]"));
			element.clear();
			element.sendKeys("5000");
			
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"formulario:comboFormaDePago\"]")));
			select.selectByIndex(1);
			
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnAceptar\"]"));
			element.click();
			Thread.sleep(100);
			element = driver.findElement(By.xpath("//*[@id=\"formulario:btnRegistrar\"]"));
			element.click();			
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.switchTo().alert().accept();			
			driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);	*/	
				
		
		Thread.sleep(10000);	
		
	}
	
	@AfterClass
	public static void cerrar() {
		driver.close();// current window browser
		driver.quit();// curret all windows browser
	}
}
