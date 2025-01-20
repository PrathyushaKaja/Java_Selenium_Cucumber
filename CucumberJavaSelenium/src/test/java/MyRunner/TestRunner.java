package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue= {"stepDefinitions"},
		plugin = {
		"pretty", 
		"html:target/generatedHTMLReports/cucumber-reports",
		"json:target/generatedJSONReports/cucumber-reports"
				},
		tags="@all",
		monochrome=true
)

public class TestRunner {

}
