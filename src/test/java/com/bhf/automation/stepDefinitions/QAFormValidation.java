package com.bhf.automation.stepDefinitions;

import com.bhf.automation.cucumber.TestContext;
import com.bhf.automation.managers.WebDriverManager;
import com.bhf.automation.objectRepository.QATestPage;
import com.codoid.products.exception.FilloException;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class QAFormValidation {
    TestContext testContext;
    QATestPage qaTestPage;
    WebDriver driver;

    public QAFormValidation(TestContext context) throws FilloException {
        testContext = context;
        qaTestPage = context.getPageObjectsManager().getQaTestPage();
    }
    //Cucumber Step Defination binding begins

    @Given("^User is on the QATestPage$")
    public void user_is_on_the_qatestpage() throws Throwable {
        qaTestPage.OpenQATestPage();
    }

    @Then("^FirstName is entered in the form$")
    public void firstname_is_entered_in_the_form() throws Throwable {
        qaTestPage.getFirstName();
    }

    @Then("^LastName is entered in the form$")
    public void lastname_is_entered_in_the_form() throws Throwable {
        qaTestPage.getLastName();
    }

    @Then("^Address is entered in the form$")
    public void address_is_entered_in_the_form() throws Throwable {
        qaTestPage.getAddress();
    }

    @Then("^City is entered in the form$")
    public void city_is_entered_in_the_form() throws Throwable {
        qaTestPage.getCity();
    }

    @Then("^State is selected in the form$")
    public void state_is_selected_in_the_form() throws Throwable {
        qaTestPage.getState();
    }

    @Then("^ZipCode is entered in the form$")
    public void zipcode_is_entered_in_the_form() throws Throwable {
        qaTestPage.getZip();
    }

    @Then("^PhoneNumber is entered in the form$")
    public void phonenumber_is_entered_in_the_form() throws Throwable {
        qaTestPage.getPhone();
    }

    @Then("^EmailAddress is entered in the form$")
    public void emailaddress_is_entered_in_the_form() throws Throwable {
        qaTestPage.getEmail();
    }


}
