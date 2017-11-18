package com.crossbrowparaltest.glue;

import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionFirefox {
	
	WebDriver driver;
	
	@Given("^Firefox only validation$")
	public void firefox_only_validation() throws Throwable {		
		String projectLocation = System.getProperty("user.dir");		
		System.setProperty("webdriver.gecko.driver", projectLocation + "/Browser Driver/FirefoxDriver/geckodriver.exe");
		driver = new FirefoxDriver();		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int Width = (int) toolkit.getScreenSize().getWidth();
		int Height = (int) toolkit.getScreenSize().getHeight();
		driver.manage().window().setSize(new Dimension(Width,Height));
	}

	@When("^Navigate to login with Firefox$")
	public void navigate_to_login_with_Firefox() throws Throwable {
		driver.get("http://beta-inventory.maxrailwaytrack.com");
	}

	@Then("^Click the login button with Firefox$")
	public void click_the_login_button_with_Firefox() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login']/div[5]/button")));
	    
	    // This is to open the window in same tab \\
	    WebElement login = driver.findElement(By.xpath("//*[@id='login']/div[5]/button"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('target','_self');", login);
	    login.click();
	}

}
