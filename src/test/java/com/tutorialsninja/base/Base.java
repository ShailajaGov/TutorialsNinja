package com.tutorialsninja.base;

import java.io.File;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.utils.Utilities;

public class Base {

	public WebDriver driver;
	
	public Properties prop;
	
	public  Base() 
	{
		prop= new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorialsninja\\config\\Config.properties");
		try {
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		}
		catch(Throwable e){
			e.printStackTrace();
			
		}
	}
	
	public WebDriver intializeBrowserAndOpenApplicationURL(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGELOAD_WAIT_TIME));
		driver.manage().window().maximize();
		//System.out.println(prop.getProperty("Url"));
		driver.get(prop.getProperty("Url"));
		return driver;
	}
}
