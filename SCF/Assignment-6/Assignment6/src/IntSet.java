/*
 * @author Anjali
 * The immutable class intSet using an array to represent a set of integers in the range 1-1000.
 */
import java.util.Arrays;

final class IntSet 
{
	final int[] inputArray;
	
	/**
	 * Parameterized Constructor 
	 * @param set, integer type array
	 */
	IntSet(int[] set)
	{
		if(set.length == 0)
			throw new AssertionError("Array is Empty");
		for(int i=0 ; i<set.length-1 ; i++)
		{
			if(set[i]<=0 || set[i]>1000)
				throw new AssertionError("Value inside input array should be between 1 to 1000.");
			for(int j=i+1 ; j<set.length ; j++)
			{
				if(set[i]== set[j])
					throw new AssertionError("It is not a set. As there are duplicate values.");
			}
		}	
		inputArray = set;	
	}
	
	/**
	 * Method checks whether x is a member of the set and return a boolean value
	 * @param x, element needed to be checked
	 * @return boolean value true when x is the member, else false
	 */
	public boolean isMember(int x)
	{
		for(int i=0 ; i<inputArray.length ; i++)
		{
			if(inputArray[i] == x)
				return true;
		}
		return false;
	}
	
	/**
	 * Method return the size of the set
	 * @return integer type value,  size of the set
	 */
	public int size()
	{
		return inputArray.length;
	}
	
	/**
	 * Method checks whether s is a subset of the set
	 * @param s, IntSet type input
	 * @return boolean, true when s is the Subset, else false
	 */
	public boolean isSubset(IntSet s)
	{
		for(int i=0 ; i<inputArray.length ; i++)
		{
			for(int j=0 ; j<s.size() ; j++)
			{
				if(inputArray[i]==s.inputArray[j])
				{
					if(j==s.size()-1)
						return true;
					i++;
				}
			}
		}
		return false;
	}
	
	/**
	 * Method return the complement set, you can assume that 1..1000 is the universal set
	 * @return integer array, the complement set
	 */
	public int[] getComplement()
	{
		boolean flag = false;
		int[] complementSet = new int[1000-inputArray.length];
		int k = 0;
		for(int i=1 ; i<=1000 ; i++)
		{
			flag = false;
			for(int j=0 ; j<inputArray.length ; j++)
			{
				if(inputArray[j]==i)
					flag = true;
			}
			if(flag == false)
			{
				complementSet[k] = i;
				k++;
			}
		}
		return complementSet;
	}
	
	/**
	 * Method return the union of s1 and s2
	 * @param s1, IntSet type set as an input
	 * @param s2, IntSet type set as an input
	 * @return IntSet type set, union of s1 and s2
	 */
	public IntSet union(IntSet s1, IntSet s2)
	{
		int[] result = new int[s1.size()+s2.size()];
		int k = 0;
		for(int i=0 ; i<s1.size() ; i++)
		{
			result[k] = s1.inputArray[i];
			k++;
		}
		for(int j=0 ; j<s2.size() ; j++)
		{
			if(!(s1.isMember(s2.inputArray[j])))
			{
				result[k] = s2.inputArray[j];
				k++;
			}
		}
		//Changed the size of unionSet array to remove Zeros(0)
		result = Arrays.copyOf(result, k);
		IntSet unionSet = new IntSet(result);
		return unionSet;
	}
	
	public static void main(String[] args)
	{
		IntSet intSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
		
		boolean resultIsMember = intSet.isMember(1);
		System.out.println(resultIsMember);
		boolean resultIsMember1 = intSet.isMember(10);
		System.out.println(resultIsMember1);
		boolean resultIsMember2 = intSet.isMember(9);
		System.out.println(resultIsMember2);
		System.out.println();
		
		int resultSize = intSet.size();
		System.out.println(resultSize);
		System.out.println();
		
		IntSet is = new IntSet(new int[]{4,5,6});
		boolean resultIsSubset = intSet.isSubset(is);
		System.out.println(resultIsSubset);
		IntSet iset = new IntSet(new int[]{4,5,9});
		boolean resultIsSubset1 = intSet.isSubset(iset);
		System.out.println(resultIsSubset1);
		System.out.println();
		
		int[] resultGetComplement = intSet.getComplement();
		for(int i=0 ; i<resultGetComplement.length ; i++)
			System.out.println(resultGetComplement[i]);
		System.out.println();
		
		IntSet ints = new IntSet(new int[]{55,13,5,12,6,11});
		IntSet resultUnion = intSet.union(intSet, ints);
		for(int i=0 ; i<resultUnion.size() ; i++)
			System.out.println(resultUnion.inputArray[i]);
		System.out.println();
	}
}
