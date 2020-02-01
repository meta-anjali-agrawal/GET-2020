import static org.junit.Assert.*;
import org.junit.Test;

public class HexCalcTest
{
	@Test
	public void addTest()
	{
		HexCalc hc = new HexCalc();
		String result = hc.add("a1", "1");
		assertEquals("A2", result);
	}
	
	@Test
	public void subtractTest()
	{
		HexCalc hc = new HexCalc();
		String result = hc.subtract("a1", "1");
		assertEquals("A0", result);
	}
	
	@Test
	public void multiplyTest()
	{
		HexCalc hc = new HexCalc();
		String result = hc.multiply("a1", "1");
		assertEquals("A1", result);
	}
	
	@Test
	public void divideTest()
	{
		HexCalc hc = new HexCalc();
		String result = hc.divide("a1", "1");
		assertEquals("A1", result);
	}
	
	@Test
	public void hexadecimalToDecimalTest()
	{
		HexCalc hc = new HexCalc();
		int result = hc.hexadecimalToDecimal("a1");
		assertEquals(161, result);
	}
	
	@Test
	public void decimalToHexadecimalTest()
	{
		HexCalc hc = new HexCalc();
		String result = hc.decimalToHexadecimal(161);
		assertEquals("A1", result);
	}
	
	@Test
	public void hexEqualTest()
	{
		Boolean result = HexCalc.hexEqual("a1", "1");
		assertEquals(false, result);
	}
	
	@Test
	public void hexEqualTest1()
	{
		Boolean result = HexCalc.hexEqual("a1", "a1");
		assertEquals(true, result);
	}
	
	@Test
	public void hexGreaterThanTest()
	{
		Boolean result = HexCalc.hexGreaterThan("a1", "1");
		assertEquals(true, result);
	}
	
	@Test
	public void hexGreaterThanTest1()
	{
		Boolean result = HexCalc.hexGreaterThan("a1", "b1");
		assertEquals(false, result);
	}
	
	@Test
	public void hexLessThanTest()
	{
		Boolean result = HexCalc.hexLessThan("a1", "1");
		assertEquals(false, result);
	}
	
	@Test
	public void hexLessThanTest1()
	{
		Boolean result = HexCalc.hexLessThan("a1", "b1");
		assertEquals(true, result);
	}
}
