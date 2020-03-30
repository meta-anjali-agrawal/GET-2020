import static org.junit.Assert.*;
import org.junit.Test;

public class TestClass
{
	/**
	 * Test Case
	 */
	@Test
	public void test()
	{
		Queue queue = new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		int[] expected = new int[]{1,2,3,4,5};
		assertArrayEquals(expected, queue.getQueue());
		
		queue.dequeue();
		int[] expect = new int[]{-1,2,3,4,5};
		assertArrayEquals(expect, queue.getQueue());

		queue.enqueue(1);
		assertArrayEquals(expected, queue.getQueue());		
		
	}
	
}
