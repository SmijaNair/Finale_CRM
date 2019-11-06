package com.Finale_CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Finale_CRM.Base.BaseTest;

public class LoginPage  extends BaseTest
{
//Object Repository
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement CRMLogo;
	
	
//Initialization
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	//to validate the title
	public String valildateTitle()
	{
		return driver.getTitle();
	}
	
	//To validate logo
	public Boolean validateCRMLogo()
	{
		return CRMLogo.isDisplayed();
	}
	
	//To enter credentials
	public HomePage Login(String un, String pwd) throws InterruptedException
	{
		userName.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		LoginBtn.click();
		
		return new HomePage();
	}
}
