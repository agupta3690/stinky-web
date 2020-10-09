@FormValidation

Feature: BHF Form Validate

  Scenario: Check if the value is submitted in the form
    Given User is on the QATestPage
    Then FirstName is entered in the form
    Then LastName is entered in the form
    Then Address is entered in the form
    Then City is entered in the form
    Then State is selected in the form
    Then ZipCode is entered in the form
    Then PhoneNumber is entered in the form
    Then EmailAddress is entered in the form