package webtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {
	static WebDriver driver;
	static Map<String, String> info=new HashMap<>();
	static int sum=0;
	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up webDriver in Beforeclass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/*
	 * 1) goto https://forms.zohopublic.com/murodil/report/Applicants/reportperma/
	 * DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8
	 * 
	 * 2) Create a HashMap
	 * 
	 * 3) change row number to 100, read all data on first page and put uniquID as a
	 * KEY
	 * 
	 * and Applicant info as a Value to a map.
	 * applicants.put(29,"Amer, Sal-all@dsfdsf.com-554-434-4324-130000")
	 * 
	 * 4) Click on next page , repeat step 3
	 * 
	 * 5) Repeat step 4 for all pages
	 * 
	 * 6) print count of items in a map. and assert it is matching with a number at
	 * the buttom
	 */
	@Test
	public void homework() throws InterruptedException {
		driver.get(
				"https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
		driver.findElement(By.id("recPerPage")).click();
		driver.findElement(By.xpath("//select[@id='recPerPage']/option[4]")).click();
		Thread.sleep(2000);
		getTableData("reportTab");
		
		driver.findElement(By.xpath("//a[@class='nxtArrow']")).click();
		Thread.sleep(2000);
		getTableData("reportTab");
		
		printTableData();
		
		String total=driver.findElement(By.xpath("//span[@id='total']")).getText();
		if(sum==Integer.parseInt(total))
			System.out.println("Total data is matching.");
		else 
			System.out.println("Total dat is not matching.");
		
	}

	public  void getTableData(String id) {
		
	
		int rowsCount = driver.findElements(By.xpath("//table[@id='" + id + "']/tbody/tr")).size();
		int colsCount = driver.findElements(By.xpath("//table[@id='" + id + "']/thead/tr/th")).size();
		sum+=rowsCount;
		System.out.println(rowsCount + " " + colsCount);
		System.out.println("======================================");
		for (int i = 1; i <= rowsCount; i++) {
			String key = "";
			String value = "";
			for (int j = 1; j <= colsCount; j++) {
				String data = driver
						.findElement(By.xpath("//table[@id='" + id + "']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				if (j == 1) {
					key = data;
				} else {
					value = value+ data + "-" ;
				}

			}
			
			info.put(key, value.substring(0,value.length()-2));
		}
	}

	
	public void printTableData() {
	int count=1;
		Set<String> keys = info.keySet();//returns unique key set
		
		for (String eachKey : keys) {
			System.out.println(count + " " + eachKey + " " + info.get(eachKey));
			count++;
		}
	System.out.println("Total count of items in the map: " + sum);
	}
}
