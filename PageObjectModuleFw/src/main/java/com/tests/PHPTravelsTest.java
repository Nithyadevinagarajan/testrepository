package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.utility.DriverUtility;

public class PHPTravelsTest {
	
	WebDriver driver;
	LoginPage lp;
	DashboardPage dp;
	
	@BeforeTest
	public void openTheApplication()
	{
		driver = DriverUtility.initializeDriver("Chrome");
		
		
		lp = PageFactory.initElements(driver, LoginPage.class);
		dp = PageFactory.initElements(driver, DashboardPage.class);
	}
	
	@AfterTest
	public void closeTheApplication()
	{
		driver.close();
		lp=null;
		dp=null;
	}
	
	@Test(priority=0)
	public void validAdminTest() throws InterruptedException
	{
		lp.get();
		lp.loginAsAdmin("admin@phptravels.com", "demoadmin");
		Thread.sleep(10000);
		Assert.assertEquals(dp.getPageTitle(), "Dashboard");
		dp.logoutAsAdmin();
		Thread.sleep(10000);
		Assert.assertEquals(lp.getPageTitle(), "Administator Login");
	}
	
	@Test(priority=1)
	public void invalidAdminTest() throws InterruptedException
	{
		lp.loginAsAdmin("user@phptravels.com", "demo");
		Thread.sleep(10000);
		Assert.assertEquals(lp.getMessage(), "invalid credentials");
	}
	

}
