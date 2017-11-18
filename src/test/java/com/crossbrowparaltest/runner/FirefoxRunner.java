package com.crossbrowparaltest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		features = {"src/test/resources/Firefox.feature"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/Firefox/report.html"},
//		tags = {"@firefox"},
		monochrome = true,
		glue = {"com.crossbrowparaltest.glue"}
		)

public class FirefoxRunner {

}
