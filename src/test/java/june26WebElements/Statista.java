package june26WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Statista {

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
	public void navigator() throws InterruptedException {
		driver.get("https://statista.com");
		Thread.sleep(2000);
     List<WebElement> navigators=driver.findElements(By.xpath("//div[@id='navigation']/nav/ul/li"));
     Actions action=new Actions(driver);
		for (int i = 0; i < navigators.size()-2; i++) {
		     action.moveToElement(navigators.get(i)).perform();
		     Thread.sleep(1000);
		}
		
	}
	
	////div[@id='navigation']/nav/ul/li[2]/div/div/div/ul/li

}
