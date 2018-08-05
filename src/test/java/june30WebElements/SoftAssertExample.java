package june30WebElements;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SoftAssertExample {
	
	SoftAssert softAssert=new SoftAssert();
	
	@Test
	public void test1() {
		int i=100;
		int j=200;
		System.out.println("First Assertion:");
		softAssert.assertEquals(i, j, "I and J is not equal");
		System.out.println("Second Assertion:");
		softAssert.assertNotEquals(i, j);
		System.out.println("Third Assertion:");
		softAssert.assertTrue(i>j,"I is not greater than J");
		
		softAssert.assertAll();
	}

}
