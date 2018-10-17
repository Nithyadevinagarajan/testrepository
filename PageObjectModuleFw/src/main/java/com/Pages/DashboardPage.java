package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logOutLink;
	
	
	public DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void logoutAsAdmin()
	{
	logOutLink.click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}


}
