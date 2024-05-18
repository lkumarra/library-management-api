package com.librarymanagement.bdd.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:features" }, glue = { "com.librarymanagement.bdd.hooks","com.librarymanagement.bdd.steps" }, publish = true)
public final class TestNgRunner extends AbstractTestNGCucumberTests {

}
