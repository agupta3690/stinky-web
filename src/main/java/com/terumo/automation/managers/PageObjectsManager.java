package com.terumo.automation.managers;

import org.openqa.selenium.WebDriver;

import com.terumo.automation.objectRepository.TerumoCovid;

public class PageObjectsManager {


	private WebDriver driver;

	private TerumoCovid TerumoCovid;



	public PageObjectsManager(WebDriver driver) {

		this.driver = driver;

	}

	
	public TerumoCovid getTerumoCovid() {

		return (TerumoCovid == null) ? TerumoCovid = new TerumoCovid(driver) : TerumoCovid;

	}

}