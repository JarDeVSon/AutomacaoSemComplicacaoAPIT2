package steps;

import io.cucumber.java.pt.Entao;
import maps.LoginMap;
import utils.RestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hooks {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int statusCode) {
        assertEquals(statusCode, RestUtils.getResponse().statusCode(),"Status code diferente");
    }
    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
       LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }
}
