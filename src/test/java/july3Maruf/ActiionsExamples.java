package july3Maruf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiionsExamples {
	WebDriver driver;
	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up webDriver in Beforeclass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@Test
	public void doubleClickTest() throws InterruptedException {
		driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
		WebElement slides=driver.findElement(By.id("slide_header"));
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.doubleClick(slides).perform();
	}
	
	@Test
	public void hoverTest1() throws InterruptedException {
	
		driver.get("http://amazon.com");
		WebElement hello=driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(hello).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Your Garage")).click();
	}
	
	
	@Test
	public void hoverTest2() throws InterruptedException {
	
		driver.get("http://amazon.com");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[.='Back to top']"))).perform();
		
//		action.moveByOffset(5, 5);  //second way how to go to  specific web element
//		action.moveToElement(null, 5, 5); //third way of how to go to specific web element
//	
	}
	
	@Test
	public void scrollTest() throws InterruptedException {
		
		driver.get("http://amazon.com");
		Actions action=new Actions(driver);
		
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
//		action.sendKeys(Keys.ARROW_DOWN).perform();
//		action.sendKeys(Keys.ARROW_DOWN).perform();

//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	@Test
	public void dragDropTest1() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions action=new Actions(driver);
		//drag drop operation involves 2 elements. source and target
		//source --> elements which we will move
		//target --> element where we drop the source
		
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droptarget"));
		action.dragAndDrop(source, target).perform();
		
//		action.dragAndDropBy(source, 0, -200).perform();
		
	}
	
	
	@Test
	public void dragDropTest2() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions action=new Actions(driver);		
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droptarget"));
//		0. move the mouse on top the source
//		1. click and hold mouse on source
//		2. move to target element
//		3. release the mouse
		//this example does the whole steps of drag and drop action
		//this example chains multiple operations. when we chain multiple operations we also use
		//build() to add all those operations
//		action.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
		action.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
		
//		action.dragAndDropBy(source, 0, -200).pause(1000).dragAndDropBy(source,200 ,0).pause(1000).
//		dragAndDropBy(source, 0, -200).build().perform();
	}
	
	

}
