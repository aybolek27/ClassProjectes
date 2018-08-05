package july14Maruf;

/**	//WAIT UNTILL MESSAGE BECOMES VISIBLE
	
			//WebDriverWait --> class which enables explicit waiting
			//we pass the driver and the expected wait time as constructor
	
	//wait have 2 components
			//1 - duration
			//2 - what we are waiting for
			
			//condition --> what we are waiting for: element to be visible,
			//element to disappear, element to have certain text
			//element to be clickable...
			
			
			//wait.until() --> actually starts waiting
			//ExpectedConditions --> contains the wait conditions which can be passed to until() method
			//visibilityOf--> one of the conditions from the ExpectedConditions class. waits for the element
			//to be visible

 * 
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	@Test
	public void oneWhereImplicitDoesNotWork() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.id("btn")).click();

		// we can locate the message
		WebElement message = driver.findElement(By.cssSelector("#finish h4"));
		// assertion will fail sence the message is not loaded
		assertTrue(message.isDisplayed(), "Message should have been displayed");
		assertEquals(message.getText(), "Hello World!");
	}

	@Test
	public void explicitWaitForVisible() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();

		WebElement message = driver.findElement(By.cssSelector("#finish h4"));

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(message));

		assertTrue(message.isDisplayed(), "Message should have been displayed");
		assertEquals(message.getText(), "Hello World!");

	}

	@Test
	public void waitForDisappear() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		WebElement message = driver.findElement(By.cssSelector("#finish h4"));

		assertTrue(message.isDisplayed(), "Message should have been displayed");
		//assertEquals(message.getText(), "Hello World!");
	}

}
