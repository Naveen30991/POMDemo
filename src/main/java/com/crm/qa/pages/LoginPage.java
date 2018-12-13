package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page factory or Object Reporesitory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[2]/div/div[3]/form/div/div/input")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpLink;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.submit();
		
		return new HomePage();
	}
}
