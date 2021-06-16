package com.terumo.automation.cucumber;

import com.terumo.automation.managers.PageObjectsManager;
import com.terumo.automation.managers.WebDriverManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	private PageObjectsManager pageObjectsManager;
	
	public TestContext() {
		
		webDriverManager = new WebDriverManager();
		pageObjectsManager = new PageObjectsManager(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager() {
		
		return webDriverManager;
	}
	
public PageObjectsManager getPageObjectsManager() {
		
		return pageObjectsManager;
	}
	
}
