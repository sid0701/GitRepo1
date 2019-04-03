package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.TestBase.Base;

public class LoginPage extends Base {

	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement loginBttn;
	
	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCRMLogo()
	{
		return driver.getTitle();
	}
	
	public boolean crmLogoIsDisplayed()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login()
	{
		username.clear();
		username.sendKeys(prop.getProperty("username"));
		password.clear();
		password.sendKeys(prop.getProperty("password"));
		try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		loginBttn.click();
		try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		return new HomePage();
		
	}
}
