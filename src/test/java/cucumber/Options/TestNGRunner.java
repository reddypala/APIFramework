package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = ".\\src\\test\\java\\features\\placeValidations.feature",
		glue = "stepdefinitions",
		plugin = {"pretty","html:target/cucumber-reports.html"},
		monochrome = true
		
		)


public class TestNGRunner extends AbstractTestNGCucumberTests {

}
