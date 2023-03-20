package com.librarymanagement.bdd.steps;

import com.librarymanagement.bdd.api.GetAllStudentsAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GetAllStudentsSteps {

    private GetAllStudentsAPI geAllStudents;

    public GetAllStudentsSteps(GetAllStudentsAPI geAllStudents){
        this.geAllStudents = geAllStudents;
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
