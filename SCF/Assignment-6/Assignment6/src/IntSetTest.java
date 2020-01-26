import static org.junit.Assert.*;
import org.junit.Test;

public class IntSetTest 
{
	@Test (expected = AssertionError.class)
	public void Test()
	{
		IntSet intSet = new IntSet(new int[]{1,2,2,3,4,5,6,7,8,10});
		boolean resultIsMember = intSet.isMember(1);
		assertEquals(true, resultIsMember);
		fail("It is not a set. As there are duplicate values.");
	}
	
	@Test (expected = AssertionError.class)
	public void Test1()
	{
		IntSet intSet = new IntSet(new int[]{});
		boolean resultIsMember = intSet.isMember(1);
		assertEquals(true, resultIsMember);
		fail("Array is Empty");
	}
	
	@Test (expected = AssertionError.class)
	public void Test2()
	{
		IntSet intSet = new IntSet(new int[]{0,1,2,3,4,5,6,7,8,10});
		boolean resultIsMember = intSet.isMember(1);
		assertEquals(true, resultIsMember);
		fail("Value inside input array should be between 1 to 1000.");
	}
	
	@Test 
	public void isMemberTest()
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		boolean resultIsMember = intSet.isMember(1);
		assertEquals(true, resultIsMember);
	}
	
	@Test 
	public void isMemberTest1()
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		boolean resultIsMember = intSet.isMember(9);
		assertEquals(false, resultIsMember);
	}
	
	@Test
	public void sizeTest()
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		int resultSize = intSet.size();
		assertEquals(9, resultSize);
	}
	
	@Test
	public void isSubsetTest()
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		IntSet intSet1 = new IntSet(new int[]{4,5,6});
		boolean resultIsSubset = intSet.isSubset(intSet1);
		assertEquals(true, resultIsSubset);
	}
	
	@Test
	public void isSubsetTest1()
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		IntSet intSet1 = new IntSet(new int[]{4,6,9});
		boolean resultIsSubset = intSet.isSubset(intSet1);
		assertEquals(false, resultIsSubset);
	}
	
	@Test
	public void getComplementTest()
	{
		IntSet intset = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});
		int result[] = new int[991];
		int j=0;
		for(int i=10 ; i<=1000 ; i++)
		{
			result[j] = i;
			j++;
		}
		int[] resultGetComplement = intset.getComplement();
		assertArrayEquals(result, resultGetComplement);
			
	}
	
	@Test
	public void unionTest()
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		IntSet ints = new IntSet(new int[]{55,13,5,12,6,11});
		IntSet result = intSet.union(intSet, ints);
		IntSet expected = new IntSet(new int[]{1,2,3,4,5,6,7,8,10,55,13,12,11});
		assertArrayEquals(expected.inputArray,result.inputArray);
	}
}
