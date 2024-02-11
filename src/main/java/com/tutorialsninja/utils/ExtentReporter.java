package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReports= new ExtentReports();
		String reportPath = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\MyReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorialsninja test results");
		sparkReporter.config().setDocumentTitle("TN Report");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		Properties prop= new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorialsninja\\config\\Config.properties");
		try {
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		}
		catch(Throwable e){
			e.printStackTrace();
			
		}
		
		extentReports.setSystemInfo("Application URL ", prop.getProperty("Url"));
		extentReports.setSystemInfo("Browser Name ", prop.getProperty("BrowserName"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
		
		System.out.println("extent Reports");
		
		return extentReports;
	}

}
