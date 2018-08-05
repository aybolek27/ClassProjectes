package webtables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	String url="file:///C:/Users/Aybolek/eclipse-workspace/ClassProjectes/src/test/java/webtables/webtable.html";
	///html/body/table/tbody/tr[2]/td[2]
	static WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up webDriver in Beforeclass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void readScores() {
		driver.get(url);
		//read whole webtable data and print
//		WebElement table=driver.findElement(By.tagName("table"));
//		System.out.println(table.getText());
//		
//		//find out how many rows in the table
//		
//	List<WebElement> rows = driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr"));
//		
//		System.out.println("number of rows " + rows.size());
//		
//		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='worldcup']/thead/tr/th"));
//		
//		System.out.println("Headers: " + headers.size());
//		List<String> expHeaders=Arrays.asList("Team1", "Score", "Team2");
//		List<String> actHeaders=new ArrayList<>();
//		for (WebElement each : headers) {
//			actHeaders.add(each.getText());
//		}
//		
		SoftAssert softAssert=new SoftAssert();
		//softAssert.assertEquals(actHeaders, expHeaders);
//		
//		//write xpath and findelement gettext -> needs to print Egypt
//		System.out.println(driver.findElement(By.xpath("//table[@id='worldcup']/tbody[3]/tr/td[1]")).getText());
//		String egpXpath="//table[@id='worldcup']/tbody[3]/tr/td[1]";
//		softAssert.assertEquals(driver.findElement(By.xpath(egpXpath)).getText(), "Egypt");
//		
		//loop it and print all data
		//get number of rows, columns then nested loop
		int rowsCount=driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr")).size();
		int colsCount=driver.findElements(By.xpath("//table[@id='worldcup']/thead/tr/th")).size();
		System.out.println("======================================");
		
		for (int i = 1; i <= rowsCount; i++) {
			for (int j = 1; j <= colsCount; j++) {
			String data=driver.findElement(By.xpath("//table[@id='worldcup']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
			System.out.print(data + "\t");
			
			}
			System.out.println();
		}
		
		softAssert.assertAll();
		
	}
	
	
	@Test
	public void applicatData() {
		driver.get("https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
		printTableData("reportTab");
		
	}
	
	public static void printTableData(String id) {
		int rowsCount=driver.findElements(By.xpath("//table[@id='"+id+"']/tbody/tr")).size();
		int colsCount=driver.findElements(By.xpath("//table[@id='" +id+"']/thead/tr/th")).size();
		System.out.println("======================================");
		for (int i = 1; i <= rowsCount; i++) {
			for (int j = 1; j <= colsCount; j++) {
			String data=driver.findElement(By.xpath("//table[@id='"+id+"']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
			System.out.print(data + "\t");
			
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
