package com.bhf.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhf.automation.dataProvider.ConfigFileReader;


public class BHFProHomePage {
	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();

	@FindBy(className = "login-gn")
	@CacheLookup
	public WebElement LoginLink;


	public BHFProHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Method to open the pro homepage URL.
	
	public void OpenProHomePage() {


		driver.get(configFileReader.getApplicationUrl());

	}

	//Method to open the Login form.

	public void NavigateToLogin() {

		LoginLink.click();
	}

}
