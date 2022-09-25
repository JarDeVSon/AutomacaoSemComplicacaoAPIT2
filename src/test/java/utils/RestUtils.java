package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private Response response;


    public static Response post(Object json, ContentType contentType, String endpoint) {
        return RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .then().log().all()
                .extract()
                .response();
    }

    public static Response get(Map<String, String> header, String endpoint) {
        return RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }
}
