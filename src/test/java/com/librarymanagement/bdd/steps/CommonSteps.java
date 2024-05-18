package com.librarymanagement.bdd.steps;

import com.librarymanagement.bdd.api.GenerateToken;
import static com.librarymanagement.bdd.config.Configuration.*;
import io.cucumber.java.en.Given;


public final class CommonSteps {

    private final GenerateToken generateToken;

    public CommonSteps(GenerateToken generateToken) {
        this.generateToken = generateToken;
    }

    @Given("I am a valid user")
    public void i_am_a_valid_user() {
        //generateToken.executeGenerateTokenAPI(getClientId(), getClientSecret());
    }


}
