package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.TestBase.Base;
import com.qa.crm.TestUtils.Utility;

public class HomePage extends Base {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName(String uname)
	{
		Utility.switchToFrame("mainpanel");
		return driver.findElement(By.xpath("//*[contains(text(),'User: "+uname+"')]")).isDisplayed();
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsPage()
	{
		Utility.switchToFrame("mainpanel");
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsPage()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContacts()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		Utility.switchToFrame("mainpanel");
		try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		try {
		Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
