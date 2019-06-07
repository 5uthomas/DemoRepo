package com.abacsys.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//declaration of elements
	
	@FindBy(id="userName")
	WebElement unTB;
	
	@FindBy(id="passWord")
	WebElement pwdTB;
	
	@FindBy(xpath="//input[@title='Sign In']")
	WebElement SigninBtn;
	
	@FindBy(xpath="//input[@name='j_remember']")
	WebElement RememberCheckBox;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//img[@title='New User Registration']")
	WebElement newUserRegistrationLink;
	
	//initialialise the elements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilise the elements
	public void setUsername(String username)
	{
		unTB.sendKeys(username);
	}
	public void setPassword(String password)
	{
		pwdTB.sendKeys(password);
	}
	public void setRemember()
	{
		RememberCheckBox.click();
	}
	public void forgotPassword()
	{
		forgotPasswordLink.click();
	}
	public void setNewRegistration()
	{
		newUserRegistrationLink.click();
	}
	public void setLogin()
	{
		SigninBtn.click();
	}
}
