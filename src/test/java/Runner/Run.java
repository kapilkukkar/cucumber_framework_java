package Runner;
import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.*;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features=".//Features/AddCustomer.feature",
		//features=".//Features/",
		features= {".//Features/AddCustomer.feature",".//Features/LoginFeature.feature"},
		glue="StepDefination",
		dryRun=false,
		monochrome=true,
		tags="@sanity ",
		plugin= {"pretty","html:target/cucumber-reports/report.html"}
		

		)
public class Run extends AbstractTestNGCucumberTests
{

}
