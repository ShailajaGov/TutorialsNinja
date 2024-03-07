package sampleseleniumtests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DateAndTimePickerHandling {

@Test
public void selectDateAndTime() throws InterruptedException
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/date-picker");
	
	WebElement datePicker = driver.findElement(By.id("dateAndTimePickerInput"));
	try {
	datePicker.click();
	}
	catch(ElementClickInterceptedException ex )
	{
		//Scroll to view
		
		//driver.switchTo().frame("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", datePicker);
		jse.executeScript("arguments[0].click();", datePicker);
            
	}
	
	 driver.findElement(By.cssSelector("span.react-datepicker__month-read-view--down-arrow")).click();
	
	 driver.findElement(By.xpath("//div[text() = 'May']")).click();
     //Thread.sleep(Duration.ofSeconds(2000));
     //
     driver.findElement(By.xpath("//*[@aria-label = 'Choose Thursday, May 16th, 2024']")).click();
     driver.findElement(By.xpath("//li[text() = '09:00']")).click();
}


//div.sliderContainer>input
@Test
public void horizontalSlider() throws AWTException
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/horizontal_slider");
	driver.findElement(By.cssSelector("div.sliderContainer>input"));//.click();
	
	Actions actions= new Actions(driver);
	actions.moveToElement(driver.findElement(By.cssSelector("div.sliderContainer>input")),0,0)
	.clickAndHold().build().perform();
	
	Robot robot= new Robot();
	robot.keyPress(KeyEvent.VK_RIGHT);
	robot.keyRelease(KeyEvent.VK_RIGHT);
	robot.keyPress(KeyEvent.VK_RIGHT);
	robot.keyRelease(KeyEvent.VK_RIGHT);
	

	
}

@Test
public void CloseAd() throws InterruptedException
{
	
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/date-picker");
	
	driver.switchTo().frame("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0");
	
	//label[@data-vars-label = 'user_feedback_menu_interaction']/*[local-name()='svg' ]/*[local-name()='path']
	//WebElement m= driver.findElement(By.xpath("//div[@id='cbb']/*[local-name()='svg' ]/*[local-name()='path']|//label[@data-vars-label = 'user_feedback_menu_interaction']/*[local-name()='svg' ]/*[local-name()='path']"));
   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
   WebElement element =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='cbb']/*[local-name()='svg' ]/*[local-name()='path']|//label[@data-vars-label = 'user_feedback_menu_interaction']/*[local-name()='svg' ]/*[local-name()='path']"))));
	
   Thread.sleep(5000);
	// Action class to move and click element
    Actions act = new Actions(driver);
    act.moveToElement(element).
    click().build().perform();
    
   System.out.println("xyz");
   
   driver.quit();
	

}


	
}
