package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features", //this will run all the feature files
		dryRun = false, //it will check if the mapping is done properly
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = "tests" //If it doesn't find the steps from feature file, right click project - configure - convert to cucumber project
		)
public class Runner extends AbstractTestNGCucumberTests{
	
}