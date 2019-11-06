package com.Finale_CRM.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Finale_CRM.util.TestUtil;

public class BaseTest
{
	public static WebDriver driver;
	public static Properties prop;

	public BaseTest()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\20073007\\Documents\\Selenium\\Individual_Projects\\Finale_CRM\\src\\main\\java\\com\\Finale_CRM\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not present in the path");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome"))
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
	}
	

}
