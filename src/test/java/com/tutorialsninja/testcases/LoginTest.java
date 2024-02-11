package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;
import com.tutorialsninja.utils.Utilities;


public class LoginTest extends Base{
	
	//WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{
		String browserName =prop.getProperty("BrowserName");
				
		intializeBrowserAndOpenApplicationURL(browserName);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccountDropMenu();
			
		loginPage =homePage.clickLoginOption();
		
		
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void verifyLoginWithValidCredentials() {
		
		
		loginPage.enterEmailAddress("abc@gmail.com");
		loginPage.enterPassword("12345");
		loginPage.clickLoginButton();

		
		Assert.assertTrue(loginPage.editAccountInfoLinkIsDisplayed());
		
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
				
		loginPage.enterEmailAddress("qwe"+Utilities.getTimeStamp()+"@gmail.com");
		loginPage.enterPassword("123456");
		loginPage.clickLoginButton();
	
		Assert.assertTrue(loginPage.retrieveInvalidCredentialsWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	
	}
	
	@Test
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{
		
		loginPage.enterEmailAddress("abc@gmail.com");
		loginPage.enterPassword("12345678");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.retrieveInvalidCredentialsWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@Test
	public void verifyLoginWithoutGivingCredentials()
	{
		
		loginPage.enterEmailAddress("");
		loginPage.enterPassword("");
		loginPage.clickLoginButton();
		

		Assert.assertTrue(loginPage.retrieveInvalidCredentialsWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	
	
}
