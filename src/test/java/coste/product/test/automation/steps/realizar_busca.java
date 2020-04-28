package coste.product.test.automation.steps;

import static coste.product.test.automation.commons.SeleniumDriver.*;

import org.springframework.beans.factory.annotation.Autowired;

import coste.product.test.automation.actions.PageHub;
import coste.product.test.automation.commons.Selenium;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class realizar_busca {
	
	@Autowired PageHub page;
	
	@AfterStep("@realizar-busca-avancada")
	public void printSteps(Scenario scenario) throws InterruptedException {

		Selenium.printScreenAfterStep(scenario);
	}
	
	@Dado("que o usuario esteja na tela principal do site WEBMOTORS")
	public void que_o_usuario_esteja_na_tela_principal_do_site_WEBMOTORS() throws Throwable {
		page.telainicial.abrirNavegador();
	}

	@Quando("sao informados as opcoes de busca")
	public void sao_informados_as_opcoes_de_busca() throws Throwable {
		page.buscaveiculo.realizarBusca();
	}	

	@Entao("sera possivel validar o retorno da pesquisa")
	public void sera_possivel_validar_o_retorno_da_pesquisa() throws Throwable {
		page.buscaveiculo.validaBusca();
	}

	@Quando("sao informados as opcoes de busca por concessionaria")
	public void sao_informados_as_opcoes_de_busca_por_concessionaria() throws Throwable {
		
	}
	
}	