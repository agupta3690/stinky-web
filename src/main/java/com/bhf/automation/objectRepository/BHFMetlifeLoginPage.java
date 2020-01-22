package com.bhf.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BHFMetlifeLoginPage {
	
	WebDriver driver;
		
	@FindBy(id = "USER")
	@CacheLookup
	WebElement Username;
	
	@FindBy(id = "PASSWORD")
	@CacheLookup
	WebElement Password;
	
	@FindBy(id = "submit")
	@CacheLookup
	WebElement SubmitBtn;
	
	
	public BHFMetlifeLoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Method to perform the Login operation which receives username and password as arguments.
	
	public void MetlifeLogin(String uname, String pwd) throws InterruptedException {
		
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
		SubmitBtn.click();
		Thread.sleep(10000);
	}
	
}

