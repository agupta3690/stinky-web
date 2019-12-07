package com.bhf.automation.managers;

import org.openqa.selenium.WebDriver;

import com.bhf.automation.objectRepository.BHFHeaderNavigation;
import com.bhf.automation.objectRepository.BHFMetlifeLoginPage;
import com.bhf.automation.objectRepository.BHFProHomePage;
import com.bhf.automation.objectRepository.BHFUserDashboard;

public class PageObjectsManager {


	private WebDriver driver;

	private BHFMetlifeLoginPage MetlifeLoginPage;

	private BHFProHomePage ProHomePage;

	private BHFUserDashboard UserDashboard;

	private BHFHeaderNavigation HeaderNavigation;



	public PageObjectsManager(WebDriver driver) {

		this.driver = driver;

	}


	public BHFMetlifeLoginPage getMetlifeLoginPage(){

		return (MetlifeLoginPage == null) ? MetlifeLoginPage = new BHFMetlifeLoginPage(driver) : MetlifeLoginPage;

	}


	public BHFProHomePage getBHFProHomePage() {

		return (ProHomePage == null) ? ProHomePage = new BHFProHomePage(driver) : ProHomePage;

	}



	public BHFUserDashboard getBHFUserDashboard() {

		return (UserDashboard == null) ? UserDashboard = new BHFUserDashboard(driver) : UserDashboard;

	}

	public BHFHeaderNavigation getBHFHeaderNavigation() {

		return (HeaderNavigation == null) ? HeaderNavigation = new BHFHeaderNavigation(driver) : HeaderNavigation;

	}


}