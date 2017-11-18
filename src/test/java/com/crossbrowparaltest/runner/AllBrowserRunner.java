package com.crossbrowparaltest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		features = {"src/test/resources/Firefox.feature","src/test/resources/Chrome.feature","src/test/resources/Explorer.feature"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/All/report.html"},
//		tags = {"@firefox,@chrome,@iebrowser"},
		monochrome = true,
		glue = {"com.crossbrowparaltest.glue"}
		)

public class AllBrowserRunner {

}
