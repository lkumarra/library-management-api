package com.librarymanagement.bdd.hooks;

import com.librarymanagement.bdd.config.StartAPIServer;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 1)
    public void startApiServer() {
        //StartAPIServer.startApiServer();
    }

}
