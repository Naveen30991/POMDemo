package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	
	LoginPage loginpage;
	HomePage landingpage;
    TestUtil testUtil;
    ContactsPage contactpage;
	public ContactsPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		loginpage = new LoginPage();
		landingpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactpage = landingpage.clickOnContacts();
		
	}
	
//	@Test(priority=1)
//	public void verifyContactsLabel()
//	{
//		//testUtil.switchToFrame();
//		boolean label=contactpage.verifyContactsLabel();
//		System.out.println(label);
//		Assert.assertTrue(label, "Label didn't match");
//	}
//	
//	@Test(priority=2)
//	public void clickOnContactsCheckBox()
//	{
//		//testUtil.switchToFrame();
//		contactpage.selectContacts();
//	}
	
	@Test(priority=1)
	public void createNewContact()
	{
		landingpage.clickOnNewContact();
		contactpage.createNewContact("Mr.", "Tom", "Peter", "Azstrel");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
