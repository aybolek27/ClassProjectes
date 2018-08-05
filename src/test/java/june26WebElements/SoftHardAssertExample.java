package june26WebElements;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftHardAssertExample {
	
	//SoftAssert soft=new SoftAssert();  //not recommended use in this way
	@Test
	public void test1() {

		SoftAssert soft=new SoftAssert();
		String expectedName="James";
		int expectedAge=28;
		soft.assertEquals("Ronaldo", expectedName);
		soft.assertEquals(32, expectedAge);
		System.out.println("Ending the test");
		soft.assertAll();
	}
	
	
	
	@Test
	public void w() {

		SoftAssert soft=new SoftAssert();//should be explicitly showen in each test
		System.out.println("second test method starting");
		String s="Hi";
		soft.assertEquals("Hi", s);
		soft.assertAll();//saves failure report inside the object so we have 
		//instantiate separately for each test in order to report seperately
	}
	
	@AfterClass
	public void ending() {
		
		//soft.assertAll();  //not recommended to use in this way
	}

}
