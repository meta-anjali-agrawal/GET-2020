/**
 * 
 * @author Anjali
 * Class to implement LCM and HCF using recursion.
 */
public class MathProb 
{
	int lcm = 0;
	
	/**
	 * H.C.F of two numbers firstValue and secondValue using Euclid’s algorithm.
	 * @param firstValue, integer type parameter passed
	 * @param secondValue, integer type parameter passed
	 * @return H.C.F. of two numbers passed as an parameter
	 */
	public static int findHCF(int firstValue, int secondValue)
	{
		if(firstValue==0)
			return secondValue;
		return findHCF(secondValue%firstValue, firstValue);
	}
	
	/**
	 * L.C.M. of two numbers firstValue and secondValue.
	 * @param firstValue, integer type parameter passed
	 * @param secondValue, integer type parameter passed
	 * @return L.C.M. of two numbers passed as an parameter
	 */
	public int findLCM(int firstValue, int secondValue)
	{
		lcm += secondValue ;
		if((lcm % firstValue ==0) && (lcm % secondValue ==0))
			return lcm;
		else
			return findLCM(firstValue, secondValue);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//int result = findLCM(404, 96);
		//System.out.println(result);

	}

}
