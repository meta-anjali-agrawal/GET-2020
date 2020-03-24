//import java.util.*;
/**
 * @author Anjali
 * Class ArrOperation support following methods
 * A method returns the size of the largest mirror section found in the input array.
 * A method returns the number of clumps in the input array.
 * A method returns an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
 * A method returns the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1.
 */
public class ArrOperation
{
	/**
	 * This method returns the size of the largest mirror section found in the input array.
	 * @param arr,  int type array
	 * @return max, integer type
	 */
	public static int maxMirror(int[] arr)
	{
		int size = arr.length;
		if(size == 0)
		{
			throw new AssertionError();
		}
		int max =0;
		int [][]matrix=new int[size+1][size+1];
		for(int i=0;i<=size;i++)
		{
			for(int j=0;j<=size;j++)
			{
				if(i==0||j==0) 
				{
					matrix[i][j]=0;
				}
				else if(arr[i-1]==arr[size-j])
				{
					matrix[i][j]=matrix[i-1][j-1]+1;
				}
				else
				{
					matrix[i][j]=0;
				}
				if(max<matrix[i][j])
				{
					max=matrix[i][j];
				}

			}

		}
		return max;
	}
	
	/**
	 * This method returns the number of clumps in the input array.
	 * Clump in an array is a series of 2 or more adjacent elements of the same value.
	 * @param inputArray , int type array
	 * @return count, returns number of clumps
	 */
	public static int clumpsMethod(int[] inputArray)
	{
		int size = inputArray.length;
		if(size == 0)
		{
			throw new AssertionError();
		}
		int count = 0;
		for(int i=0 ; i<inputArray.length-1 ; i++)
		{
			if(i==0 && inputArray[i]==inputArray[i+1])
			{
				count++;
			}
			else if(inputArray[i]==inputArray[i+1] && inputArray[i]!=inputArray[i-1])
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * This method returns an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
	 * Do not move X within array, but every other number may move.
	 * @param inputArray , integer type array
	 * @param X, integer type value of X 
	 * @param Y, integer type value of Y
	 * @return inputArray, integer type array result
	 */
	public static int[] fixXY(int[] inputArray, int X, int Y)
	{
		int lengthInput = inputArray.length;
		int noOfX = 0 , noOfY = 0;
		for(int i=0 ; i<inputArray.length ; i++)
		{
			if(inputArray[i]==X)
				noOfX++;
			else if(inputArray[i]==Y)
				noOfY++;
		}
		if(noOfX != noOfY || lengthInput == 0 || inputArray[inputArray.length-1]==X)
			throw new AssertionError();
		
		for(int i = 0 ; i<lengthInput-1 ; i++)
		{
			if(inputArray[i]==X && inputArray[i+1]==X)
				throw new AssertionError();
		}

		for( int i = 0; i< lengthInput-1; i++)
		{
			if(inputArray[i] == X && inputArray[i+1] != Y)
			{
				for( int  j = 0 ; j < lengthInput ; j++)
				{
					if(inputArray[j] == Y)
					{
						if(j>0 && inputArray[j-1] == X)
						{
							continue;
						}
						int temp;
						temp = inputArray[i+1];
						inputArray[i+1] = inputArray[j];
						inputArray[j] = temp;
						break;
					}
				}
			}
		}
		return inputArray;
	}
	
	/**
	 * This method returns the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1.
	 * @param inputArray, integer type array
	 * @return integer type result
	 */
	public static int splitArray(int[] inputArray)
	{
		int size = inputArray.length;
		if(size == 0)
		{
			throw new AssertionError();
		}
		int result = -1;
		int left=0 , right=0;
		for(int i=0 ; i<inputArray.length-1 ; i++)
			left += inputArray[i];
		for(int j=inputArray.length-1 ; j>0 ; j--)
		{
			right += inputArray[j];
			if(left != right)
			{
				left -= inputArray[j-1];
			}
			else
				return j;
		}
		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		/*int x=sc.nextInt();
		int[] arr = new int[x];
		for(int i=0 ; i<x ; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		System.out.println(clumpsMethod(arr));*/
		
		
		/*System.out.println("Enter X");
		int X = sc.nextInt();
		System.out.println("Enter Y");
		int Y = sc.nextInt();
		System.out.println("Enter array Size");
		int size = sc.nextInt();
		int[] arr = new int[size];
		//int[] ar = new int[size];
		for(int i=0 ; i<size ; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		try
		{
			 arr = fixXY(arr, X, Y);
		}catch(AssertionError ae)
		{
			System.out.println("Error");
		}
		for(int i=0 ; i<size ; i++)
		{
			System.out.println(arr[i]);
		}*/
		
		
		/*//int[] arr = {1,1,1,2,1};
		System.out.println("Enter array Size");
		int size = sc.nextInt();
		int[] arr = new int[size];
		//int[] ar = new int[size];
		for(int i=0 ; i<size ; i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i=0 ; i<size ; i++)
		{
			syso
		}
		System.out.println("Result : " + splitArray(arr));*/
		
		
		
		//sc.close();

	}

}

