package june26WebElements;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * Assert--> is a class that comes from testng framework/library 
 * and it has different types of assertion methods:
 * EX: assertEquals(actualResult, expectedResult);
 * 	   assertTrue(boolean);
 * 	   assertFalse(boolean)
 * ===========================================================
 * Hard Assertions--> terminates the test execution when it fails
 * It only terminates the execution of @Test annotation
 * 
 * SoftAssert ==> class that comes from testng and it handles the soft assertions
 * Soft Assertion--> Doesn't terminate the test execution even it fails
 * It simply memorizes which assertion failed
 * assertAll==> method that comes from softAssert 
 * class and it reports all the memorized failures
 * Unless you use assertAll method explicitly in the end of the test it doesnt report failures.
 * Soft Assertion can generate invalid report. Be careful!
 */
public class AssertionTypes {
	
	@Test
	public void test1() {
		String expectedName="James";
		int expectedAge=27;
		SoftAssert soft=new SoftAssert();
		Assert.assertEquals("Ronaldo", expectedName);
		Assert.assertEquals(32, expectedAge);
		
//		soft.assertEquals("Ronaldo", expectedName);
//		soft.assertEquals(32, expectedAge);
		System.out.println("Ending the test");
		soft.assertAll();
	}

	
	
	
}
