import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest
{
	@Test
	public void linearSearchMethodTest()
	{
		int result = Search.linearSearchMethod(new int[]{5,3,7,1,2,6,10}, 6);
		assertEquals(6,result);
	}
	
	@Test
	public void binarySearchMethodTest()
	{
		Search s = new Search();
		int result = s.binarySearchMethod(new int[]{1,2,3,4,5,6,7}, 6);
		assertEquals(6,result);
	}
}
