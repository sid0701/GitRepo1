package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.TestBase.Base;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class HomePageTests extends Base{

	LoginPage lp;
	HomePage hp;
	
	public HomePageTests()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new LoginPage();
		hp = lp.login();
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		Assert.assertEquals( hp.getHomePageTitle(),"CRMPRO","Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabel()
	{
		Assert.assertTrue(hp.verifyCorrectUserName("Siddharth Gupta"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
