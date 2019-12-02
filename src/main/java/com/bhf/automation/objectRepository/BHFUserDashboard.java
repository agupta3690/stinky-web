package com.bhf.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BHFUserDashboard {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"login-logout-container\"]/li[3]/a")
	@CacheLookup
	WebElement AccountChevron;

	@FindBy(partialLinkText = "Logout")
	@CacheLookup
	WebElement LogoutLink;

		

	public BHFUserDashboard(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}