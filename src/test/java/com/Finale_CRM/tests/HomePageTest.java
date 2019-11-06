package com.Finale_CRM.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Finale_CRM.Base.BaseTest;
import com.Finale_CRM.pages.ContactsPage;
import com.Finale_CRM.pages.HomePage;
import com.Finale_CRM.pages.LoginPage;
import com.Finale_CRM.util.TestUtil;

public class HomePageTest  extends BaseTest 
{
LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
TestUtil testUtil;

public HomePageTest()
{
	super();
}

@BeforeMethod
public void setUp() throws InterruptedException
{
	initialization();
	loginPage = new LoginPage();
	homePage = new HomePage();
	testUtil = new TestUtil();
	homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	contactsPage = new ContactsPage();
}

@Test(priority =1)
public void validateHomePageTitleTest()
{
	String title = homePage.validateHomePageTitle();
	Assert.assertEquals(title, "CRMPRO");
}

@Test(priority = 2)
public void validateUserlabelTest()
{
	TestUtil.switchToFrame();
	boolean result = homePage.validateUserlabel();
	Assert.assertTrue(result);
}

@Test(priority = 3)
public void clickOnContactsTest()
{
	TestUtil.switchToFrame();
	homePage.clickOnContacts();
}
}
