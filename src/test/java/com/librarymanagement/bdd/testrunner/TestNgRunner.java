package com.librarymanagement.bdd.testrunner;

import org.testng.annotations.BeforeSuite;

import com.librarymanagement.bdd.config.StartAPIServer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:features" }, glue = { "com.librarymanagement.bdd.hooks","com.librarymanagement.bdd.steps" }, publish = true)
public class TestNgRunner extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	public void startServer() {
		StartAPIServer.startApiServer();
	}

}
