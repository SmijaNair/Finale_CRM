package com.Finale_CRM.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Finale_CRM.Base.BaseTest;
import com.Finale_CRM.pages.ContactsPage;
import com.Finale_CRM.pages.HomePage;
import com.Finale_CRM.pages.LoginPage;
import com.Finale_CRM.util.TestUtil;

public class ContactsPageTest  extends BaseTest {

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest()
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
	
	/*@Test(priority=1)
	public ContactsPage clickonNewContactsLinkTest()
	{
		TestUtil.switchToFrame();
		homePage.clickOnContacts();
		homePage.clickonNewContactsLink();
		return new ContactsPage();
	}
	*/
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =2, dataProvider = "getCRMTestData")
	public void enterContactsDetailsTest(String fname, String lname)
	{
		TestUtil.switchToFrame();
		contactsPage = homePage.clickOnContacts();
		homePage.clickonNewContactsLink();
		contactsPage.enterContactsDetails(fname, lname);

	}
}
