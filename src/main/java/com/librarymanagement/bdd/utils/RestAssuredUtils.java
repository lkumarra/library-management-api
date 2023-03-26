package com.librarymanagement.bdd.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.librarymanagement.bdd.modals.ResponseModal;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class RestAssuredUtils {

    public RestAssuredUtils() {
    }

    public RestAssuredUtils(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    public RestAssuredUtils(String baseUri, String basePath) {
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePath;
    }

    /**
     * Send Get Request
     *
     * @param endpoint   endPoint to send request
     * @param authToken  token for authentication
     * @param headersMap Map of headers
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendGetRequest(String endpoint, String authToken, Map<String, String> headersMap) {
        Response response = RestAssured.given()
                .log()
                .all()
                .auth()
                .oauth2(authToken)
                .headers(headersMap)
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send Get Request
     *
     * @param endpoint   endPoint to send request
     * @param headersMap Map of headers
     * @return ResponseModal
     */
    public ResponseModal sendGetRequest(String endpoint, Map<String, String> headersMap) {
        Response response = RestAssured.given()
                .log()
                .all()
                .headers(headersMap)
                .get(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send Get Request
     *
     * @param endpoint  endPoint to send request
     * @param authToken token for authentication
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendGetRequest(String endpoint, String authToken) {
        Response response = RestAssured.given().log().all().auth().oauth2(authToken).when()
                .get(endpoint).then().log().all().extract().response();
        return setResponse(response);
    }

    /**
     * Send Get Request
     *
     * @param endpoint endPoint to send request
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendGetRequest(String endpoint) {
        Response response = RestAssured.given()
                .log().all().when()
                .get(endpoint).then()
                .log().all().extract().response();
        return setResponse(response);
    }

    /**
     * Send Post request
     *
     * @param endpoint   endPoint to send request
     * @param authToken  token for authentication
     * @param headersMap Map of headers
     * @param request    Request to send
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendPostRequest(String endpoint, String authToken, Map<String, String> headersMap, String request) {
        Response response = RestAssured.given().
                log().all().auth().
                oauth2(authToken).
                headers(headersMap).
                body(request).
                when().post(endpoint).
                then().log().all()
                .extract().response();
        return setResponse(response);
    }

    /**
     * Send Post Request
     *
     * @param endpoint   endpoint to send request
     * @param headersMap Map of headers
     * @param request    Request to send
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendPostRequest(String endpoint, Map<String, String> headersMap, String request) {
        Response response = RestAssured.given()
                .log().all().headers(headersMap)
                .body(request).when().post(endpoint)
                .then().log().all().extract().response();
        return setResponse(response);
    }

    /**
     * Send Post request
     *
     * @param endpoint  endpoint to send request
     * @param authToken token for authentication
     * @param request   Request to send
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendPostRequest(String endpoint, String authToken, String request) {
        Response response = RestAssured.given()
                .log().all().auth().oauth2(authToken)
                .body(request).when().post(endpoint)
                .then().log().all().extract().response();
        return setResponse(response);
    }

    /**
     * Send Post request
     *
     * @param endpoint endpoint to send request
     * @param request  Request to send
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendPostRequest(String endpoint, String request) {
        Response response = RestAssured.given()
                .log().all().body(request).when().post(endpoint)
                .then().log().all().extract().response();
        return setResponse(response);
    }

    /**
     * Send put request
     *
     * @param endpoint   endpoint to send request
     * @param authToken  token for authentication
     * @param headersMap Map of headers
     * @param request    Request to send
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendPutRequest(String endpoint, String authToken, Map<String, String> headersMap, String request) {
        Response response = RestAssured.given()
                .log().all().auth().
                oauth2(authToken).headers(headersMap).
                body(request).when().put(endpoint)
                .then().log().all().extract().response();
        return setResponse(response);
    }

    /**
     * Send put request
     *
     * @param endpoint   endpoint to send request
     * @param headersMap Request to send
     * @param request    Request to send
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendPutRequest(String endpoint, Map<String, String> headersMap, String request) {
        Response response = RestAssured.given()
                .log()
                .all()
                .headers(headersMap)
                .body(request)
                .when()
                .put(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send put request
     *
     * @param endpoint  endpoint to send request
     * @param authToken token for authentication
     * @param request   Request to send
     * @return Response Mapped to {@link ResponseModal}
     */
    public ResponseModal sendPutRequest(String endpoint, String authToken, String request) {
        Response response = RestAssured.given()
                .log().all().auth()
                .oauth2(authToken)
                .body(request)
                .when()
                .put(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send put request
     *
     * @param endpoint endpoint to send request
     * @param request  Request to send
     * @return Response Mapped to {@link ResponseModal}
     */
    public ResponseModal sendPutRequest(String endpoint, String request) {
        Response response = RestAssured.given()
                .log()
                .all()
                .body(request)
                .put(endpoint)
                .then().log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send delete request
     *
     * @param endpoint   endpoint to send request
     * @param authToken  token for authentication
     * @param headersMap Map of headers
     * @return Response Mapped to {@link ResponseModal}
     */
    public ResponseModal sendDeleteRequest(String endpoint, String authToken, Map<String, String> headersMap) {
        Response response = RestAssured.given()
                .log()
                .all()
                .auth()
                .oauth2(authToken)
                .headers(headersMap)
                .delete(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send delete request
     *
     * @param endpoint  endpoint to send request
     * @param authToken token for authentication
     * @return Response mapped to {@link ResponseModal}
     */
    public ResponseModal sendDeleteRequest(String endpoint, String authToken) {
        Response response = RestAssured.given()
                .log()
                .all()
                .auth()
                .oauth2(authToken)
                .delete(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Send delete request
     *
     * @param endpoint endpoint to send request
     * @return Response Mapped to {@link ResponseModal}
     */
    public ResponseModal sendDeleteRequest(String endpoint) {
        Response response = RestAssured.given()
                .log()
                .all()
                .delete(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return setResponse(response);
    }

    /**
     * Mapped to response to objects
     *
     * @param response Response to map
     * @param clazz    Class to which response needs to be mapped
     * @param <T>      Class to map response
     * @return Object of the class with mapped response
     */
    @SuppressWarnings("unchecked")
    public <T> T mapResponseToClass(String response, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return (T) objectMapper.readValue(response, clazz);
        } catch (Exception e) {
            log.error("Error occurred while mapping the class : {} with response : {} with error message : {} ", clazz.getClass(), response, e.getMessage());
            return (T) clazz;
        }
    }

    /**
     * Convert java object to String
     *
     * @param object Object to convert
     * @return String of object
     */
    public String serializeObject(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Error occurred while serializing the object ");
            return "";
        }
    }

    /**
     * Set response to {@link ResponseModal}
     *
     * @param response {@link Response} to map
     * @return Mapped response
     */
    private ResponseModal setResponse(Response response) {
        ResponseModal responseModal = ResponseModal.builder().
                response(response.asString()).
                statusCode(response.statusCode()).
                headers(response.getHeaders()).responseTime(response.time()).build();
        return responseModal;
    }

}
