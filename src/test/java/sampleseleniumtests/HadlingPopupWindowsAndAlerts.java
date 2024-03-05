package sampleseleniumtests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class HadlingPopupWindowsAndAlerts {
	
@Test
public void handleAlertBox()
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://omayo.blogspot.com/");
	driver.findElement(By.xpath("//input[@value='ClickToGetAlert']")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	driver.quit();
	
}

@Test
public void handlePromptDialogue() throws InterruptedException
{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://omayo.blogspot.com/");
	driver.findElement(By.xpath("//input[@value='GetPrompt']")).click();
	//Thread.sleep(2000);
	
	Alert prompt = driver.switchTo().alert();
	
	
	prompt.sendKeys("xyz");
	
	
	String txt = prompt.getText();
	prompt.accept();
	
	System.out.print(txt);
	driver.quit();
	
	
}

@Test
public void handlePopupWindow()
{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://omayo.blogspot.com/");
	
	driver.findElement(By.linkText("Open a popup window")).click();
	
	Set<String> windHandles = driver.getWindowHandles();
	Iterator<String> winHandleIterator = windHandles.iterator();
	String parent = winHandleIterator.next();
	String childWindow = winHandleIterator.next();
	driver.switchTo().window(childWindow);
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='New Window']")));
	
	
	Assert.assertEquals(driver.getTitle(),"New Window");
	Assert.assertTrue(element.isDisplayed());
	
	driver.quit();
}

@Test
public void handleAuthenticationPopup()
{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	String username = "admin";
	String password ="admin";
	driver.get("https://"+ username + ":"+ password + "@the-internet.herokuapp.com/basic_auth");
	driver.quit();
	
}



@Test
public void handleEntryAd() {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com");
	driver.findElement(By.xpath("//a[text() = 'Entry Ad']")).click();
	
	driver.findElement(By.xpath("//div[@class='modal-footer']//p")).click();
	
//	ExpectedCondition<Alert> ExpCond = ExpectedConditions.alertIsPresent();
//	
//	Alert alert =ExpCond.apply(driver);
	//driver.quit();
	
}





}
