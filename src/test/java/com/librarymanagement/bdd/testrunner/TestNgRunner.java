package com.librarymanagement.bdd.testrunner;

import org.testng.annotations.BeforeSuite;

import com.librarymanagement.bdd.config.StartAPIServer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:features" }, glue = { "com.librarymanagement.bdd.hooks","com.librarymanagement.bdd.steps" }, publish = true)
public final class TestNgRunner extends AbstractTestNGCucumberTests {

	public static boolean isRunningFromTestNg = false;
	@BeforeSuite
	public void startServer() {
		isRunningFromTestNg = true;
		StartAPIServer.startApiServer();
	}

}
