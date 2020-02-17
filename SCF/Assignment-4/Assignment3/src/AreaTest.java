import static org.junit.Assert.*;
import org.junit.Test;

public class AreaTest 
{
	
	@Test
	public void triangleAreaMethodTest()
	{
		double result = Area.triangleAreaMethod(2, 3);
		assertEquals(2, result, 2);
	}
	
	@Test
	public void rectangleAreaMethodTest()
	{
		double result = Area.rectangleAreaMethod(2, 3);
		assertEquals(6, result, 2);
	}
	
	@Test
	public void squareAreaMethodTest()
	{
		double result = Area.squareAreaMethod(2);
		assertEquals(4, result, 2);
	}
	
	@Test
	public void circleAreaMethodTest()
	{
		double result = Area.circleAreaMethod(2);
		assertEquals(12.56, result, 2);
	}
}
