package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static String setBaseURI(String uri) {
        return RestAssured.baseURI = uri;
    }

    public static Response post(Object json, ContentType contentType, String endpoint) {
        return response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .then().log().all()
                .extract()
                .response();
    }
   public static Response postHeader(Map<String, String> header, Object json, ContentType contentType, String endpoint) {
        return response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(header)
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .then().log().all()
                .extract()
                .response();
    }
    public static Response put(Map<String, String> header, Object json, ContentType contentType, String endpoint) {
        return response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(header)
                .contentType(contentType)
                .body(json)
                .when()
                .put(endpoint)
                .then().log().all()
                .extract()
                .response();
    }
    public static Response get(Map<String, String> header, String endpoint) {
        return response =  RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }
    public static Response getParam(Map<String, String> header, Map<String, String> param, String endpoint) {
        return response =  RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(header)
                .params(param)

                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }

    public static Response delete(Map<String, String> header, String endpoint) {
        return response =  RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .delete(endpoint)
                .then().log().all()
                .extract().response();
    }
}
