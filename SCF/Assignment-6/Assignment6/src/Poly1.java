
final class Poly1
{
	final int[] polyInput;
	
	Poly1(int[] polyInput)
	{
		if(polyInput.length == 0)
		{
			System.out.println("Array is Empty");
		}
		this.polyInput = polyInput;
	}
	
	public double evaluate(double variable)
	{
		double result = 0;
		for(int i=0 ; i<polyInput.length ; i++)
		{
			result += polyInput[i] * Math.pow(variable, i);
		}
		return result;
	}
	
	public int degree()
	{
		int degree=0;
		for(int i=polyInput.length-1 ; i>=0 ; i--)
		{
			if(polyInput[i]==0)
			{
				degree = i - 1;
			}
				
			else
			{
				degree = i;
				break;
			}
		}
		return degree;
	}
	
	public int[] addPoly(Poly1 p1, Poly1 p2)
	{
		int[] result;
		int i;
		if(p1.degree()>p2.degree())
		{
			result = new int[p1.degree()+1];
			for(i=0 ; i<p2.degree() + 1 ; i++)
			{
				result[i] = p1.polyInput[i] + p2.polyInput[i];
			}
			while(i<result.length)
			{
				result[i] = p1.polyInput[i];
				i++;
			}	
		}
			
		else
		{
			result = new int[p2.degree()+1];
			for(i=0 ; i<p1.degree() + 1 ; i++)
			{
				result[i] = p1.polyInput[i] + p2.polyInput[i];
			}
			while(i<result.length)
			{
				result[i] = p2.polyInput[i];
				i++;
			}	
		}
		return result;
	}
	
	public int[] multiplyPoly(Poly1 p1, Poly1 p2)
	{
		int size = (p1.degree()+1) * (p2.degree()+1);
		int length, i, j;
		int[] result = new int[size];
		
		for(i=0 ; i<size ; i++)
			result[i] = 0;
		
		if((p1.degree()+1) < (p2.degree()+1))
			length = p1.degree() + 1;
		else
			length = p2.degree() + 1;
		
		for(i=0 ; i<length ; i++)
		{
			if(p1.polyInput[i]==0 && p2.polyInput[i]==0)
				result[i] += 0;
			else
				result[i+i] += p1.polyInput[i] * p2.polyInput[i];
		}
		
		for(i=0 ; i<p1.degree()+1 ; i++)
		{
			for(j=0 ; j<p2.degree()+1 ; j++)
			{
				if(i!=j)
					result[i+j] += p1.polyInput[i] * p2.polyInput[j];
			}
		}
		
		return result;
	}
	
	static void printPoly(int poly[]) 
	{ 
        for (int i = 0; i < poly.length; i++) 
        { 
        	if(poly[i]!=0)
        	{
        		if(poly[i]>0 && i!=0)
        			System.out.print(" + " + poly[i]); 
        		else if(poly[i]<0)
        			System.out.print(" - " + -poly[i]); 
        		else
        			System.out.print(poly[i]);
                if (i != 0) 
                { 
                    System.out.print("x^" + i); 
                } 
        	} 
        } 
    }

	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		Poly1 poly = new Poly1(new int[]{1,2,0,3});
		/*int maxDegree=sc.nextInt();
		int input[]= new input[maxDegree];
		for(int i=0;i<maxDegree;i++)
		{
			input[i]=sc.nextInt();
		}
		Poly1 poly = new Poly1(input);*/
		double resultEvalute = poly.evaluate(2);
		System.out.println(resultEvalute);
		
		int resultDegree = poly.degree();
		System.out.println(resultDegree);
		
		Poly1 p2 = new Poly1(new int[]{0,1,2});
		int[] resultAddPoly = poly.addPoly(poly, p2);
		printPoly(resultAddPoly);
		System.out.println();
		
		//Poly p2 = new Poly(new int[]{0,1,3});
		int[] resultMultiplyPoly = poly.multiplyPoly(poly, p2);
		printPoly(resultMultiplyPoly);

	}

}
