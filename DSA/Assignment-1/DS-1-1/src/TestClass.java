import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {

	/**
	 * Constructor
	 */
	LinkedList lList = new LinkedList(); 
	public TestClass(){
		lList.insertElement(2);
		lList.insertElement(3);
		lList.insertElement(4);
		lList.insertElement(5);
		lList.insertElement(6);
		lList.insertElement(7);
	}
	
	/**
	 * Test case
	 */
	@Test
	public void TestCase() {
		boolean result = lList.rotateSubList(2, 5, 2);
		boolean expectedData = true;
		assertEquals(expectedData, result);
	}
	
}
