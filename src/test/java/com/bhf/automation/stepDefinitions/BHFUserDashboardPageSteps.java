package com.bhf.automation.stepDefinitions;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.objectRepository.BHFHeaderNavigation;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BHFUserDashboardPageSteps {

	TestContext testContext;
	BHFHeaderNavigation headerNavigation;

	public BHFUserDashboardPageSteps(TestContext context) {

		testContext = context;
		headerNavigation = testContext.getPageObjectsManager().getBHFHeaderNavigation();

	}

//	@Given("^User is already logged in$")
//	public void user_is_already_logged_in() throws Throwable {
//		headerNavigation.VerifyLoginStatus();
//		Reporter.addStepLog("Verified that the user is already logged in");
		

	@When("^User clicks on Logout link in the header menu$")
	public void user_clicks_on_Logout_link_in_the_header_menu() throws Throwable {
		headerNavigation.clickOnLogoutLink();
		Reporter.addStepLog("Clicked on the Logout link");
	}

	@Then("^User gets logged out from his/her account successfully$")
	public void user_gets_logged_out_from_his_her_account_successfully() throws Throwable {
		headerNavigation.VerifyLogoutStatus();
		Reporter.addStepLog("Verified that the user is logged out successfully");
	}

}
