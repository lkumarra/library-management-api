package com.librarymanagement.bdd.steps;

import com.librarymanagement.bdd.api.BaseAPI;
import com.librarymanagement.bdd.api.GetAllStudentsAPI;
import com.librarymanagement.bdd.context.ScenarioContext;
import com.librarymanagement.bdd.responsevalidator.ResponseValidatorImpl;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public final class GetAllStudentsSteps {

    private final GetAllStudentsAPI geAllStudents;

    public GetAllStudentsSteps(ScenarioContext<BaseAPI> scenarioContext, ResponseValidatorImpl responseValidator){
        this.geAllStudents = new GetAllStudentsAPI(responseValidator);
        scenarioContext.setContext(BaseAPI.class, this.geAllStudents);
    }

    @When("I get all students")
    @When("I try to get all students")
    public void i_get_all_students() {
        System.out.println("I get all students steps");
        geAllStudents.executeGetAllStudentsAPI();
    }

    @Then("Verify the response from Db.")
    public void verify_the_response_from_Db() {
        Assert.assertTrue(geAllStudents.isActualAndExpectedResponseMatched());
    }
}
