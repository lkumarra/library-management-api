package com.librarymanagement.bdd.hooks;

import com.librarymanagement.bdd.helpers.GetAllStudentsHelper;
import com.librarymanagement.bdd.testrunner.TestNgRunner;
import io.cucumber.java.Before;

public final class Hooks {

    @Before(order = 1)
    public void cleanData(){
        GetAllStudentsHelper.deleteStudent();
    }

    @Before(order = 2, value = "@getAllStudents")
    public void createStudentData(){
        GetAllStudentsHelper.insertStudentData();
    }
}
