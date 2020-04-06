import static org.junit.Assert.*;
import org.junit.Test;

public class nQueensTest
{
	@Test
	public void nQueenTest()
	{
		nQueens nqueen = new nQueens();
		Boolean result = nqueen.nOueen(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, 0, 4);
		assertEquals(true,result);
		nqueen.print();
	}
}
