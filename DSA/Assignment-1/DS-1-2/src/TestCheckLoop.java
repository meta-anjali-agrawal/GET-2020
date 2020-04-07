import static org.junit.Assert.*;
import org.junit.Test;

public class TestCheckLoop {
	/**
	 * Constructor
	 */
	LinkedList lList = new LinkedList(); 
	public TestCheckLoop(){
		lList.insertElement(1);
		lList.insertElement(2);
		lList.insertElement(3);
		lList.insertElement(4);
		lList.insertElement(5);
		lList.insertElement(6);
		lList.insertElement(7);
		lList.insertElement(8);
	}
	boolean expectedData = true;
	
	/**
	 * Test case
	 */
	@Test
	public void TestCase() {
		Node current = lList.getHead();
		for(int i=0; i<4 ; i++) {
			current = current.getNext();
		}
		current.setNext(lList.getHead().getNext());
		boolean result = lList.checkLoop();
		assertEquals(expectedData, result);
	}

}
