Feature: BHF Advisor Login

  
  Scenario Outline: Successful login with valid credentials
    Given User is on BHF Advisor homepage
    When User navigates to the Login page
    And User enters valid "<username>" and "<password>"
    Then User gets logged into his/her account successfully

    Examples:
    
    |username|password|
    |edwardjonestest2|metlife1|
    |501|metlife1|