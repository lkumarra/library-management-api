package com.librarymanagement.bdd.api;

import com.google.common.collect.Maps;
import com.librarymanagement.bdd.constants.EndPoints;
import com.librarymanagement.bdd.modals.GenerateTokenModal;
import com.librarymanagement.bdd.modals.ResponseModal;

import java.util.Map;

public class GenerateToken extends BaseAPI {

    private ResponseModal responseModal;

    public GenerateToken() {
        super(EndPoints.loginBasePath, EndPoints.loginEndPoint);
    }

    public void executeGenerateTokenAPI(String clientId, String clientSecret) {
        Map<String, String> map = Maps.newConcurrentMap();
        map.put("client_id", clientId);
        map.put("client_secret", clientSecret);
        responseModal = restAssuredUtils.sendGetRequest(endPoint, map);
        if (responseModal.getStatusCode() == 200) {
            GenerateTokenModal generateToken = restAssuredUtils.mapResponseToClass(responseModal.getResponse(), GenerateTokenModal.class);
            System.out.println(generateToken.getAccessToken());
            System.setProperty("token", generateToken.getAccessToken());
        }
    }

}
