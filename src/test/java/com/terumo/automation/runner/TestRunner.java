package com.terumo.automation.runner;
import cucumber.api.CucumberOptions;

import java.io.File;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.terumo.automation.cucumber.TestContext;
import com.terumo.automation.dataProvider.ConfigFileReader;
import com.terumo.automation.listeners.EmailReport;
import com.terumo.automation.managers.FileReaderManager;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features = {"src/test/resources/functionalTests"},
		glue={"com.bhf.automation.stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
		tags = {"@TerumoCovid","~@skip"},

		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{


	private TestNGCucumberRunner testNGCucumberRunner;
	static ConfigFileReader configFileReader = new ConfigFileReader();
	public static String filePath;

	@BeforeClass
	public static void setup() {

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		filePath = "C:/Users/Arun Gupta/Documents/Reports/"+"report_"+configFileReader.getTimeStamp()+".html";
		extentProperties.setReportPath(filePath);
		
		//C:/Users/Arun Gupta/Argil DX LLC/Pulkit Jain - Reports/
		
	}


	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}


	@DataProvider
	public Object[][] features() {

		if(testNGCucumberRunner == null){
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}
		
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass
	public void tearDownClass() throws Exception {

		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + " 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.13.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");


		testNGCucumberRunner.finish();
		



	}
	
}

