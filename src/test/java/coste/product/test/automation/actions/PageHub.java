package coste.product.test.automation.actions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PageHub {
	
	
	//ACTIONS
	@Autowired
	public TelaInicial telainicial;
	
	@Autowired
	public BuscaVeiculo buscaveiculo;
}
