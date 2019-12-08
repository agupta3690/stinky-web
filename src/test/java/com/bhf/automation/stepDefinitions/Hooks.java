package com.bhf.automation.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.dataProvider.ConfigFileReader;
import com.bhf.automation.objectRepository.BHFProHomePage;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	ConfigFileReader configFileReader = new ConfigFileReader();

	
	public Hooks(TestContext context) {
		
		testContext = context;
	}
	
	@Before("@InvokeBrowser")
	public void SetUp() {

		//testContext.getWebDriverManager().getDriver();
		
		System.out.println("This is the before hook");
		
		
		

	}

	
	@After(order = 1)
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	
	 try {
	 //This takes a screenshot from the driver and save it to the specified location
	 File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 File destinationPath = new File("C:/Users/Arun Gupta/Argil DX LLC/Pulkit Jain - Reports/Screenshots/"+screenshotName+"_"+configFileReader.getTimeStamp()+".png");
	 
	 //System.getProperty("user.dir")
	 
	 
	 //Copy taken screenshot from source location to destination location
	 Files.copy(sourcePath, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 }
	 
	 
	 @After(order = 0)
	 public void AfterSteps() {
	 testContext.getWebDriverManager().closeDriver();
	 }
}
