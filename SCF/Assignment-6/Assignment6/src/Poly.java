import java.util.Arrays;

final class Poly
{
	final int[][] polyInput;
	
	Poly(int[][] polyInput)
	{
		if(polyInput.length == 0)
			throw new  AssertionError("Array is Empty.");
		this.polyInput = polyInput;
	}
	
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
	
	public Poly multiplyPoly(Poly p1 , Poly p2)
	{
		int[][] multiplyResult = new int[p1.polyInput.length * p2.polyInput.length][2];
		int k = 0;
		
		for(int i=0 ; i<p1.polyInput.length ; i++)
		{
			for(int j=0 ; j<p2.polyInput.length ; j++)
			{
				multiplyResult[k][0] = p1.polyInput[i][0]*p2.polyInput[j][0];
				multiplyResult[k][1] = p1.polyInput[i][1] + p2.polyInput[j][1];
				k++;
			}
		}
		
		for(int i=0 ; i<multiplyResult.length ; i++)
		{
			for(int j=i+1 ; j<multiplyResult.length ; j++)
			{
				if(multiplyResult[i][0] != 0 && multiplyResult[j][0] != 0 && multiplyResult[i][1]==multiplyResult[j][1])
				{
					multiplyResult[i][0] = multiplyResult[i][0] + multiplyResult[j][0];
					multiplyResult[j][0] = 0;
					multiplyResult[j][1] = 0;
				}
			}
		}
		
		Poly result =  new Poly(multiplyResult);
		
		return result;
		
	}
	
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

