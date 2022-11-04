package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;

import maps.FilmesMap;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

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

    @Quando("envio uma requisicao do tipo GET de Filmes")
    public void envioUmaRequisicaoDoTipoGETDeFilmes() {
        RestUtils.get(FilmesMap.getHeader(),"filmes");
    }

    @Quando("altero o indice {int} da lista de categorias de Filme com os valores")
    public void alteroOIndiceDaListaDeCategoriasDeFilmeComOsValores(int indice, Map<String, String> map) {
        FilmesMap.getListCategoria().get(indice).putAll(map);
    }
    @Quando("realizo uma requisicao do tipo PUT de Filmes")
    public void realizoUmaRequisicaoDoTipoPUTDeFilmes() {
        RestUtils.put(FilmesMap.getHeader(),FilmesMap.getFilme(),ContentType.JSON,"filmes/" + FilmesMap.id);
    }

    @Quando("envio uma requisicao do tipo GET de Filmes pelo nome")
    public void envioUmaRequisicaoDoTipoGETDeFilmesPeloNome() {
        Map<String, String> param = new HashMap<>();
        String nome = FilmesMap.getFilme().get("nome").toString();
        param.put("nome",nome);
        RestUtils.getParam(FilmesMap.getHeader(),param, "filmes");
    }

    @Quando("realizo uma requisicao do tipo DELETE de Filmes")
    public void realizoUmaRequisicaoDoTipoDELETEDeFilmes() {
        RestUtils.delete(FilmesMap.getHeader(), "filmes/" + FilmesMap.id);
    }


}
