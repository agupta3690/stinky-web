package com.bhf.automation.stepDefinitions;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.objectRepository.BHFMetlifeLoginPage;
import com.bhf.automation.objectRepository.BHFProHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BHFMetlifeLoginPageSteps {

	TestContext testContext;
	BHFMetlifeLoginPage metlifeLoginPage;

	public BHFMetlifeLoginPageSteps(TestContext context) {

		testContext = context;
		metlifeLoginPage = testContext.getPageObjectsManager().getMetlifeLoginPage();
	}

	@When("^User enters valid \\\"(.*)\\\" and \\\"(.*)\\\"$")
	public void User_enters_valid_username_and_password(String uname, String pwd) throws Throwable {
		metlifeLoginPage.MetlifeLogin(uname, pwd);

	}

	@Then("^User gets logged into his/her account successfully$")
	public void User_gets_logged_into_his_her_account_successfully() throws Throwable {
		metlifeLoginPage.VerifyLoginStatus();
		testContext.getWebDriverManager().closeDriver();

	}
}