package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.TestBase.Base;

public class ContactsPage extends Base{

	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id="surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	@CacheLookup
	WebElement saveBttn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String title, String fname, String lname, String companyName)
	{
		Select titleDropdown = new Select(driver.findElement(By.name("title")));
		titleDropdown.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(companyName);
		
		saveBttn.click();
		
	}
	
	
	
}
