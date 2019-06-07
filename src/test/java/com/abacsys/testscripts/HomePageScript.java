package com.abacsys.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.abacsys.BaseClass.BaseTest;
import com.abacsys.pom.HomePage;
import com.abacsys.pom.LoginPage;

public class HomePageScript extends BaseTest
{
	@Test
	public void HomepageTest() throws InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername("rashmi@dell.com");
		login.setPassword("123456");
		login.setLogin();
		Thread.sleep(3000);
		HomePage home=new HomePage(driver);
		List<WebElement> HeaderLinks=home.getHeaderLinks();
		for(WebElement HeaderLink:HeaderLinks)
		{
			if(HeaderLink.isDisplayed())
			{
				String HeaderTitle=HeaderLink.getText();
				Reporter.log(HeaderTitle+" is Title is displayed in header",true);
				//HeaderLink.click();
			}
			else
			{
				String HeaderTitle=HeaderLink.getText();
				Reporter.log(HeaderTitle+" is Title is not displayed in header",true);
			}
		}
		List<WebElement>ModulenamesList=home.getModuleNames();
		for(WebElement ModuleName:ModulenamesList)
		{
			if(ModuleName.isDisplayed())
			{
				String ModuleTitle=ModuleName.getText();
				Reporter.log(ModuleTitle+" is Title is displayed",true);
				//ModuleName.click();
			}
			else
			{
				String ModuleTitle=ModuleName.getText();
				Reporter.log(ModuleTitle+" is Title is not displayed",true);
			}
		}
	}
}
