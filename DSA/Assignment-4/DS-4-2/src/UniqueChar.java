import java.util.*;

/**
 * Class to find number of unique characters in a string
 * @author Anjali
 *
 */
public class UniqueChar 
{
	
	static HashMap<String,Integer> string = new HashMap<>();
	static int noOfUniqueCharacters = 0;
	
	/**
	 * To find Unique Character in a string
	 * @param inputString
	 * @return number of unique characters
	 */
	public static int countUniqueCharacter(String inputString)
	{
		
		List<Character> charList = new ArrayList<Character>();
		for(int index = 0; index < inputString.length(); index++) 
		{
			charList.add(inputString.charAt(index));
		}
		for(int index = 0; index < inputString.length(); index++)
		{
			if(Collections.frequency(charList, inputString.charAt(index)) == 1)
			{
				noOfUniqueCharacters ++;
			}
		}
		string.put(inputString, noOfUniqueCharacters);
		return noOfUniqueCharacters;
	}
	
}
