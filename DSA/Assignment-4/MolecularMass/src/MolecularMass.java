/**
 * Class to calculate Molecular Mass of a given organic Compound 
 * @author Anjali
 *
 */
public class MolecularMass 
{
	
	static int noOfH = 0, noOfC = 0, noOfO = 0;
	
	/**
	 * To calculate number of C, H and O
	 * @param str, Input String
	 * @param value
	 */
	static void mass(String str, int value) 
	{
		int i=0; 
		while (i < str.length())
		{
			char ch = str.charAt(i);
			if (ch == '(')
			{
				String subString = "";
				while (str.charAt(++i) != ')')
				{
					subString += str.charAt(i);
				}
				subString += " ";
				if (Character.isDigit(str.charAt(++i)))
				{
					int value1 = Integer.parseInt("" + str.charAt(i++));
					mass(subString, value1);
				}
				else
					mass(subString, value);
				ch = str.charAt(i);
			}

			if (ch == 'C')
			{
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					noOfC += (Integer.parseInt("" + str.charAt(i+1)))*value;
				else
					noOfC += 1*value;
			}
			if (ch == 'O')
			{
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					noOfO += (Integer.parseInt("" + str.charAt(i+1)))*value;
				else
					noOfO += 1*value;
			}
			if (ch == 'H')
			{
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					noOfH += (Integer.parseInt("" + str.charAt(i+1)))*value;
				else
					noOfH += 1*value;
			}
			i++;
		}
	}
	
	/**
	 * To finally calculate molecular mass using their mass
	 * @param string, input compound
	 * @return mass of compound
	 */
	static int calculateMass(String string)
	{
		mass(string+" ", 1);
		int massOfCarbon=12, massOfHydrogen=1, massOfOxygen=16;
		return (massOfCarbon*noOfC + massOfHydrogen*noOfH + massOfOxygen*noOfO);
	}

	
	public static void main(String[] args)
	{
		String compound = "CH2(CO)4";
		System.out.println("molecular mass of compound is: "+ calculateMass(compound));
	}
	
}
