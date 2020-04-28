$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/realizar_busca_avancada.feature");
formatter.feature({
  "name": "Realizar Busca Avançada",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@realizar-busca-avancada"
    }
  ]
});
formatter.scenario({
  "name": "REALIZAR BUSCA AVANÇADA",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@realizar-busca-avancada"
    },
    {
      "name": "@realizar-busca"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que o usuario esteja na tela principal do site WEBMOTORS",
  "keyword": "Dado "
});
formatter.match({
  "location": "realizar_busca.que_o_usuario_esteja_na_tela_principal_do_site_WEBMOTORS()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "sao informados as opcoes de busca",
  "keyword": "Quando "
});
formatter.match({
  "location": "realizar_busca.sao_informados_as_opcoes_de_busca()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", null);
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "sera possivel validar o retorno da pesquisa",
  "keyword": "Entao "
});
formatter.match({
  "location": "realizar_busca.sera_possivel_validar_o_retorno_da_pesquisa()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", null);
formatter.afterstep({
  "status": "passed"
});
});