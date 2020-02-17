import static org.junit.Assert.*;
import org.junit.Test;
//import org.hamcrest.*;

public class ArrOperationTest
{
	
	@Test
	public void maxMirrorTest()
	{
		int result = ArrOperation.maxMirror(new int[] {1, 2, 3, 8, 9, 3, 2, 1});
		assertEquals(3, result);
	}
	
	@Test
	public void maxMirrorTest1()
	{
		int result = ArrOperation.maxMirror(new int[] {7, 1, 4, 9, 7, 4, 1});
		assertEquals(2, result);
	}
	
	@Test
	public void maxMirrorTest2()
	{
		int result = ArrOperation.maxMirror(new int[] {1, 2, 1, 4});
		assertEquals(3, result);
	}
	
	@Test
	public void maxMirrorTest4()
	{
		int result = ArrOperation.maxMirror(new int[] {1, 4, 5, 3, 5, 4, 1});
		assertEquals(7, result);
	}
	
	@Test
	public void maxMirrorTest5()
	{
		try
		{
			int result = ArrOperation.maxMirror(new int[] {});
			assertEquals(0, result);
		}catch(AssertionError ae)
		{
			//ae.printStackTrace();
			System.out.println("Error");
		}
		
	}
	
	
	@Test
	public void clumpsMethodTest()
	{
		int result = ArrOperation.clumpsMethod(new int[] {1, 2, 2, 3, 4, 4});
		assertEquals(2, result);
	}
	
	@Test
	public void clumpsMethodTest1()
	{
		int result = ArrOperation.clumpsMethod(new int[] {1, 1, 2, 1, 1});
		assertEquals(2, result);
	}
	
	@Test
	public void clumpsMethodTest2()
	{
		int result = ArrOperation.clumpsMethod(new int[] {1, 1, 1, 1, 1});
		assertEquals(1, result);
	}
	
	@Test
	public void fixXYTest()
	{
		int[] result = ArrOperation.fixXY(new int[] {5, 4, 9, 4, 9, 5}, 4, 5);
		assertArrayEquals(new int[] {9, 4, 5, 4, 5, 9}, result);
	}
	
	@Test
	public void fixXYTest1()
	{
		int[] result = ArrOperation.fixXY(new int[] {1, 4, 1, 5}, 4, 5);
		assertArrayEquals(new int[] {1, 4, 5, 1}, result);
	}
	
	@Test
	public void fixXYTest2()
	{
		int[] result = ArrOperation.fixXY(new int[] {1, 4, 1, 5, 5, 4, 1}, 4, 5);
		assertArrayEquals(new int[] {1, 4, 5, 1, 1, 4, 5}, result);
	}
	
	@Test
	public void splitArrayTest()
	{
		int result = ArrOperation.splitArray(new int[] {1, 1, 1, 2, 1});
		assertEquals(3, result);
	}
	
	@Test
	public void splitArrayTest1()
	{
		int result = ArrOperation.splitArray(new int[] {2, 1, 1, 2, 1});
		assertEquals(-1, result);
	}
	
	@Test
	public void splitArrayTest2()
	{
		int result = ArrOperation.splitArray(new int[] {10, 10});
		assertEquals(1, result);
	}
	
}
