package com.abacsys.BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.abacsys.library.Lib;


public class BaseTest 
{
	public static WebDriver driver;
	static 
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
	}
	@BeforeMethod
	public void openApplication()
	{
		//launch the browser
		driver=new ChromeDriver();
		//enter the browser
		driver.get(Lib.getPropertyValue("URL"));
		//setting timeout
		
		String timeout=Lib.getPropertyValue("IMPLICIT_TIMEOUT");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout),TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res)
	{
		//capture screenshot for only the failed test script
		if(ITestResult.FAILURE==res.getStatus())
		{
			Lib.captureScreenshot(driver,res.getName());
		}
		//close the browser
		driver.close();
	}
}

