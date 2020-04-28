package coste.product.test.automation.main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import coste.product.test.automation.commons.Functions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags = {"@realizar-busca" },
		
		glue = 
	
			  {
				"coste.product.test.automation.steps",
				"coste.product.test.automation.conf" 
			  }, 
		
		features = {"src/test/resources/features/" }, 
		monochrome = true, 
		plugin =  { 
						"pretty", 
						"json:target/reports/results.json",
						"junit:target/reports/results.xml", 
						"html:target/reports/results.html"
				 }
		)

//Runner Para Rodar os Testes
public class ExecuteTest {
	
	
	@BeforeClass
	
	public static void setUp() {
		System.out.println("Running on: " + Functions.verifyOS());
		Functions.setUp();
	}
	
	@AfterClass
	
	public static void tearDown(){
		Functions.finalizaExecucao();
	}
	
}
