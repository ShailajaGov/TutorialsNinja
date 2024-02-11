package com.tutorialsninja.listeners;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.utils.ExtentReporter;
import com.tutorialsninja.utils.Utilities;

public class MyListener implements ITestListener{

	ExtentReports extentReport ;
	ExtentTest extentTest;
		
	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("onTestStart");
		
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " started execution");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("onTestSuccess");
		
		extentTest.log(Status.PASS, result.getName() +" got succesfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("onTestFailure");
		WebDriver driver = null;
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		Utilities.captureScreenshot(driver, result.getName());
		  
		//extentTest.addScreenCaptureFromPath(destinationFilePath);  
		extentTest.addScreenCaptureFromPath(result.getName()+".png"); 
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+" got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//System.out.println("onTestSkipped");
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got Skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		//System.out.println("onStart");
		
		extentReport = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("onFinish");
		
		extentTest.log(Status.INFO, "Test  execution completed");
		extentReport.flush();
		
		 String extentReportPath = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\MyReport.html";
		 File file = new File(extentReportPath);
		 
		  try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
