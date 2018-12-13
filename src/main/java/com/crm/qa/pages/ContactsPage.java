package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;

	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath=" //input[@value='Save' & @type='submit']")
	WebElement save;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/form/table/tbody/tr[3]/td[1]/input")
    WebElement contactId;
    
    public boolean verifyContactsLabel()
    {
    	return contactLabel.isDisplayed();
    }
    
    public void selectContacts()
    {
    	contactId.click();
    }
    
    public void createNewContact(String title,String fn,String ln,String comp)
    {
    	Select s=new Select(driver.findElement(By.name("title")));
    	s.selectByVisibleText(title);
    	firstName.sendKeys(fn);
    	lastName.sendKeys(ln);
    	company.sendKeys(comp);
    	save.click();
    	
    	
    }
}

