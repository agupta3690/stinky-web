package com.bhf.automation.objectRepository;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bhf.automation.dataProvider.ConfigFileReader;


public class BHFProHomePage {
	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();


	@FindBy(className = "top-nav")
	@CacheLookup
	WebElement Header;

	@FindBy(id = "footer")
	@CacheLookup
	WebElement Footer;



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

	public void VerifyIfHeaderPresent() {

		SoftAssert assertion= new SoftAssert();
		
		assertion.assertEquals(3, 5);
		
	try {
		
		assertion.assertFalse(Header.isDisplayed(), "Header is not present. Test Failed!");
		System.out.println("abhinav-1");
		//System.out.println("Header is present. Test Passed!");
	}catch (Exception e) {
		
		System.out.println("abhinav");
	}
		
	assertion.assertAll();
				
	}

	public void VerifyIfFooterPresent() {

		Assert.assertFalse(Footer.isDisplayed(), "Footer is not present. Test Failed!");
		System.out.println("Footer is present. Test Passed!");
	}

}
