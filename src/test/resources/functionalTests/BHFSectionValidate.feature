@Functional
Feature: BHF Section Validate

  
  Scenario: Validate that the header is present
    Given User is on BHF Advisor homepage
    Then The header should be present

    
  Scenario: Validate that the footer is present
    Given User is on BHF Advisor homepage
    Then The footer should be present