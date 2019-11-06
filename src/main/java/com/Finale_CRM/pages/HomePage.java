package com.Finale_CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Finale_CRM.Base.BaseTest;

public class HomePage extends BaseTest
{
//Object Repository
	
	@FindBy(xpath = "//td[contains(.,' Smija Nair')]")
	WebElement userlabel;
	
	@FindBy(xpath = "//a[contains(.,'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath ="//a[contains(.,'New Contact')]")
	WebElement newContactslink;
	
	
	//Initialization
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateUserlabel()
	{
		return userlabel.isDisplayed();
	}
	
	public ContactsPage clickOnContacts()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	public void clickonNewContactsLink()
	{
		Actions act = new Actions(driver);
		act.moveToElement(newContactslink).build().perform();
		newContactslink.click();
		
	}
}
