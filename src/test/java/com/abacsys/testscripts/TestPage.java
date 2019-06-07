package com.abacsys.testscripts;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.abacsys.BaseClass.BaseTest;
import com.abacsys.pom.LoginPage;
public class TestPage extends BaseTest
{
	@Test
	public void LoginTest() throws InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername("rashmi@dell.com");
		login.setPassword("123456");
		login.setLogin();
		Thread.sleep(3000);
		Reporter.log("Login Successful",true);
	}
}
