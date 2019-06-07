package com.abacsys.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Lib 
{
	public static Workbook wb;
	public static String excelpath=System.getProperty("user.dir")+"/src/test/java/com/abacsys/excelreader";
	public static String getCellValue(String sheetname,int rowNum,int colNum)
	{
		String cellValue="";
		
			try 
			{
			    wb=WorkbookFactory.create(new FileInputStream(excelpath));
				cellValue=wb.getSheet(sheetname).getRow(rowNum).getCell(colNum).toString();
			} 
			catch (Exception e) 
			{
			
			}
		return cellValue;
	}
	public static String getPropertyValue(String propertyName)
	{
		String propertyValue="";
//		String configpath=System.getProperty("user.dir")+"./config.properties";
//		System.out.println(configpath);
		Properties prop=new Properties();
		try 
		{
			prop.load(new FileInputStream("./config.properties"));
			propertyValue =prop.getProperty(propertyName);
		} 
		catch (Exception e) 
		{
	
		}
		return propertyValue;
	}
	public static int getTotalRowCount(String sheetName)
	{
		int totalRowCount=0;
		try 
		{
			FileInputStream excelObj=new FileInputStream(excelpath);
			wb=WorkbookFactory.create(excelObj);
			totalRowCount=wb.getSheet(sheetName).getLastRowNum();
			
		}
		catch (Exception e) 
		{
		}
		return totalRowCount;
	}
	public static void captureScreenshot(WebDriver driver, String testMethodName) 
	{
		String SCREENSHOT_PATH="./Screenshots/";
		try {
			String currDateAndTime=new Date().toString().replaceAll(":","_");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(SCREENSHOT_PATH+testMethodName+" "+currDateAndTime+".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			
		}
	}
}

