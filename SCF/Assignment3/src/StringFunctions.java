/**
 * @author Anjali
 * @date - 16-01-2020
 * Class that perform operations on Strings
 * Compare two strings and return 1 if equals else 0. Take two string inputs.
 * Reverse of any string.
 * Replace lowercase characters with uppercase and vice-versa.
 * The largest word of a string. If two words are of same length then return last word.
 */
import java.util.*;

public class StringFunctions 
{
	
	/**
	 * To compare two String and return 1 if equals else 0
	 * @param first, first String 
	 * @param second, second string
	 * @return 1 if equals else 0
	 */
	static int compare(String first, String second)
	{
		//Comparing two Strings
		if(first.length()!=second.length())
		{
			return 0;
		}
		else
		{
			for(int i=0 ; i<first.length() ; i++)
			{
				if(first.charAt(i)!=second.charAt(i))
					return 0;
			}
		}
		return 1;
	}
	
	/**
	 * To reverse String and return reversed String
	 * @param s, String to reverse
	 * @return s1, reversed String
	 */
	static String reverse(String s)
	{
		String s1 = "";
		for(int i=s.length()-1 ; i>=0 ; i--)
		{
			s1 = s1 + s.charAt(i);
		}
		return s1;
	}
	
	/**
	 * To compare two String and return 1 if equals else 0
	 * @param value, String to change cases 
	 * @return result, String with changed cases
	 */
	static String changeCase(String value)
	{
		String result="";
		
		for(int i=0 ; i<value.length() ; i++)
		{
			if(value.charAt(i)>='a' && value.charAt(i)<='z')
			{
				result += (char)(value.charAt(i) - 32);
			}
			else if(value.charAt(i)>='A' && value.charAt(i)<='Z')
			{
				result += (char)(value.charAt(i) + 32);
			}
			else
			{
				result += (char)(value.charAt(i));
			}
		}
		return result;
	}
	
	/**
	 * To find largest word between two Strings
	 * @param word1, first String 
	 * @param word2, second string
	 * @return largest string 
	 */
	static String largestWordMethod(String word1, String word2)
	{
		if(word1.length()>word2.length())
		{
			return word1;
		}
		return word2;
	}

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String firstString,secondString;
		int option;
		
		System.out.println("Enter the String : ");
		firstString = sc.next();
		do
		{
			System.out.println("Select the option:");
			System.out.println("1. Compare two strings.");
			System.out.println("2. Reverse any string.");
			System.out.println("3. Change case");
			System.out.println("4. Largest Word among two Strings");
			System.out.println("5. Exit");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					System.out.println("Enter Second String to compare with : ");
					secondString = sc.next();
		
					if(compare(firstString, secondString)==1)
					{
						System.out.println("Both the string are equal.");
					}
					else
						System.out.println("Strings are not equal.");
					break;
					
				case 2:
					System.out.println("Reversed String: " + reverse(firstString));
					break;
				case 3:
					System.out.println("After changing case: " + changeCase(firstString));
					break;
				case 4:
					System.out.println("Enter Second String to compare with : ");
					secondString = sc.next();
					System.out.println("Largest Word : " + largestWordMethod(firstString, secondString));
					break;
				case 5:
					sc.close();
					System.exit(0);
				default:
					System.out.println("Select a valid option");
			}
		}while(true);

	}

}
