package com.tutorialsninja.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=15;
	public static final int PAGELOAD_WAIT_TIME=20;
	
	public static String getTimeStamp()
	{
		
		
		Date date = new Date();
		return date.toString().replace(" ","_").replace(":", "_");
		
	}
	
	public static String captureScreenshot(WebDriver driver,String testName)
	{
		
       File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
//		String base64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
//		extentTest.addScreenCaptureFromBase64String(base64);
		
		
		// String destinationFilePath =System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+".png";
		  String destinationFilePath = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\"+testName+".png";
		  try {
			  FileHandler.copy(srcScreenshot, new File(destinationFilePath)); }
		  catch(IOException e) { // TODO Auto-generated catch block 
			  e.printStackTrace();
			  }
		return destinationFilePath;
	}

}
