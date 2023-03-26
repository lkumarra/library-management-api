package com.librarymanagement.bdd.steps;

import com.librarymanagement.bdd.HttpStatusCodes;
import com.librarymanagement.bdd.api.BaseAPI;
import com.librarymanagement.bdd.context.ScenarioContext;
import com.librarymanagement.bdd.modals.ErrorResponseModal;
import com.librarymanagement.bdd.modals.ResponseModal;
import io.cucumber.java.en.Then;

public final class ResponseValidateSteps {

    private final BaseAPI baseAPI;

    public ResponseValidateSteps(ScenarioContext<BaseAPI> baseAPIScenarioContext){
        this.baseAPI = baseAPIScenarioContext.getContext(BaseAPI.class);
    }

    @Then("Response should returned with status code {string}.")
    public void response_should_returned_with_status_code(String statusCode) {
        HttpStatusCodes.StatusCodesEnum statusCodesEnum = Enum.valueOf(HttpStatusCodes.StatusCodesEnum.class, statusCode);
        Integer actualStatusCode = HttpStatusCodes.getHttpStatusCodeValue(statusCodesEnum);
        ErrorResponseModal errorResponseModal = ErrorResponseModal.builder().status(actualStatusCode).build();
        this.baseAPI.verifyResponse(errorResponseModal);
    }

    @Then("Response should returned with status code {string}, error as {string} and message as {string}.")
    public void response_should_returned_with_status_code_error_as_and_message_as(String statusCode, String error, String message) {
        HttpStatusCodes.StatusCodesEnum statusCodesEnum = Enum.valueOf(HttpStatusCodes.StatusCodesEnum.class, statusCode);
        Integer actualStatusCode = HttpStatusCodes.getHttpStatusCodeValue(statusCodesEnum);
        ErrorResponseModal errorResponseModal = ErrorResponseModal.builder().status(actualStatusCode).error(error).message(message).build();
        this.baseAPI.verifyResponse(errorResponseModal);
    }
}
