package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;

public class SearchTest extends Base {

	@BeforeMethod
	public void setup()
	{
		intializeBrowserAndOpenApplicationURL(prop.getProperty("BrowserName"));
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void searchWithValidProduct()
	{
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();////input[@name='search']/following::button
	
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test
	public void searchWithInvalidProduct()
	{
		driver.findElement(By.name("search")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();////input[@name='search']/following::button
	
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText(),"There is no product that matches the search criteria.");
	}
}
