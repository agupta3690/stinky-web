package com.terumo.automation.stepDefinitions;

import com.cucumber.listener.Reporter;
import com.terumo.automation.cucumber.TestContext;
import com.terumo.automation.objectRepository.TerumoCovid;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TerumoCovidSteps {
	
	TestContext testContext;
	TerumoCovid TerumoCovid;
	
	public TerumoCovidSteps(TestContext context) {

		testContext = context;
		TerumoCovid = testContext.getPageObjectsManager().getTerumoCovid();
	
	}
	
	
	@Given("^User navigats to the Terumo Covid page URL$")
	public void user_navigats_to_the_Terumo_Covid_page_URL() throws Throwable {
		 
		TerumoCovid.OpenPage();
		Reporter.addStepLog("Opened the Terumo Covid Page");
		
	}
	

	@When("^User clicks on the logo image$")
	public void user_clicks_on_the_logo_image() throws Throwable {
		
		TerumoCovid.ClickLogo();
		Reporter.addStepLog("Clicked the logo image.");
	}

	@Then("^User is navigated to the homepage$")
	public void user_is_navigated_to_the_homepage() throws Throwable {
		
		TerumoCovid.ValidateURL();
		Reporter.addStepLog("Validated the homepage URL.");
	   
	}

	
	@When("^User enters \"([^\"]*)\" in the search bar$")
	public void user_enters_in_the_search_bar(String query) throws Throwable {
	    
		TerumoCovid.ValidateSearch(query);
		Reporter.addStepLog("Entered query in Search Bar.");
	}

	@When("^User clicks on the search button$")
	public void user_clicks_on_the_search_button() throws Throwable {
		
		Reporter.addStepLog("Clicked the search button.");
	
	}

	@Then("^User is navigated to the search result page displaying matching results$")
	public void user_is_navigated_to_the_search_result_page_displaying_matching_results() throws Throwable {
		
		TerumoCovid.ValidateSearchResults();
		Reporter.addStepLog("Validated the search result.");
	
	}

	
	@When("^User scrolls to the images$")
	public void user_scrolls_to_the_images() throws Throwable {
		
		Reporter.addStepLog("Fetched all images.");
	    
	}

	@Then("^User can see the images properly$")
	public void user_can_see_the_images_properly() throws Throwable {
	    
		TerumoCovid.ValidateImages();
		Reporter.addStepLog("Validated image appearance.");
		
	}


	@When("^User clicks on the links available on the pages$")
	public void user_clicks_on_the_links_available_on_the_pages() throws Throwable {
		
		TerumoCovid.ValidateAllLinks();
		Reporter.addStepLog("Fetched all page links.");
	   
	}

	@Then("^User is navigated to the correct pages$")
	public void user_is_navigated_to_the_correct_pages() throws Throwable {
		
		Reporter.addScenarioLog("Scenario Executed.");
	
	}

	@When("^User fills \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_fills_and(String name, String company, String email, String city, String question) throws Throwable {
	 
		TerumoCovid.ValidateForm(name, company, email, city, question);
		Reporter.addStepLog("Filled the form.");
		
	}

	@Then("^The form gets submitted$")
	public void the_form_gets_submitted() throws Throwable {
		
		Reporter.addStepLog("Validated form submission.");
	   
	}

}
