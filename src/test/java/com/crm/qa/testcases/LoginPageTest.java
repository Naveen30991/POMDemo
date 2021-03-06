package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage landingpage;
	
	public LoginPageTest() {

		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitle()
	{
		String title=loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginpage.validateCrmImage();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		landingpage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
