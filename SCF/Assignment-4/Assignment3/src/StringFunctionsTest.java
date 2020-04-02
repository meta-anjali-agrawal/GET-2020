import static org.junit.Assert.*;
import org.junit.Test;

public class StringFunctionsTest
{
	@Test
	public void compareTest()
	{
		int result = StringFunctions.compare("anjali", "agrawal");
		assertEquals(0, result);
	}
	
	@Test
	public void compareTest1()
	{
		int result = StringFunctions.compare("anjali", "anjali");
		assertEquals(1, result);
	}
	
	@Test
	public void reverseTest()
	{
		String result = StringFunctions.reverse("anjali");
		assertEquals("ilajna", result);
	}
	
	@Test
	public void changeCaseTest()
	{
		String result = StringFunctions.changeCase("Anjali");
		assertEquals("aNJALI", result);
	}
	
	@Test
	public void largestWordMethodTest()
	{
		String result = StringFunctions.largestWordMethod("anjali", "agrawal");
		assertEquals("agrawal", result);
	}
}
