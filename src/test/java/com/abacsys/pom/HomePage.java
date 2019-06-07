package com.abacsys.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//declaration of elements
	@FindBy(how=How.XPATH,using="//*[@id=\"basic\"]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/a")
	List<WebElement> HeaderLinks;
	@FindBy(how=How.XPATH,using="//*[@id=\"tabcontent\"]/table/tbody/tr/td/a")
	List<WebElement> ModuleNames;
	//initialialise the elements
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilise the elements
	public List<WebElement> getHeaderLinks()
	{
		return HeaderLinks;
	}
	public List<WebElement> getModuleNames()
	{
		return ModuleNames;
	}
}
