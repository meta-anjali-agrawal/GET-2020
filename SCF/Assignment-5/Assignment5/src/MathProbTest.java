import static org.junit.Assert.*;
import org.junit.Test;

public class MathProbTest 
{
	@Test
	public void findHCFTest()
	{
		int result = MathProb.findHCF(12, 30);
		assertEquals(6,result);
	}
	
	@Test
	public void findHCFTest1()
	{
		int result = MathProb.findHCF(96, 404);
		assertEquals(4,result);
	}
	
	@Test
	public void findLCMTest()
	{
		MathProb mp = new MathProb();
		int result = mp.findLCM(30, 12);
		assertEquals(60,result);
	}
	
	@Test
	public void findLCMTest1()
	{
		MathProb mp = new MathProb();
		int result = mp.findLCM(12, 12);
		assertEquals(12,result);
	}
	
	@Test
	public void findLCMTest2()
	{
		MathProb mp = new MathProb();
		int result = mp.findLCM(404, 96);
		assertEquals(9696,result);
	}
}
