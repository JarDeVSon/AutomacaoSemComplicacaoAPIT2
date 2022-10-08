package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlataformaFilmesTest {
    static String token;
    @BeforeAll
    public static void validarLoginMap() {
        RestUtils.setBaseURI("http://localhost:8080/");
        Map<String, String> map = new HashMap<>();
        map.put("email","aluno@email.com");
        map.put("senha","123456");
        Response response = RestUtils.post(map,ContentType.JSON,"auth");

        assertEquals(200, response.statusCode());

        token = response.jsonPath().get("token");
        System.out.println(token);
    }
    @Test
    public void validarConsultaCategoria(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+token);
        Response response = RestUtils.get(header,"categorias");
        assertEquals(200, response.statusCode());
        List<String> listCategorias = response.jsonPath().get("tipo");
        assertTrue(listCategorias.contains("Terror"));

    }

}
