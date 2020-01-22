package com.bhf.automation.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.junit.runner.Runner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.dataProvider.ConfigFileReader;
import com.bhf.automation.listeners.EmailReport;
import com.bhf.automation.objectRepository.BHFProHomePage;
import com.bhf.automation.runner.TestRunner;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	ConfigFileReader configFileReader = new ConfigFileReader();
	public static String screenshotFilePath;
	static String TestCaseName;
	
	public Hooks(TestContext context) {

		testContext = context;
	}

	@Before
	public static String BeforeScenario(Scenario scenario) {

		String FeatureName = "";
		String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
		FeatureName = FeatureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
		String TestName = scenario.getName();

		System.out.println("The test '"+TestName+"' under the Feature '"+FeatureName+"' has started executing.");
		
		TestCaseName = TestName;
		
		return TestName;
	}


	@After(order = 2)
	public void afterScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");

			try {
				//This takes a screenshot from the driver and save it to the specified location
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);

				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				
				screenshotFilePath = "C:/Users/Arun Gupta/Argil DX LLC/Pulkit Jain - Reports/Screenshots/"+screenshotName+"_"+configFileReader.getTimeStamp()+".png";
				
				File destinationPath = new File(screenshotFilePath);

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
	public void AfterSteps() throws IOException {


		testContext.getWebDriverManager().closeDriver();

	}
	
	public static String getTestCaseName() {
		
		return TestCaseName;
	}
}
