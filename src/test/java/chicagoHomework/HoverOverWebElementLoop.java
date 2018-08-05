package chicagoHomework;

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

public class HoverOverWebElementLoop {
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
		List<WebElement> navigators = driver.findElements(By.xpath("//div[@id='navigation']/nav/ul/li"));
		List<WebElement> menu = driver.findElements(By.xpath("//div[@id='navigation']/nav/ul/li[2]/div/div/div/ul/li"));
		
		System.out.println(menu.size());
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.id("cookiesNotificationConfirm")).click();
		action.moveToElement(navigators.get(1)).perform();

		Thread.sleep(2000);
		for (int i = 0; i < menu.size(); i++) {
			menu.get(i).click();
		//action.moveToElement(menu.get(i)).perform();
		}

	}
}