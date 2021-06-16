package com.terumo.automation.objectRepository;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.terumo.automation.dataProvider.ConfigFileReader;

public class TerumoCovid {


	WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();


	@FindBy(xpath="//img[contains(@title, 'Logo')]")
	@CacheLookup
	public WebElement Logo;

	@FindBy(linkText="Home")
	@CacheLookup
	public WebElement HomeLink;


	@FindBy(xpath="(//input[@type='search'])[4]")
	@CacheLookup
	public WebElement SearchBar;


	@FindBy(xpath="(//input[contains(@aria-label, 'the search page')])[4]")
	@CacheLookup
	public WebElement SearchButton;


	@FindBy(xpath="//img[@width='1500']")
	@CacheLookup
	public WebElement HeroImage;


	@FindBy(id ="contactUS-primaryContactName")
	@CacheLookup
	public WebElement ContactName;


	@FindBy(id="contactUS-primaryCompany")
	@CacheLookup
	public WebElement Company;


	@FindBy(id="contactUS-primaryEmail")
	@CacheLookup
	public WebElement Email;


	@FindBy(id="contactUS-city")
	@CacheLookup
	public WebElement City;


	@FindBy(id="contactUS-usa-state")
	@CacheLookup
	public WebElement State;


	@FindBy(id="contactUS-country")
	@CacheLookup
	public WebElement Country;


	@FindBy(id="contactUS-reasonForSubmission")
	@CacheLookup
	public WebElement Questions;


	@FindBy(xpath="//*[@id=\"recaptcha-anchor\"]/div[1]")
	@CacheLookup
	public WebElement CaptchaCheckbox;


	@FindBy(id="btn-submit")
	@CacheLookup
	public WebElement SubmitButton;



	public TerumoCovid(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	//Method to open terumo covid page

	public void OpenPage() {

		driver.get("https://terumois.com/about-terumo-is/covid-19-response/back-to-patients.html/");
	}


	//Method to click logo

	public void ClickLogo() {

		Logo.click();

	}

	// Method to validate the landed URL

	public void ValidateURL() {

		String LandedURL=driver.getCurrentUrl();

		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(LandedURL, "https://terumois.com/", "Validation Failed!");
		driver.navigate().back();
		assertion.assertAll();

	}



	// Method to scroll to Hero compomnent

	public void ScrollToHero() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HeroImage);

	}

	// Method to check if hero image is present or not

	public void ValidateImage() {

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", HeroImage);
		if (!ImagePresent)
		{
			System.out.println("Hero Image not displayed.");
		}
		else
		{
			System.out.println("Hero Image displayed.");
		}
	}

	// Method to check search functionality

	public void ValidateSearch(String query) throws InterruptedException {

		SearchBar.sendKeys(query);
		SearchButton.click();


	}

	// Method to validate search results

	public void ValidateSearchResults() throws InterruptedException {


		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(driver.findElement(By.xpath("(//a[@class='title-link'])[1]")).getText().contains("TERUMO"), "Test failed!");
		assertion.assertAll();


	}


	//Method to extract and validate all links

	public void ValidateAllLinks() throws InterruptedException {

		String url = "";
		List <WebElement> allURLs = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the page: "+ allURLs.size());

		for (int i=0; i<allURLs.size(); i++) {

			WebElement link = allURLs.get(i);
			url = link.getAttribute("href");
			ValidateLink(url);
			
					
		}
	}

	// Method to Validate all Links

	public static void ValidateLink(String linkURL) {

		int count=0;
		
		try
		{
			URL url = new URL(linkURL);

			//Creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			
			
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println(linkURL+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
				Reporter.addStepLog(linkURL+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
				count++;
				
			}    

			//Fetching and Printing the response code obtained
			else{
				System.out.println(linkURL+" - "+httpURLConnect.getResponseMessage());
	
			}


		}catch (Exception e) {


		}
		
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(count==0, "Broken link found.");
		assertion.assertAll();
		
	
	}


	// Method to find all images on the page

	public void ValidateImages() {

		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of Images on the Page are " + images.size());

		for(int index=0;index<images.size();index++)
		{
			WebElement image= images.get(index);
			String imageURL= image.getAttribute("src");
			System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
			VerifyImageLinks(imageURL);

			//Validate image display using JavaScript executor
			try {
				boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
				if (imageDisplayed) {
					System.out.println("DISPLAY - OK");


				}else {
					System.out.println("DISPLAY - BROKEN");

				}
			} 
			catch (Exception e) {
				System.out.println("Error Occured");
			}
		}

	}

	// Method to validate image links

	public static void VerifyImageLinks(String linkUrl)
	{
		try
		{
			URL url = new URL(linkUrl);

			//Creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}    

			//Fetching and Printing the response code obtained
			else{
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
			}
		}catch (Exception e) {
		}
	}


	// Method to check form submission

	public void ValidateForm(String name, String company, String email, String city, String question) throws InterruptedException {

		ContactName.sendKeys(name);
		Company.sendKeys(company);
		Email.sendKeys(email);
		City.sendKeys(city);

		Select state = new Select(State);
		state.selectByValue("AL");

		Select country = new Select(Country);
		country.selectByValue("USA");

		Questions.sendKeys(question);
		CaptchaCheckbox.click();

		Thread.sleep(5000);



	}

}



