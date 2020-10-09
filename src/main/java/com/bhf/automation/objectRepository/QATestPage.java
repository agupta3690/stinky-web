package com.bhf.automation.objectRepository;

import com.bhf.automation.dataProvider.ConfigFileReader;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QATestPage {
    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();
    String StateCode = configFileReader.getvaluefromexcel().get("State");
    //Dividing the Xpath in order to pass the StatCode value dynamically
    String part1 = "//*[@value='" +StateCode;
    String part2 = "']";
    String Finalxpath = part1+part2;

    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement FirstName;

    @FindBy(id = "lastName")
    @CacheLookup
    private WebElement LastName;

    @FindBy(id = "address1")
    @CacheLookup
    private WebElement Address;

    @FindBy(id = "city")
    @CacheLookup
    private WebElement City;

    @FindBy(xpath = "//*[@type='search']")
    @CacheLookup
    private WebElement State;

    @FindBy(id = "zip")
    @CacheLookup
    private WebElement Zip;

    @FindBy(id = "mobileNo")
    @CacheLookup
    private WebElement Phone;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement Email;

    // Intializing PageFactory

    public QATestPage(WebDriver driver) throws FilloException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//Methods for above WebElements

public void OpenQATestPage() {


    driver.get(configFileReader.getApplicationUrl());

}

    public void getFirstName() throws FilloException {
        String FName = configFileReader.getvaluefromexcel().get("First Name");
        FirstName.sendKeys(FName);
    }

    public void getLastName() throws FilloException {
        String LName = configFileReader.getvaluefromexcel().get("Last Name");
        LastName.sendKeys(LName);
    }

    public void getAddress() throws FilloException {
        String address = configFileReader.getvaluefromexcel().get("Address");
        Address.sendKeys(address);
    }

    public void getCity() throws FilloException {
        String city = configFileReader.getvaluefromexcel().get("City");
        City.sendKeys(city);
    }

    public void getState() throws FilloException {
        State.click();
        driver.findElement(By.xpath(Finalxpath)).click();
        State.sendKeys(Keys.ESCAPE);
    }

    public void getZip() throws FilloException {
        String zip = configFileReader.getvaluefromexcel().get("Zip Code");
        Zip.sendKeys(zip);
    }

    public void getPhone() throws FilloException {
        String phonenumber = configFileReader.getvaluefromexcel().get("Phone Number");
        Phone.sendKeys(phonenumber);
        Phone.sendKeys(Keys.TAB);
    }

    public void getEmail() throws FilloException {
        String email_address = configFileReader.getvaluefromexcel().get("Email Address");
        Email.sendKeys(email_address);
        Email.sendKeys(Keys.TAB);
    }
}
