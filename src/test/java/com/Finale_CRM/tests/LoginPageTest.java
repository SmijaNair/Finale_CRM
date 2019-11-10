package com.Finale_CRM.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Finale_CRM.Base.BaseTest;
import com.Finale_CRM.pages.HomePage;
import com.Finale_CRM.pages.LoginPage;
import com.Finale_CRM.util.TestUtil;

public class LoginPageTest  extends BaseTest
{
	LoginPage loginPage;
	HomePage homePage;

	/*public LoginPageTest()
	{
		super();
	}*/
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Softwares/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
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
