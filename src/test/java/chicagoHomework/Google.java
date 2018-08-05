package chicagoHomework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Google {
	
	@BeforeClass
	public void setup() {
		System.out.println("Setup the environment");
	}
	
	@Test
	public void googleSearch() {
		System.out.println("Searching item and validating");
		DataStorage.addData("myKey", "iphone9");
	}
	
	@Test
	public void googleAd() {
		System.out.println("Google advertisement test");
	}
	
	@Test
	public void wgoogleImage() {
		System.out.println("Verifying google images");
		String s=DataStorage.getData("myKey");
		System.out.println("My data: " + s);
	}

}
