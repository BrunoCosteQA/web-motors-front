package coste.product.test.automation.conf;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
		basePackages = { 
				"coste.product.test.automation"
						}
		)
@EntityScan(
		basePackages = {
				"coste.product.test.automation",
		}
		)

public class ConfInit {
	

}
