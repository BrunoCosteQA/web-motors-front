package coste.product.test.automation.actions;

import static coste.product.test.automation.commons.Selenium.*;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coste.product.test.automation.commons.Selenium;
import coste.product.test.automation.objects.BuscaVeiculoRepo;

@Service
public class BuscaVeiculo {

	@Autowired
	BuscaVeiculoRepo objects;

	public void realizarBusca() throws InterruptedException {
		waitExistSet(objects.inputPesquisa, "HONDA CITY ", 15);
		Thread.sleep(2000);
		waitExistClick(objects.selectPesquisa, 20 , false);
		Thread.sleep(2000);
		waitExist(objects.buttonMarca, 15);
		Thread.sleep(2000);
		waitExist(objects.buttonModelo, 10);
		Thread.sleep(2000);
		waitExistClick(objects.buttonVersao, 10);
		Thread.sleep(2000);
		waitExistClick(objects.selectVersao, 10);
		Thread.sleep(2000);
	}

	public void validaBusca() throws InterruptedException {

		String textoCabecalho = "";
		String textoFiltro = "";

//		for (int i = 0; i <= 4; i++) {
			textoCabecalho = Selenium.waitExistGetText(objects.validaCabeçalho, 30);
//			if (textoCabecalho.contains("Honda")) {
//				log("Este cabecalho nine " + textoCabecalho);
//				break;
//			} else {
//				log("String Cabeçalho do momento [" + textoCabecalho + "]");
//				Thread.sleep(2000);
//			}
//		}

		log("O cabeçalho está conforme o esperado: " + textoCabecalho);
		assertEquals("Honda City 1.5 Dx 16v Flex 4p Automático Novos e Usados", textoCabecalho);

//		for (int i = 0; i <= 4; i++) {
			textoFiltro = waitExistGetText(objects.validaFiltro, 10);
//			if (textoFiltro.contains("HONDA")) {
//				log("Este filtro nine " + textoFiltro);
//				break;
//			} else {
//				log("String filtro do momento [" + textoFiltro + "]");
//				Thread.sleep(2000);
//			}
//		}
		
		log("O Filtro está conforme o esperado: " + textoFiltro);
		assertEquals("HONDA CITY 1.5 DX 16V FLEX 4P AUTOMÁTICO", textoFiltro);
	}
}