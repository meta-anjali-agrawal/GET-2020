/**
 * 
 * @author Anjali
 * This class is to implement Linear Search and Binary Search using recursion
 */
public class Search
{
	static int index = 0;
	static boolean flag = true;
	int lowIndex, highIndex, mid; 
	
	/**
	 * Linear search or sequential search is a method for finding a target value within an array. 
	 * It sequentially checks each element of the array for the target value until a match is found or until all the elements have been searched.
	 * @param inputArray , integer type array
	 * @param element, which needs to be search inside the array
	 * @return index at which element is found else -1
	 */
	public static int linearSearchMethod(int[] inputArray, int element)
	{
		if(inputArray[index]==element)
			return index+1;
		else if(index == inputArray.length-1)
			return -1;
		else
			index++;
		return linearSearchMethod(inputArray, element);
	}
	
	/**
	 * Binary search is a search algorithm that finds the position of a target value within a sorted array.
	 * Binary search compares the target value to the middle element of the array.
	 * If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half, 
	 * again taking the middle element to compare to the target value, and repeating this until the target value is found.
	 * @param inputArray , integer type array
	 * @param element, which needs to be search inside the array
	 * @return index at which element is found else -1
	 */
	public int binarySearchMethod(int[] inputArray, int element)
	{
		if(flag)
		{
			lowIndex = 0;
			highIndex = inputArray.length-1;
		}
		flag = false;
		mid = (lowIndex + highIndex)/2;
		if(inputArray[mid] == element)
			return mid+1;
		else if(highIndex == lowIndex)
			return -1;
		else
		{
			if(inputArray[mid] < element)
				lowIndex = mid + 1;
			else if(inputArray[mid] > element)
				highIndex = mid -1;
		}
		return binarySearchMethod(inputArray, element);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*int result = linearSearchMethod(new int[]{4,1,2,3,44,5,6,0}, 4);
		System.out.println(result);

		Search s = new Search();
		int result1 = s.binarySearchMethod(new int[]{0,1,2,3,4,5,6,8,9,10,12}, 4);
		System.out.println(result1);*/
	}

}
