package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailTextBox;
	
	@FindBy(id="input-password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement loginButton;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInfo;
	
	@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
	private WebElement invalidCredentialsWarningMsg;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterEmailAddress(String email)
	{
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	
	}
	
	public boolean editAccountInfoLinkIsDisplayed()
	{
		return editAccountInfo.isDisplayed();
	}
	
	
	public String retrieveInvalidCredentialsWarningMsg()
	{
		return invalidCredentialsWarningMsg.getText();
	}
	
}
