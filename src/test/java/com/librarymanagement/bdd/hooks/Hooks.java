package com.librarymanagement.bdd.hooks;

import com.librarymanagement.bdd.config.StartAPIServer;
import com.librarymanagement.bdd.helpers.GetAllStudentsHelper;
import com.librarymanagement.bdd.testrunner.TestNgRunner;
import io.cucumber.java.Before;

public class Hooks {

    boolean serverAlreadyStarted = false;
    @Before(order = 1)
    public void startServer(){
        if(!TestNgRunner.isRunningFromTestNg && !serverAlreadyStarted) {
            serverAlreadyStarted = true;
            StartAPIServer.startApiServer();
        }
    }
    @Before(order = 2)
    public void cleanData(){
        GetAllStudentsHelper.deleteStudent();
    }

    @Before(order = 3, value = "@getAllStudents")
    public void createStudentData(){
        GetAllStudentsHelper.insertStudentData();
    }
}
