package com.bhf.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bhf.automation.dataProvider.ConfigFileReader;


public class BHFHeaderNavigation {

	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();

	@FindBy(className = "login-gn")
	@CacheLookup
	public WebElement LoginLink;
	
	@FindBy(id = "loginLink")
	@CacheLookup
	public WebElement GreetingLink;
	
	@FindBy(xpath = "//*[@id=\"login-logout-container\"]/li[3]/a")
	@CacheLookup
	WebElement AccountChevron;

	@FindBy(partialLinkText = "Logout")
	@CacheLookup
	WebElement LogoutLink;


	public BHFHeaderNavigation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Method to navigate to the Login page.

	public void NavigateToLogin() {

		LoginLink.click();
	}

	//Method to verify login status.

	public void VerifyLoginStatus() {

		SoftAssert assertion = new SoftAssert();
		assertion.assertFalse(GreetingLink.getText().contains("Login"), "Login Failed");
		System.out.println("Login Successful!");
		assertion.assertAll();

	}

	public void clickOnLogoutLink() throws InterruptedException {

		GreetingLink.click();
		LogoutLink.click();
		Thread.sleep(7000);
	}

	public void VerifyLogoutStatus() {

		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(driver.getCurrentUrl().contains("logoff"), "Logout Failed");
		System.out.println("Logout Successful!");
		assertion.assertAll();
		
		
	}

	

}
