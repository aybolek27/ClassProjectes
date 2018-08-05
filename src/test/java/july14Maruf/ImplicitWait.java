package july14Maruf;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// will wait for specified duration while executing the findElement method
		// will only wait if the findElement method does not find anything
		// findElement method will keep attempting to find the element during this time

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();

		WebElement message = driver.findElement(By.xpath("//h4[.='Hello World!']"));

		// new Actions(driver).pause(50000);
		assertTrue(message.isDisplayed(), "message not displayed");

	}

	@Test
	public void notAgoodTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		//this setting will control how long driver should wait then the page is loading
//		//if web site loads slowly we can use this command
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		
//		//will wait for background ajax processes to finish
//		driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS );

		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.id("btn")).click();
		
		WebElement message = driver.findElement(By.id("message"));
		assertTrue(message.isDisplayed(), "message should be displayed");
		assertEquals(message, "It's gone!");
		
		driver.findElement(By.id("btn")).click();
		
		message = driver.findElement(By.id("message"));
		assertTrue(message.isDisplayed(), "message should be displayed");
		assertEquals(message, "It's back!");

	}

}
