@Functionals
Feature: BHF Advisor Login

  
  Scenario Outline: Successful login with valid credentials
    Given User is on BHF Advisor homepage
    When User navigates to the Login page
    And User enters valid "<username>" and "<password>"
    Then User gets logged into his/her account successfully
    When User clicks on Logout link in the header menu
    Then User gets logged out from his/her account successfully
    

    Examples:
    
    |username|password|
    |501|metlife1|
    
    
    