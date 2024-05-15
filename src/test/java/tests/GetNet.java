package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GetNet {

    @Test
    public void testCreateSucesso(){
        //Preparacao
        RestAssured.baseURI = "https://reqres.in/api/";

        // Criar Request
        HashMap<String, Object> body = new HashMap<>();
        body.put("name","morpheus");
        body.put("job","pedreiro");
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().response();

        // Validações
        assertEquals(201,response.statusCode());


    }
}
