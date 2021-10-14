package TestRunners;


import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( glue = {"StepDefs"}, 
				  plugin = {"html:target/cucumber-reports/CUCUMBER_RetailLogin_StepDefs/cucumber-pretty","json:target/json-cucumber-reports/CUCUMBER_RetailLogin_StepDefs/cukejson.json",
		"testng:target/xmlreports/CUCUMBER_RetailLogin_StepDefs.xml" }, 
				  features = {"src/test/resources/features/Retail_UserLogin.feature"}
				 
			    )

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
