package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	ContactsPage contactsPage;
	DealsPage dealspage;
	TasksPage taskspage;

	@FindBy(xpath = "//td[contains(text(),'User: Naveen Gundagurti')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;

	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContacts() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasks() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyUser()
	{
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContact()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
			
			
	}
}
