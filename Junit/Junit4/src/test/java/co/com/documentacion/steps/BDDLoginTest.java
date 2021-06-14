package co.com.documentacion.steps;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BDDLoginTest {
	
	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.out.println("Loading the web pages");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("http://localhost:9090");
	}
	
    @When("^user enters correct credentials$")
	public void user_enters_correct_credentials() {
    	System.out.println("typing the credentials");
    	driver.findElement(By.id("username")).sendKeys("admin");
    	driver.findElement(By.id("password")).sendKeys("jhony12345");
    	driver.findElement(By.cssSelector("button[type='submit'")).click();;
	}
    
    @When("^user enters user (.*)$")
    public void user_enters_username(String username){
    	System.out.println("testing username "+username);
    	driver.findElement(By.id("username")).sendKeys(username);
    }
	
    @And("^user enters pass (.*)$")
    public void user_enters_password(String password){
    	System.out.println("testing password "+password);
    	driver.findElement(By.id("password")).sendKeys(password);
    	driver.findElement(By.cssSelector("button[type='submit'")).click();;
    }
    
    @Then("^user get confirmed$")
	public void user_get_confirmed() {
    	System.out.println("starting web site");
    	String message = driver.findElement(By.xpath("//*[@id=\"view\"]/rd-header/div/div[2]/div/rd-header-title/div/span[2]")).getText();
    	System.out.println("Message : "+message);
    	
    	assertEquals("admin",message);
    	
	}
    
    @After
    public void tearDown() {
    	driver.close();// current window browser
		driver.quit();// curret all windows browser
    }

}
