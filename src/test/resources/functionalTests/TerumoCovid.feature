@TerumoCovid
Feature: Validate the features available on the Terumo Covid-19 page

Background: User is on Terumo Covid page
Given User navigats to the Terumo Covid page URL


Scenario: Validate that the user is navigated to hompage when s/he clicks on the logo image
  
When User clicks on the logo image
Then User is navigated to the homepage


Scenario Outline: Validate that the user gets matching results when s/he performs the search
 
When User enters "<query>" in the search bar
And User clicks on the search button
Then User is navigated to the search result page displaying matching results
Examples:
|query|
|terumo|


Scenario: Validate that all the images on the page are loading

When User scrolls to the images
Then User can see the images properly


Scenario: Validate that all links on the page are working
 
When User clicks on the links available on the pages
Then User is navigated to the correct pages


Scenario Outline: Validate that the user can submit the enquiry form

When User fills "<name>", "<company>", "<email>", "<city>" and "<question>" 
Then The form gets submitted
Examples:
|name|company|email|city|question|
|test name|test company|testemail@example.com|test city|this is test question|

    
    