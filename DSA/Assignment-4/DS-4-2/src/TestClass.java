import static org.junit.Assert.*;
import org.junit.Test;

public class TestClass 
{
	
	@Test
	public void Test()
	{
		int result = UniqueChar.countUniqueCharacter("hello");
		int expectedOutput = 3;
		assertEquals(expectedOutput, result);
	}
	
}
