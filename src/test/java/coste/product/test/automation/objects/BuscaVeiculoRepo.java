package coste.product.test.automation.objects;

import org.springframework.stereotype.Service;

@Service
public class BuscaVeiculoRepo {
		
	public String inputPesquisa = "//input[contains(@placeholder,'Digite marca ou modelo do carro')]";
	public String selectPesquisa = "//div[@class = 'SearchBar__results__result__name']";
	public String buttonMarca = "//div[contains(@class,'Filters__line') and contains (text(),'HONDA')]";
	public String buttonModelo = "//div[contains(@class,'Filters__line') and contains (text(),'CITY')]";
	public String buttonVersao = "//div[contains(@class,'Filters__line Filters__line--icon Filters__')]";
	public String selectVersao = "//a[@class='Filters__line Filters__line__result'][1]";
	public String validaCabeçalho = "//h1";
	public String validaFiltro = "//li[contains(@class,'FilterResult__container__list') and contains (a,'HONDA CITY 1.5 DX 16V FLEX 4P AUTOMÁTICO')]"; 
}

