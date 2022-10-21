package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

public class FilmesSteps {

    @Dado("que tenho um payload valido da API de Filmes")
    public void queTenhoUmPayloadValidoDaAPIDeFilmes() {
        FilmesMap.initAll();
    }
    @Quando("envio uma requisicao do tipo POST de Filmes")
    public void envioUmaRequisicaoDoTipoPOSTDeFilmes() {
        RestUtils.postHeader(FilmesMap.getHeader(),FilmesMap.getFilme(), ContentType.JSON,"filmes");
    }
    @Entao("armazeno o id que recebo do response de Filmes")
    public void armazenoOIdQueReceboDoResponseDeFilmes() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");
    }
}
