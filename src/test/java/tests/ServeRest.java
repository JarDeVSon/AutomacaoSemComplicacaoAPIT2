package tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServeRest {
    Faker faker = new Faker();
    static String id;

    @Test
    public void testCadastrarUsuarioComSucesso(){
        //Arrange
        RestAssured.baseURI = "https://serverest.dev/#/";

        Map<String, Object> body = new HashMap<>();
        body.put("nome",faker.name().fullName());
        body.put("email",faker.internet().emailAddress());
        body.put("password",faker.internet().password(10,15,true,true,true));
        body.put("administrador",faker.random().nextBoolean().toString());

        //Act
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("usuarios")
                .then().log().all()
                .extract().response();
        //Assert
        assertEquals(201, response.statusCode());
        assertEquals("Cadastro realizado com sucesso", response.jsonPath().get("message"));
        id = response.jsonPath().get("_id");
        assertEquals(id, response.jsonPath().get("_id"));

    }

    @Test
    public void testCadastrarUsuarioEmailJaCadastrado(){
        //Arrange
        RestAssured.baseURI = "https://serverest.dev/#/";

        Map<String, Object> body = new HashMap<>();
        body.put("nome","Tutano da Silva");
        body.put("email","Tutano@qa.com.br");
        body.put("password","teste");
        body.put("administrador","true");

        //Act
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("usuarios")
                .then().log().all()
                .extract().response();
        //Assert
        assertEquals(400, response.statusCode());
        assertEquals("Este email já está sendo usado", response.jsonPath().get("message"));

    }
}
