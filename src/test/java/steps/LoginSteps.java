package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUtils;

import java.util.Map;

public class LoginSteps {


    @Dado("que tenho um payload valido da API de Login")
    public void queTenhoUmPayloadValidoDaAPIDeLogin() {
        LoginMap.initLogin();
    }
    @Dado("que tenho um payload invalido da API de Login")
    public void queTenhoUmPayloadInvalidoDaAPIDeLogin(Map<String, Object> map) {
        LoginMap.getLogin().putAll(map);
    }
    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON,"auth");
    }
    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
        LoginMap.token = RestUtils.getResponse().jsonPath().get("token").toString();
    }

    @Dado("que tenha realizado o login com dados validos")
    public void queTenhaRealizadoOLoginComDadosValidos() {
        queTenhoUmPayloadValidoDaAPIDeLogin();
        envioUmaRequisicaoDoTipoPOSTDeLogin();
        armazenoOTokenQueReceboDoResponseDeLogin();
    }


}
