package june30WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Repeat {
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
		List<WebElement>  containers=driver.findElements(By.xpath("//div[@class='s-item-container']"));
		
		System.out.println("containers " + containers.size());
	
		int count=0;
		int count2=0;
		for (int i = 0; i < containers.size(); i++) {
			String desXpath="(//div[@class='s-item-container'])["+(i+1)+"]//h2";
			String priceXpath="(//div[@class='s-item-container'])["+(i+1)+"]//span[@class='sx-price sx-price-large']";			
			String desc="";
			String price="";
			
			try {
				desc=driver.findElement(By.xpath(desXpath)).getText();
				System.out.println(desc);
				count++;
				try {
					price=driver.findElement(By.xpath(priceXpath)).getText();
					System.out.println(price);
					count2++;
				} catch (NoSuchElementException e) {
					price="there is no price for this product";
					System.out.println(price);
				}
			} catch (NoSuchElementException e){
				desc="there is no description for this product";
				System.out.println(desc);
			}
			
			
			
			System.out.println("================================");		
	}
		
		System.out.println("count " + count );
		System.out.println("count2 " + count2);
	}
}
