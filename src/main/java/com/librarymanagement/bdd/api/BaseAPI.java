package com.librarymanagement.bdd.api;

import static com.librarymanagement.bdd.config.Configuration.*;
import com.librarymanagement.bdd.modals.ErrorResponseModal;
import com.librarymanagement.bdd.modals.ResponseModal;
import com.librarymanagement.bdd.responsevalidator.ResponseValidator;
import com.librarymanagement.bdd.utils.RestAssuredUtils;

public class BaseAPI {
    protected String endPoint;
    protected RestAssuredUtils restAssuredUtils;
    protected ResponseValidator responseValidator;
    public BaseAPI(ResponseValidator responseValidator,String basePath, String endPoint) {
        this.endPoint = endPoint;
        restAssuredUtils = new RestAssuredUtils(getBaseUrl(), basePath);
        this.responseValidator = responseValidator;
    }
    public BaseAPI(ResponseValidator responseValidator, String baseUrl, String basePath, String endPoint){
        this.endPoint = endPoint;
        restAssuredUtils = new RestAssuredUtils(baseUrl, basePath);
        this.responseValidator = responseValidator;
    }

    public BaseAPI(String basePath, String endPoint) {
        this.endPoint = endPoint;
        restAssuredUtils = new RestAssuredUtils(getBaseUrl(), basePath);
    }
    public void verifyResponse(ErrorResponseModal responseModal){
        this.responseValidator.verifyResponse(responseModal);
    }
}
