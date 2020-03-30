import static org.junit.Assert.*;
import org.junit.Test;

public class TestClass 
{
	/**
	 * Test Case 1
	 */
	@Test
	public void Test1()
	{
		InfixEvaluation infix = new InfixEvaluation();
		String inputExpression = "1 + 2 * ( 3 * 4 - 5 ) - 6";
		int result = infix.evaluate(inputExpression);
		assertEquals(9, result);
	}
	
	/**
	 * Test Case 2
	 */
	@Test
	public void Test2()
	{
		InfixEvaluation infix1 = new InfixEvaluation();
		String inputExpression = "11 + 22 * ( 33 * 44 - 55 ) - 66";
		int result = infix1.evaluate(inputExpression);
		assertEquals(30679, result);
	}
	
}
