import static org.junit.Assert.*;

import org.junit.Test;;

public class PolyTest
{
	
	@Test (expected = AssertionError.class)
	public void Test()
	{
		Poly poly = new Poly(new int[][]{});
		double resultEvalute = poly.evaluate(2);
		assertEquals(49.0, resultEvalute, 0.00);
		fail("Array is Empty.");
	}
	
	@Test (expected = AssertionError.class)
	public void Test1()
	{
		Poly poly = new Poly(new int[][]{{0,1},{2,3}});
		double resultEvalute = poly.evaluate(2);
		assertEquals(49.0, resultEvalute, 0.00);
		fail("Enter non zero coeff");
	}
	
	@Test
	public void evaluateTest()
	{
		Poly poly = new Poly(new int[][]{{4,3},{3,2},{2,1},{1,0}});
		double resultEvalute = poly.evaluate(2);
		assertEquals(49.0, resultEvalute, 0.00);
	}
	
	@Test
	public void degreeTest()
	{
		Poly poly = new Poly(new int[][]{{4,3},{3,2},{2,1},{1,0}});
		int resultDegree = poly.degree();
		assertEquals(3, resultDegree);
	}
	
	@Test
	public void addPolyTest()
	{
		Poly poly = new Poly(new int[][]{{4,3},{3,2},{2,1},{1,0}});
		Poly poly2 = new Poly(new int[][]{{2,3},{1,2}});
		Poly resultAddPoly = poly.addPoly(poly, poly2);
		Poly expected = new Poly(new int[][]{{6,3},{4,2},{2,1},{1,0}});
		assertArrayEquals(expected.polyInput, resultAddPoly.polyInput);
	}
	
	@Test
	public void multiplyPolyTest()
	{
		Poly poly = new Poly(new int[][]{{4,3},{3,2},{2,1},{1,0}});
		Poly poly2 = new Poly(new int[][]{{2,2},{1,1}});
		Poly resultMultiplyPoly = poly.multiplyPoly(poly, poly2);
		Poly expected = new Poly(new int[][]{{8,5},{10,4},{7,3},{4,2},{1,1}});
		assertArrayEquals(expected.polyInput, resultMultiplyPoly.polyInput);
	}
	
}
