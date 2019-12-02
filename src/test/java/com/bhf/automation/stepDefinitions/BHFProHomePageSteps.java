package com.bhf.automation.stepDefinitions;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.managers.PageObjectsManager;
import com.bhf.automation.managers.WebDriverManager;
import com.bhf.automation.objectRepository.BHFProHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BHFProHomePageSteps {
	
	TestContext testContext;
	BHFProHomePage proHomePage;
	
	public BHFProHomePageSteps(TestContext context) {
		
		testContext = context;
		proHomePage = testContext.getPageObjectsManager().getBHFProHomePage();
	}
	
	
	@Given("^User is on BHF Advisor homepage$")
	public void User_is_on_BHF_Advisor_homepage() throws Throwable {
		proHomePage.OpenProHomePage();
	    
	}

	@When("^User navigates to the Login page$")
	public void User_navigates_to_the_Login_page() throws Throwable {
		proHomePage.NavigateToLogin();
	    
	}
}
