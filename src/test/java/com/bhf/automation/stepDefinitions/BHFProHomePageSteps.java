package com.bhf.automation.stepDefinitions;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.objectRepository.BHFHeaderNavigation;
import com.bhf.automation.objectRepository.BHFProHomePage;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BHFProHomePageSteps {

	TestContext testContext;
	BHFProHomePage proHomePage;
	BHFHeaderNavigation headerNavigation;

	public BHFProHomePageSteps(TestContext context) {

		testContext = context;
		proHomePage = testContext.getPageObjectsManager().getBHFProHomePage();
		headerNavigation = testContext.getPageObjectsManager().getBHFHeaderNavigation();
	}


	@Given("^User is on BHF Advisor homepage$")
	public void User_is_on_BHF_Advisor_homepage(String step) throws Throwable {

		proHomePage.OpenProHomePage();
		step = "Open the BHF Pro Home Page";
		Reporter.addStepLog("Opened the BHF Pro Home Page");


	}

	@When("^User navigates to the Login page$")
	public void User_navigates_to_the_Login_page() throws Throwable {
		headerNavigation.NavigateToLogin();
		Reporter.addStepLog("Clicked the Login link");

	}


	@Then("^The header should be present$")
	public void the_header_should_be_present() throws Throwable {
		proHomePage.VerifyIfHeaderPresent();
		Reporter.addStepLog("Verified the presence of Header on the page");
	}

	@Then("^The footer should be present$")
	public void the_footer_should_be_present() throws Throwable {
		proHomePage.VerifyIfFooterPresent();
		Reporter.addStepLog("Verified the presence of Footer on the page");
	}

}
