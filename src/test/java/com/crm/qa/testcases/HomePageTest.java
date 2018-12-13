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

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage landingpage;
	DealsPage dealspage;
	TasksPage taskpage;
	ContactsPage contactpage;
    TestUtil testUtil;
	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		dealspage = new DealsPage();
		taskpage =new TasksPage();
		contactpage = new ContactsPage();
		loginpage = new LoginPage();
		landingpage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void titleVerification()
	{
		String title = landingpage.verifyHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
	}
	
	@Test (priority=2)
	public void getUserName()
	{
		
		testUtil.switchToFrame();
		boolean flag=landingpage.verifyUser();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test (priority=3)
	public void clickOnContacts()
	{
		testUtil.switchToFrame();
		contactpage=landingpage.clickOnContacts();
	}
	
	@Test (priority=4)
	public void clickOnDeals()
	{
		testUtil.switchToFrame();
		dealspage=landingpage.clickOnDeals();
	}
	
	@Test (priority=5)
	public void clickOnTasks()
	{
		testUtil.switchToFrame();
		taskpage=landingpage.clickOnTasks();
	}
	
		
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
