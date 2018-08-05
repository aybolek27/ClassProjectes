package june26WebElements;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements2 {

	WebDriver driver;
	Faker faker = new Faker();

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up webDriver in Beforeclass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// @Ignore
	@Test
	public void myLinks() {
		driver.get("https://github.com");
		// List<WebElement> links=driver.findElements(By.tagName("a"));
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		// how many links in github website
		int numberOfLinksOnGithub = links.size();
		System.out.println("number of links: " + numberOfLinksOnGithub);
		int count = 0;
		// print text of each link
		for (WebElement each : links) {
			if (!each.getText().isEmpty()) {
				System.out.println(each.getText());
				count++;
			}
		}

		System.out.println(count);

		// add each link text into a list of Strings
		// FINDELEMENT is affected by implicit wait time
		// FINDELEMENTS is NOT affected by implicit wait time
		List<String> linkTexts = new ArrayList<>();
		for (WebElement eachLink : links) {
			if (!eachLink.getText().isEmpty()) {
				linkTexts.add(eachLink.getText());
			}
		}
		System.out.println(linkTexts.toString());

	}

	/*
	 * https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/
	 * eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg Find all input boxes and assign
	 * to List of webelements -> 2 Find all drop down boxes and assign to another
	 * List of webelements ->3 Find all check boxes and assign to another List of
	 * webelements -> 9 Find all radio boxes and assign to another List of
	 * webelements -> 9 Find all buttons and assign to another List of webelements
	 * -> 1
	 */

	@Test
	public void SeleniumWebElementsForm() {
		driver.get(
				"https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> el1 = driver.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> el2 = driver.findElements(By.tagName("select"));
		List<WebElement> el3 = driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> el4 = driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> el5 = driver.findElements(By.tagName("button"));
		// System.out.println(el1.size());
		// System.out.println(el2.size());
		// System.out.println(el3.size());
		// System.out.println(el4.size());
		// System.out.println(el5.size());
		//
		assertEquals(el1.size(), 2);
		assertEquals(el2.size(), 3);
		assertEquals(el3.size(), 9);
		assertEquals(el4.size(), 9, "message will show if it fails");
		assertEquals(el5.size(), 1, "message will show if it fails");
	}

	/*
	 * Homework: Loop through each inputbox and enter random names Loop through each
	 * dropDown and randomly select by index Loop through each checkBoxes and select
	 * each Loop through each radioButton and click one by one by waiting 1 second
	 * interwals click all buttons
	 */
	@Test
	public void Homework() {
		// Loop through each inputbox and enter random names
		driver.get(
				"https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");

		List<WebElement> inputBox = driver.findElements(By.xpath("//input[@type='text']"));
		for (int i = 0; i < inputBox.size(); i++) {
			inputBox.get(i).sendKeys(faker.name().fullName());
		}
		// Loop through each dropDown and randomly select by index
		List<WebElement> dropDown = driver.findElements(By.tagName("select"));

		for (int i = 0; i < dropDown.size(); i++) {
			int index = faker.number().numberBetween(1, 4);
			Select sel = new Select(dropDown.get(i));
			sel.selectByIndex(index);
		}
		// Loop through each checkBoxes and select each
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}

		// Loop through each radioButton and click one by one by waiting 1 second
		// interwals
		List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio']"));
		for (int i = 0; i < radioButton.size(); i++) {
			radioButton.get(i).click();

		}

		// click all buttons

		List<WebElement> buttons = driver.findElements(By.tagName("button"));

		for (int j = 0; j < buttons.size(); j++) {
			buttons.get(j).click();
		}

	}

	@Test
	public void slideShow() throws InterruptedException {
		int count2 = 0;
		driver.get("https://www.hbloom.com/Gifts/birthday-flowers");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		List<String> src = new ArrayList<>();
		for (WebElement flower : images) {
			src.add(flower.getAttribute("src"));
			count2++;

		}
		for (String link : src) {
			driver.get(link);
			// Thread.sleep(1234);
		}
		System.out.println(count2);
	}

}
