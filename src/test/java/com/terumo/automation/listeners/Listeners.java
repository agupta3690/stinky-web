package com.terumo.automation.listeners;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import cucumber.api.Scenario;

import com.terumo.automation.managers.WebDriverManager;
import com.terumo.automation.stepDefinitions.Hooks;



public class Listeners implements ITestListener{


	public void onTestStart(ITestResult result) {



	}


	public void onTestSuccess(ITestResult result) {

		System.out.print(result);


	}


	public void onTestFailure(ITestResult result) {

//		JiraTicketLogger JIM = new JiraTicketLogger();
//		JIM.JiraServiceProvider("https://pranjal-automation.atlassian.net/", "pranjal12december@gmail.com", "4A2nCpnUSMe92zpxt06D311C", "AF");
//		String summary = "The test '"+Hooks.getTestCaseName()+"' has failed.";
//		String description = result.getThrowable().getMessage()+"\n";
//		description.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
//		JIM.createJiraIssue("Bug", summary, description,"pranjal12december");

	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) {

		
		}
		

	

	public void onFinish(ITestContext context) {

		//Sending the Reports over email

		EmailReport email = new EmailReport();
		try {
			email.EmailReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}



