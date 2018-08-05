package july7Maruf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;

	@BeforeMethod 
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	 @AfterMethod
		 public void tearDown() {
		 driver.close();
		 }
	/*
	 * @parameter expected title will switch to new tab based on expected title will
	 * switch back to the original tab, if the expected title does not exist
	 */

	public void switchByTitle(String title) {
		String original = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(title)) {
				//do not do anything else and leave the method
				//since we are now in the right window
				return;
			}
		}
		driver.switchTo().window(original);
	}
}
