package coste.product.test.automation.actions;
import org.springframework.stereotype.Service;

import coste.product.test.automation.commons.Selenium;

@Service
public class TelaInicial {
	
	public void abrirNavegador() {
		Selenium.log("Driver criado");
		Selenium.openUrl("https://www.webmotors.com.br");
		Selenium.log("Acessou Site WEB MOTORS");
	}
}


