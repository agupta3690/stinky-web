package com.bhf.automation.managers;

import com.bhf.automation.objectRepository.*;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.WebDriver;

public class PageObjectsManager {


	private WebDriver driver;

	private BHFMetlifeLoginPage MetlifeLoginPage;

	private BHFProHomePage ProHomePage;

	private BHFUserDashboard UserDashboard;

	private BHFHeaderNavigation HeaderNavigation;

	private QATestPage qaTestPage;



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

	public QATestPage getQaTestPage() throws FilloException {
		return (qaTestPage == null) ? qaTestPage = new QATestPage(driver) : qaTestPage;
	}


}