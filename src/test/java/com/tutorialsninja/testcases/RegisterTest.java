package com.tutorialsninja.testcases;

import java.time.Duration;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;
import com.tutorialsninja.utils.Utilities;

public class RegisterTest extends Base  {
	
	//WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
		
		intializeBrowserAndOpenApplicationURL(prop.getProperty("BrowserName"));

		
		driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisterationWithMandatoryFields()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("input-firstname")).sendKeys("Ashrith");
		driver.findElement(By.id("input-lastname")).sendKeys("Ashrith");
		driver.findElement(By.id("input-email")).sendKeys("Ashrith"+Utilities.getTimeStamp()+"@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessText= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	
		Assert.assertEquals(actualSuccessText,"Your Account Has Been Created! abc");
		
		
	}
	
	@Test(priority = 2,dependsOnMethods={"verifyRegisterationWithMandatoryFields"})
	public void verifyRegisterWithExistingEmail()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("input-firstname")).sendKeys("Ashrith");
		driver.findElement(By.id("input-lastname")).sendKeys("Kodumuri");
		driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarningText= driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	
		Assert.assertTrue(actualWarningText.contains("Warning: E-Mail Address is already registered!"));
		
	}
	
	@Test(priority = 3)
	public void verifyRegisterWithoutFillingAnyDetails()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualfnameWarning= driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actualfnameWarning,"First Name must be between 1 and 32 characters!");
	
		String actualLnameWarning= driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actualLnameWarning,"Last Name must be between 1 and 32 characters!");
	
		String actualTelephoneWarning= driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actualTelephoneWarning,"Telephone must be between 3 and 32 characters!");
		
		
	}

}
