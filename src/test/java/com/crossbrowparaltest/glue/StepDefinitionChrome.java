package com.crossbrowparaltest.glue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionChrome {
	
	WebDriver driver;	
	
	@Given("^Chrome only validation$")
	public void chrome_only_validation() throws Throwable {		
		System.setProperty("webdriver.chrome.driver", "Browser Driver/ChromeDriver/chromedriver.exe");
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--start-maximized");
		cOptions.addArguments("--disable-web-security");
		cOptions.addArguments("--disable-notifications");
		cOptions.addArguments("--no-proxy-server");
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    cOptions.setExperimentalOption("prefs", prefs);
		cOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		driver = new ChromeDriver(cOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("^Navigate to login with Chrome$")
	public void navigate_to_login_with_Chrome() throws Throwable {
		driver.navigate().to("http://beta-inventory.maxrailwaytrack.com");
	}

	@Then("^Click the login button with Chrome$")
	public void click_the_login_button_with_Chrome() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login']/div[5]/button")));
	    
	    // This is to open the window in same tab \\
	    WebElement login = driver.findElement(By.xpath("//*[@id='login']/div[5]/button"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('target','_self');", login);
	    login.click();
	}
	
	@Then("^Click Remember button$")
	public void click_Remember_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id='login']/div[5]/label")).click();
	}
}
