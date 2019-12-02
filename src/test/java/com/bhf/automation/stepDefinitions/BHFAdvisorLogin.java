package com.bhf.automation.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.bhf.automation.managers.PageObjectsManager;
import com.bhf.automation.managers.WebDriverManager;
import com.bhf.automation.objectRepository.BHFMetlifeLoginPage;
import com.bhf.automation.objectRepository.BHFProHomePage;
import com.bhf.automation.objectRepository.BHFUserDashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BHFAdvisorLogin {

	WebDriver driver;
	
	BHFMetlifeLoginPage metlifeLoginPage;
	BHFProHomePage proHomePage;
	BHFUserDashboard userDashboard;
	PageObjectsManager pageObjectsManager;
	WebDriverManager webDriverManager;
	
	
	@Given("^User is on BHF Advisor homepage$")
	public void User_is_on_BHF_Advisor_homepage() throws Throwable {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectsManager = new PageObjectsManager(driver);
		proHomePage = pageObjectsManager.getBHFProHomePage();
		proHomePage.OpenProHomePage();
	    
	}

	@When("^User navigates to the Login page$")
	public void User_navigates_to_the_Login_page() throws Throwable {
		proHomePage.NavigateToLogin();
	    
	}

	@When("^User enters valid \\\"(.*)\\\" and \\\"(.*)\\\"$")
	public void User_enters_valid_username_and_password(String uname, String pwd) throws Throwable {
		metlifeLoginPage = pageObjectsManager.getMetlifeLoginPage();
		metlifeLoginPage.MetlifeLogin(uname, pwd);
	   
	}

	@Then("^User gets logged into his/her account successfully$")
	public void User_gets_logged_into_his_her_account_successfully() throws Throwable {
		metlifeLoginPage.VerifyLoginStatus();
		webDriverManager.closeDriver();
		
	  
	}
}

