package co.com.documentacion.steps.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "features"
,glue= {"co.com.documentacion.steps"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true
)
public class LoginTestRunner {

	@AfterClass
    public static void writeExtentReport() {
		try {
			File file = new File("src/test/resources/report.xml");
			System.out.println ("ubicacion : "+file.getAbsolutePath ());
			System.out.println("archivo "+file.exists());
	        Reporter.loadXMLConfig(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    
    }

}
