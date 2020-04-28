package coste.product.test.automation.commons;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumDriver {
	
	public static WebDriver driver = new DriverInit().getDriver();

}
