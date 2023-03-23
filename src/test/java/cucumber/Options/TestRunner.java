package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "D:\\EclipseProjects\\APIFramework\\src\\test\\java\\features",
		glue = "stepdefinitions",
		dryRun = false,
		plugin = {"pretty","html:target/HtmlReports/cucumber-reports.html"},
		monochrome = true	
		)

public class TestRunner {

}
