package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.TestBase.Base;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTests extends Base {
	
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTests()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 lp = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		Assert.assertEquals(lp.verifyCRMLogo(), "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void verifyLogoDisplayed()
	{
		Assert.assertTrue(lp.crmLogoIsDisplayed());
	}
	
	@Test(priority=3)
	public void login()
	{
		hp = lp.login();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
