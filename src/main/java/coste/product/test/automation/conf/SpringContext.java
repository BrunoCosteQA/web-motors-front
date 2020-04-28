package coste.product.test.automation.conf;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;

@ContextConfiguration(classes = ConfInit.class, loader = SpringBootContextLoader.class)
public class SpringContext {
	@Before
	public void SetupSpringContext() {
		
	}
}


