package com.librarymanagement.bdd.api;

import static com.librarymanagement.bdd.constants.EndPoints.*;
import static com.librarymanagement.bdd.context.ResponseModalContext.*;
import static com.librarymanagement.bdd.helpers.GetAllStudentsHelper.*;
import static com.librarymanagement.bdd.context.TokenContext.*;
import com.librarymanagement.bdd.modals.GetAllStudentsModal;
import com.librarymanagement.bdd.modals.ResponseModal;
import com.librarymanagement.bdd.responsevalidator.ResponseValidator;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public final class GetAllStudentsAPI extends BaseAPI {
    private ResponseModal responseModal;
    public GetAllStudentsAPI(ResponseValidator responseValidator) {
        super(responseValidator,studentBasePath, getAllStudents);
    }

    public void executeGetAllStudentsAPI() {
        responseModal = restAssuredUtils.sendGetRequest(endPoint);
        log.info("Response for endpoint : {} is : {}", endPoint, responseModal.getResponse());
        setResponseModalGlobal(responseModal);
    }

    public boolean isActualAndExpectedResponseMatched() {
        List<GetAllStudentsModal> actualResponse = Arrays.stream(restAssuredUtils.mapResponseToClass(responseModal.getResponse(), GetAllStudentsModal[].class)).collect(Collectors.toList());
        List<GetAllStudentsModal> expectedResponse = getAllStudentsModalList();
        return actualResponse.equals(expectedResponse);
    }

}
