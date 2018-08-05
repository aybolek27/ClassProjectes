package june30WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingWholePricesOfItem {
	
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
	public void getAllProducts() {
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=wooden+spoon&rh=i%3Aaps%2Ck%3Awooden+spoon");
		
//		List<WebElement> descriptions=driver.findElements(By.xpath("//h2"));
//		for (WebElement each : descriptions) {
//			System.out.println(each.getText());	
//		}
//		System.out.println(descriptions.size());
//		
//		List<WebElement>  prices=driver.findElements(By.xpath("//span[@class='sx-price sx-price-large']"));
//		for (WebElement each : prices) {
//			
//			System.out.println(each.getText());
//			
//		}
//		System.out.println(prices.size());
//		
//		
//		
//		for (int i = 0; i <descriptions.size(); i++) {
//			
//			System.out.println(descriptions.get(i).getText());
//			System.out.println(prices.get(i).getText());
//			System.out.println("===================================");
//			
//		}
//		
//		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Murodils version
//		List<WebElement>  containers=driver.findElements(By.xpath("//div[@class='s-item-container']"));
//		System.out.println("Whole items size" + containers.size());
//		
//		for (int i = 0; i < containers.size(); i++) {
//			//checks is there is no text
//			if(containers.get(i).getText().isEmpty())continue;
//			
//		String desXpath="(//div[@class='s-item-container'])["+(i+1)+"]//h2";
//		String priceXpath="(//div[@class='s-item-container'])["+(i+1)+"]//span[@class='sx-price sx-price-large']";			
//		
//		System.out.println(driver.findElement(By.xpath(desXpath)).getText());
//		System.out.println(driver.findElement(By.xpath(priceXpath)).getText());
//		System.out.println("---------------------------------");
//		
//		}		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//		List<WebElement>  containers=driver.findElements(By.xpath("//div[@class='s-item-container']"));
//		
//		System.out.println("containers " + containers.size());
//	
//		int count=0;
//		int count2=0;
//		for (int i = 0; i < containers.size(); i++) {
//			String desXpath="(//div[@class='s-item-container'])["+(i+1)+"]//h2";
//			String priceXpath="(//div[@class='s-item-container'])["+(i+1)+"]//span[@class='sx-price sx-price-large']";			
//			String desc="";
//			String price="";
//			
//			try {
//				desc=driver.findElement(By.xpath(desXpath)).getText();
//				System.out.println(desc);
//				count++;
//			} catch (NoSuchElementException e){
//				desc="this element is not available";
//				System.out.println(desc);
//			}
//			
//			try {
//				price=driver.findElement(By.xpath(priceXpath)).getText();
//				System.out.println(price);
//				count2++;
//			} catch (NoSuchElementException e) {
//				price="this element is not available";
//				System.out.println(price);
//			}
//			
//			System.out.println("================================");		
//	}
//		
//		System.out.println("count " + count );
//		System.out.println("count2 " + count2);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
