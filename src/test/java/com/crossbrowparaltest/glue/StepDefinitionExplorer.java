package com.crossbrowparaltest.glue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionExplorer {
	
	WebDriver driver;
	
	@Given("^Explorer only validation$")
	public void explorer_only_validation() throws Throwable {
		System.setProperty("webdriver.ie.driver", "Browser Driver/ExplorerDriver/IEDriverServer.exe");
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("^Navigate to login with Explorer$")
	public void navigate_to_login_with_Explorer() throws Throwable {
		driver.navigate().to("http://beta-inventory.maxrailwaytrack.com");
	}

	@Then("^Click the login button with Explorer$")
	public void click_the_login_button_with_Explorer() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login']/div[5]/button")));
	    
	    // This is to open the window in same tab \\
	    WebElement login = driver.findElement(By.xpath("//*[@id='login']/div[5]/button"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('target','_self');", login);
	    login.click();
	}

}
