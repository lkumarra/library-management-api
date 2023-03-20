package com.librarymanagement.bdd.api;

import com.librarymanagement.bdd.constants.EndPoints;
import com.librarymanagement.bdd.context.ResponseModalContext;
import com.librarymanagement.bdd.helpers.GetAllStudentsHelper;
import com.librarymanagement.bdd.modals.GetAllStudentsModal;
import com.librarymanagement.bdd.modals.ResponseModal;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import java.util.List;

@Slf4j
public class GetAllStudentsAPI extends BaseAPI {

    ResponseModal responseModal;
    public GetAllStudentsAPI() {
        super(EndPoints.studentBasePath, EndPoints.getAllStudents);
    }

    public void executeGetAllStudentsAPI() {
        String authToken = System.getProperty("token");
        responseModal = restAssuredUtils.sendGetRequest(endPoint, authToken);
        log.info("Response for endpoint : {} is : {}", endPoint, responseModal.getResponse());
        ResponseModalContext.setResponseModal(responseModal);
    }

    public boolean isActualAndExpectedResponseMatched() {
        GetAllStudentsModal[] getAllStudentsModalsArray = restAssuredUtils.mapResponseToClass(responseModal.getResponse(), GetAllStudentsModal[].class);
        List<GetAllStudentsModal> actualResponse = Arrays.asList(getAllStudentsModalsArray);
        List<GetAllStudentsModal> expectedResponse = GetAllStudentsHelper.getAllStudentsModalList();
        return actualResponse.equals(expectedResponse);
    }

}
