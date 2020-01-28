/**
 * @author Anjali
 * The immutable class Poly using an array to represent single variable polynomial.
 * Note that you should be storing only those terms of polynomial that have non zero coefficient.
 * You can assume that the coefficients are integers.
 */
import java.util.Arrays;
import java.util.*;

final class Poly
{
	final int[][] polyInput;
	
	/**
	 * Parameterized Constructor
	 * @param polyInput, 2D array as an input
	 * 0 index is for Coefficient
	 * 1 index is for Exponent
	 */
	Poly(int[][] polyInput)
	{
		if(polyInput.length == 0)
			throw new  AssertionError("Array is Empty.");
		for(int i=0 ; i<polyInput.length ; i++)
		{
			if(polyInput[i][0]==0)
				throw new AssertionError("Enter non zero coeff");
		}
		this.polyInput = polyInput;
	}
	
	/**
	 * Method return the value of the polynomial for the given value of the variable
	 * @param variable, double type input
	 * @return double, value after evaluation
	 */
	public double evaluate(double variable)
	{
		//Zero(0) is for coefficient and One(1) is for Exponent
		double result = 0;
		for(int i=0 ; i<polyInput.length ; i++)
		{
			result += polyInput[i][0] * Math.pow(variable, polyInput[i][1]);
		}
		return result;
	}
	
	/**
	 * Method return the degree of the polynomial
	 * @return integer type value, degree of the polynomial
	 */
	public int degree()
	{
		int degree = 0;
		for(int i=0 ; i<polyInput.length ; i++)
		{
			if(polyInput[i][1]>degree)
				degree = polyInput[i][1];
		}
		return degree;
	}
	
	/**
	 * Method return the sum of the polynomials p1 and p2
	 * @param p1 Poly type input
	 * @param p2 Poly type input
	 * @return Poly, sum of two polynomials
	 */
	public Poly addPoly(Poly p1, Poly p2)
	{
		int[][] addResult = new int[p1.polyInput.length + p2.polyInput.length][2];
		int k=0;
		
		for(int i=0; i<p1.polyInput.length; i++)
		{
			int flag=0;
			for(int j=0; j<p2.polyInput.length; j++)
			{
				if(p1.polyInput[i][1] == p2.polyInput[j][1])
				{
					flag=1;
					addResult[k][0] = p1.polyInput[i][0] + p2.polyInput[j][0];
					addResult[k][1] = p1.polyInput[i][1];
					k++;
					p2.polyInput[j][0] = 0;
				}
				
			}
			if(flag==0)
			{
				addResult[k][0] = p1.polyInput[i][0];
				addResult[k][1] = p1.polyInput[i][1];
				k++;
			}
		}
		
		for(int i=0; i<p2.polyInput.length; i++)
		{
			if(p2.polyInput[i][0]!=0)
			{
				addResult[k][0] = p2.polyInput[i][0];
				addResult[k][1] = p2.polyInput[i][1];
				k++;
			}	
				
		}
		
		addResult = Arrays.copyOf(addResult, k);
		Poly poly = new Poly(addResult);
		return poly;
	}
	
	/**
	 * Method return the product of polynomials p1 and p2
	 * @param p1, Poly type input
	 * @param p2, Poly type input
	 * @return Poly, product of two Polynomials
	 */
	public Poly multiplyPoly(Poly p1 , Poly p2)
	{
		ArrayList<Integer> coeff = new ArrayList<Integer>();
		ArrayList<Integer> exponent = new ArrayList<Integer>();
		
		for(int i=0 ; i<p1.polyInput.length ; i++)
		{
			for(int j=0 ; j<p2.polyInput.length ; j++)
			{
				coeff.add(p1.polyInput[i][0]*p2.polyInput[j][0]);
				exponent.add(p1.polyInput[i][1] + p2.polyInput[j][1]);
			}
		}
		
		for(int i=0 ; i<coeff.size() ; i++)
		{
			for(int j=i+1 ; j<exponent.size() ; j++)
			{
				if(coeff.get(i) != 0 && coeff.get(j) != 0 && exponent.get(i)==exponent.get(j))
				{
					coeff.set(i, coeff.get(i) + coeff.get(j)) ;
					coeff.remove(j);
					exponent.remove(j);
				}
			}
		}
		
		int[][] multiplyResult = new int[coeff.size()][2];
		for(int i=0 ; i<coeff.size() ; i++)
		{
			multiplyResult[i][0] = coeff.get(i);
			multiplyResult[i][1] = exponent.get(i);
		}
		
		Poly result =  new Poly(multiplyResult);
		return result;
		
	}
	
	/**
	 * Method prints the polynomial
	 * @param poly, Poly needed to be printed
	 * @return Poly
	 */
	static Poly printPoly(Poly poly) 
	{ 
        for (int i = 0; i < poly.polyInput.length; i++) 
        { 
        	if(poly.polyInput[i][0]!=0)
        	{
        		if(poly.polyInput[i][0]>0 && i!=0)
        			System.out.print(" + " + poly.polyInput[i][0]); 
        		else if(poly.polyInput[i][0]<0)
        			System.out.print(" - " + -poly.polyInput[i][0]); 
        		else
        			System.out.print(poly.polyInput[i][0]);
                if (poly.polyInput[i][1] != 0) 
                { 
                    System.out.print("x^" + poly.polyInput[i][1]); 
                } 
        	} 
        }
        return poly;
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Poly poly = new Poly(new int[][]{{4,3},{3,2},{2,1},{1,0}});
		double resultEvalute = poly.evaluate(2);
		System.out.println("Evaluate : " + resultEvalute);
		System.out.println();
		
		int resultDegree = poly.degree();
		System.out.println("Degree : " + resultDegree);
		System.out.println();
		
		Poly poly2 = new Poly(new int[][]{{2,3},{1,2}});
		Poly resultAddPoly = poly.addPoly(poly, poly2);
		System.out.println("Add : ");
		printPoly(resultAddPoly);
		
		System.out.println();
		
		System.out.println();
		Poly poly3 = new Poly(new int[][]{{2,2},{1,1}});
		Poly resultMultiplyPoly = poly.multiplyPoly(poly, poly3);
		System.out.println("Multiply : ");
		printPoly(resultMultiplyPoly);
		
		
	}

}

