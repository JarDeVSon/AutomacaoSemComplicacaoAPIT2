package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import utils.RestUtils;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class SharedSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int statusCode) {
        assertEquals(statusCode, RestUtils.getResponse().statusCode());
    }
    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        assertEquals(value,RestUtils.getResponse().jsonPath().get(key));
    }
    @E("valido que recebo uma lista vazia no response")
    public void validoQueReceboUmaListaVaziaNoResponse() {
        assertEquals(new ArrayList<>(),RestUtils.getResponse().jsonPath().get());
    }
}
