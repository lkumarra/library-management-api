package com.librarymanagement.bdd.steps;

import com.librarymanagement.bdd.HttpStatusCodes;
import com.librarymanagement.bdd.HttpStatusCodes.*;
import com.librarymanagement.bdd.api.GenerateToken;
import com.librarymanagement.bdd.config.Configuration;
import com.librarymanagement.bdd.context.ResponseModalContext;
import com.librarymanagement.bdd.modals.ResponseModal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonSteps {

    GenerateToken generateToken;

    public CommonSteps(GenerateToken generateToken) {
        this.generateToken = generateToken;
    }

    @Given("I am a valid user")
    public void i_am_a_valid_user() {
        generateToken.executeGenerateTokenAPI(Configuration.getClientId(), Configuration.getClientSecret());
    }

    @Given("I am a valid user with insufficient permissions")
    public void i_am_a_valid_user_with_insufficient_permissions() {
        generateToken.executeGenerateTokenAPI(Configuration.getStudentClientId()
                , Configuration.getStudentClientSecret());
    }

    @Given("I am a invalid user")
    public void i_am_a_invalid_user() {
        System.setProperty("token", "invalid");
    }

    @Then("Response should returned with status code {string}.")
    public void response_should_returned_with_status_code(String statusCode) {
        StatusCodesEnum statusCodesEnum = Enum.valueOf(StatusCodesEnum.class, statusCode);
        Integer actualStatusCode = HttpStatusCodes.getHttpStatusCodeValue(statusCodesEnum);
        ResponseModal responseModal = ResponseModalContext.getResponseModal();
        Assert.assertEquals(responseModal.getStatusCode(), actualStatusCode);
    }

}
