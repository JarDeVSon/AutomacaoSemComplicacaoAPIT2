package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlataformaFilmesTest {

    @Test
public void validarLogin(){
        RestAssured.baseURI = "http://localhost:8080/";

        String json = "{\n" +
                "  \"email\": \"aluno@email.com\",\n" +
                "  \"senha\": \"123456\"\n" +
                "}";

        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("auth")
                .thenReturn();

        assertEquals(200, response.statusCode());

        String token = response.jsonPath().get("token");
        System.out.println(token);

    }
}
