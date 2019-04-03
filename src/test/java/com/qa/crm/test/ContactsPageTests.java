package com.qa.crm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.TestBase.Base;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class ContactsPageTests extends Base {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;


	ContactsPageTests()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new LoginPage();
		hp = lp.login();
		
		try {
		Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		cp = hp.clickOnContactsPage();
		try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void createNewContactsTest()
	{
		hp.clickOnNewContacts();
		cp.createNewContact("Mr.", "Sid", "Gupta", "Accy");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
