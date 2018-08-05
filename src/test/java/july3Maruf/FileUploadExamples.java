package july3Maruf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadExamples {
	
	
	@Test
	public void testFileUpload() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		WebElement input=driver.findElement(By.id("file-upload"));
		String filePath="C:\\Users\\Aybolek\\Desktop\\draw\\download.jpg";
		input.sendKeys(filePath);
		
		
		
		WebElement upload=driver.findElement(By.id("file-submit"));
		upload.click();
	
				
	}

}
