package com.librarymanagement.bdd.api;

import com.librarymanagement.bdd.config.Configuration;
import com.librarymanagement.bdd.utils.RestAssuredUtils;

public class BaseAPI {
    protected String endPoint;
    protected RestAssuredUtils restAssuredUtils;
    public BaseAPI(String basePath, String endPoint) {
        this.endPoint = endPoint;
        restAssuredUtils = new RestAssuredUtils(Configuration.getBaseUrl(), basePath);
    }
    public BaseAPI(String baseUrl, String basePath, String endPoint){
        this.endPoint = endPoint;
        restAssuredUtils = new RestAssuredUtils(baseUrl, basePath);
    }
}
