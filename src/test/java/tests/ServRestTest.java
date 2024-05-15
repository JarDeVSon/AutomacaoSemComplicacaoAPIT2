package tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServRestTest {

    Faker faker = new Faker();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://serverest.dev/#/";
    }

    @Test
    public void getListarUsuariosCadastrados() {
        //Act - Ação
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().log().all().extract().response();
        //Assert - Validação
        assertEquals(200, response.statusCode());

    }

    @Test
    public void getListarUsuariosCadastradoPorNome() {
        //Act - Ação
        Map<String, String> params = new HashMap<>();
        params.put("nome","Fulano da Silva");

        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .params(params)
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().log().all().extract().response();
        //Assert - Validação
        assertEquals(200, response.statusCode());
        String nome = response.jsonPath().get("usuarios[0].nome");
        assertTrue(nome.contains("Fulano da Silva"));

    }

    @Test
    public void getListarUsuariosCadastradoPorEmail() {
        //Act - Ação
        Map<String, String> params = new HashMap<>();
        params.put("email","fulano@qa.com");

        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .params(params)
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().log().all().extract().response();
        //Assert - Validação
        assertEquals(200, response.statusCode());
        String nome = response.jsonPath().get("usuarios[0].email");
        assertTrue(nome.contains("fulano@qa.com"));

    }

    @Test
    public void getListarUsuariosCadastradoPorID() {
        //Act - Ação
        Map<String, String> params = new HashMap<>();
        params.put("_id", "0uxuPY0cbmQhpEz1");

        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .params(params)
                .contentType(ContentType.JSON)
                .when()
                .get("usuarios")
                .then().log().all().extract().response();
        //Assert - Validação
        assertEquals(200, response.statusCode());
        String id = response.jsonPath().get("usuarios[0]._id");
        assertTrue(id.contains("0uxuPY0cbmQhpEz1"));

    }

    @Test
    public void postUsuariosComSucesso() {
        //Arrange - Preparação

        Map<String, Object> body = new HashMap<>();

        body.put("nome", faker.name().fullName());
        body.put("email", faker.internet().emailAddress());
        body.put("password", faker.internet().password(7, 15, true, true, true));
        body.put("administrador", faker.random().nextBoolean().toString());

        //Act - Ação
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("usuarios")
                .then().log().all().extract().response();

        //Assert - Validações
        assertEquals(201, response.statusCode());
        String id = response.jsonPath().get("_id");

        assertEquals(id, response.jsonPath().get("_id"));
        assertEquals("Cadastro realizado com sucesso", response.jsonPath().get("message"));


    }

    @Test
    public void postUsuariosComEmailCadastrado() {
        //Arrange - Preparação
        Map<String, Object> body = new HashMap<>();
        body.put("nome", faker.name().fullName());
        body.put("email", "fulano@qa.com");
        body.put("password", faker.internet().password(7, 15, true, true, true));
        body.put("administrador", faker.random().nextBoolean().toString());

        //Act - Ações
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("usuarios")
                .then().log().all().extract().response();

        //Assert - Validações
        assertEquals(400, response.statusCode());
        assertEquals("Este email já está sendo usado", response.jsonPath().get("message"));

    }
}
