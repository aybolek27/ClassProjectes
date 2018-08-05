package july7Maruf;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PopUpExamples extends TestBase{
	
	@Test
	public void jsAlertTest() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("(//button)[1]")).click();
		Alert alert=driver.switchTo().alert();
		//alert.getText()--> get the text of alert
		System.out.println(alert.getText());
		//click ok on alert
		alert.accept();
		
		
		driver.findElement(By.xpath("(//button)[2]")).click();
		 alert=driver.switchTo().alert();
		//click cancel on alert
		alert.dismiss();
		
		driver.findElement(By.xpath("(//button)[3]")).click();
		 alert=driver.switchTo().alert();
		//types on alert
		alert.sendKeys("oooooooh");
		//get the text
		System.out.println(alert.getText());
		//click ok

		
		try {
			Alert alert1=driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			
			Assert.fail("Alert was not present");
		}
		
		alert.accept();
	}
	
	
	@Test
	public void htmlPopUps() {
		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
		driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
		//html based popups can be handled like other webelement
		
		assertTrue(driver.findElement(By.xpath("//span[.='No']")).isDisplayed());
		//locate the no button on the pop up and click
		driver.findElement(By.xpath("//span[.='No']")).click();
		
		
	}
	
	
	
	
	
	

}
