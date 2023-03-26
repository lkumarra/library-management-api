package com.librarymanagement.bdd.api;

import com.google.common.collect.Maps;
import static com.librarymanagement.bdd.constants.EndPoints.*;
import com.librarymanagement.bdd.modals.GenerateTokenModal;
import com.librarymanagement.bdd.modals.ResponseModal;
import static com.librarymanagement.bdd.context.TokenContext.*;

import java.util.Map;

public final class GenerateToken extends BaseAPI {

    private ResponseModal responseModal;

    public GenerateToken() {
        super(loginBasePath, loginEndPoint);
    }

    public void executeGenerateTokenAPI(String clientId, String clientSecret) {
        Map<String, String> map = Maps.newConcurrentMap();
        map.put("client_id", clientId);
        map.put("client_secret", clientSecret);
        responseModal = restAssuredUtils.sendGetRequest(endPoint, map);
        if (responseModal.getStatusCode() == 200) {
            GenerateTokenModal generateToken = restAssuredUtils.mapResponseToClass(responseModal.getResponse(), GenerateTokenModal.class);
            setToken(generateToken.getAccessToken());
        }
    }

    public void setInvalidToken(){
        setToken("InvalidToken");
    }

}
