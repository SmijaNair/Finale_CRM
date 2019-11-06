package com.Finale_CRM.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Finale_CRM.Base.BaseTest;
import com.Finale_CRM.pages.HomePage;
import com.Finale_CRM.pages.LoginPage;

public class LoginPageTest  extends BaseTest
{
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void valildateTitleTest()
	{
		String title = loginPage.valildateTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");	
		
		
	}
	
	@Test(priority = 2)
	public void validateCRMLogoTest()
	{
		boolean result = loginPage.validateCRMLogo();
		Assert.assertTrue(result);
		//Assert.assertTrue(loginPage.validateCRMLogo());
	}
	
	@Test(priority = 3)
	public void LoginTest() throws InterruptedException
	{
		
	homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
}
