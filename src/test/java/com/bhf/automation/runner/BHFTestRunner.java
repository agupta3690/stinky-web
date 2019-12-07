package com.bhf.automation.runner;
import cucumber.api.CucumberOptions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.bhf.automation.managers.FileReaderManager;
import com.cucumber.listener.Reporter;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/functionalTests"},
		glue={"com.bhf.automation.stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:C:/Users/Arun Gupta/Argil DX LLC/Pulkit Jain - Reports/report.html"},
		
			//	target/cucumber-reports
				
			
				monochrome = true
		)

public class BHFTestRunner{

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + " 64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.13.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	
	}
	
}