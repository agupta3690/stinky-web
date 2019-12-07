package com.bhf.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bhf.automation.dataProvider.ConfigFileReader;


public class BHFProHomePage {
	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();

	
	public BHFProHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Method to open the pro homepage URL.
	
	public void OpenProHomePage() {


		driver.get(configFileReader.getApplicationUrl());

	}
	
	public void VerifyHomePageURL() {
		
		Assert.assertTrue(driver.getCurrentUrl().equals("https://aem-dev1.brighthousefinancialpro.com"), "User is not on Homepage");
		System.out.println("Homepage opened!");
	}

	
}
