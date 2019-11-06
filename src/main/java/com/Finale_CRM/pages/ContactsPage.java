package com.Finale_CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Finale_CRM.Base.BaseTest;

public class ContactsPage extends BaseTest 
{
	
	
	//Object Repository
		@FindBy(xpath = "//input[@id='first_name']")
		WebElement FirstName;
		
		@FindBy(xpath = "//input[@name='surname']")
		WebElement LastName;
		
		@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button']")
		WebElement Savebtn;

		//Initialization
			public ContactsPage()
			{
				PageFactory.initElements(driver, this);
			}

	//Methods
			
			public void enterContactsDetails(String f_name, String l_name)
			{	
				
				FirstName.sendKeys(f_name);
				LastName.sendKeys(l_name);
				Savebtn.click();
			}
	
			
}
