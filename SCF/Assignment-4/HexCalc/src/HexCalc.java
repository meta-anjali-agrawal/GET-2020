/**
 * @author Anjali
 * @date = 15-01-2020
 * Class HexCalc that supports methods for hexadecimal arithmetic.
 * Methods to add, subtract, multiply and divide two hexadecimal numbers.
 * Methods to compare two hexadecimal numbers for ==, > and <.
 * Returns the decimal representation of hexadecimal number.
 * Returns the hexadecimal representation of decimal number.
 */

import java.util.*;
import java.lang.Math;
import java.lang.String;

interface Calc
{
	String add(String value1, String value2);
	String subtract(String value1, String value2);
	String multiply(String value1, String value2);
	String divide(String value1, String value2);
	int hexadecimalToDecimal(String hexValue);
	String decimalToHexadecimal(int decValue);
}

public class HexCalc implements Calc
{
	/**
	 * To add two hexadecimal String and return result in hexadecimal String
	 * @param value1, first hexadecimal number in String 
	 * @param value2, second hexadecimal number in string
	 * @return finalResult, addition of two hexadecimal number passed as parameters
	 */
	public String add(String value1, String value2)
	{
		if(!(checkHexadecimal(value1) && checkHexadecimal(value2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			int number1 = hexadecimalToDecimal(value1);
			int number2 = hexadecimalToDecimal(value2);
			int result;
			result = number1 + number2;
			String finalResult = decimalToHexadecimal(result);
			return finalResult;
		}
		return "0";
	}
	
	/**
	 * To subtract two hexadecimal String and return result in hexadecimal String
	 * @param value1, first hexadecimal number in String 
	 * @param value2, second hexadecimal number in string
	 * @return finalResult, subtraction of two hexadecimal number passed as parameters
	 */
	public String subtract(String value1, String value2)
	{
		if(!(checkHexadecimal(value1) && checkHexadecimal(value2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			int number1 = hexadecimalToDecimal(value1);
			int number2 = hexadecimalToDecimal(value2);
			String finalResult = "";
			int result;
			
			if(number1<number2)
			{
				result = number2 - number1;
				finalResult = "-" + decimalToHexadecimal(result);
			}
			else
			{
				result = number1 - number2;
				finalResult = decimalToHexadecimal(result);
			}
			return finalResult;
		}
		return "0";
	}
	
	/**
	 * To multiply two hexadecimal String and return result in hexadecimal String
	 * @param value1, first hexadecimal number in String 
	 * @param value2, second hexadecimal number in string
	 * @return finalResult, multiplication of two hexadecimal number passed as parameters
	 */
	public String multiply(String value1, String value2)
	{
		if(!(checkHexadecimal(value1) && checkHexadecimal(value2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			int number1 = hexadecimalToDecimal(value1);
			int number2 = hexadecimalToDecimal(value2);
			int result;
			result = number1 * number2;
			String finalResult = decimalToHexadecimal(result);
			return finalResult;
		}
		return "0";
	}
	
	/**
	 * To divide two hexadecimal String and return result in hexadecimal String
	 * @param value1, first hexadecimal number in String 
	 * @param value2, second hexadecimal number in string
	 * @return finalResult, division of two hexadecimal number passed as parameters
	 */
	public String divide(String value1, String value2)
	{
		if(!(checkHexadecimal(value1) && checkHexadecimal(value2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			int number1 = hexadecimalToDecimal(value1);
			int number2 = hexadecimalToDecimal(value2);
			int quotient = 0, remain;
			String remainder, finalResult;
			try 
			{
				quotient = number1 / number2;
			} 
			catch (ArithmeticException e) 
			{
				System.out.println("You should not divide a number by Zero.");
				System.exit(0);
			}
			remain = number1 - (quotient*number2);
			remainder = decimalToHexadecimal(remain);
			System.out.println("Remainder : " + remainder);
			if(quotient == 0)
				finalResult = "0";
			else
				finalResult = decimalToHexadecimal(quotient);
			return finalResult;
		}
		return "0";
	}
	
	/**
	 * To convert hexadecimal String into int decimal
	 * @param hexValue, hexadecimal number in String 
	 * @return result, after conversion into decimal value
	 */
	public int hexadecimalToDecimal(String hexValue)
	{
		//To convert hexadecimal value  to decimal value
		if(!(checkHexadecimal(hexValue)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			char hexa;
			int number=0, result =0;
			int exponent=0, hex=16;
			int power;
			for(int i=hexValue.length()-1 ; i>=0 ; i--)
			{
				hexa = hexValue.charAt(i);
				if(hexa=='0' || hexa=='1' || hexa=='2' || hexa=='3' || hexa=='4' || hexa=='5' || hexa=='6' || hexa=='7' || hexa=='8' ||  hexa=='9')
				{
					number = Integer.parseInt(String.valueOf(hexa));
				}
					
				
				else
				{
					switch(hexa)
					{
						case 'A' :
						case 'a' :
							number = 10;
							break;
						case 'B' :
						case 'b' :
							number = 11;
							break;
						case 'C' :
						case 'c' :
							number = 12;
							break;
						case 'D' :
						case 'd' :
							number = 13;
							break;
						case 'E' :
						case 'e' :
							number = 14;
							break;
						case 'F' :
						case 'f' :
							number = 15;
							break;
						default:
							System.out.println("OOPS!!! You entered an invalid hexadecimal number");
							System.exit(0);
							break;
					}
				}
				
				power = (int)Math.pow(hex,exponent);
				result = result + (number*(power));
				exponent++;
			}
			return result;
		}
		return 0;

	}
	
	/**
	 * To convert decimal number into hexadecimal String
	 * @param hexValue, decimal number in integer
	 * @return result, after conversion into hexadecimal String
	 */
	public String decimalToHexadecimal(int decValue)
	{
		//To convert decimal value  to hexadecimal value
		String result = "";
		int value = 0;
		while(decValue>0)
		{
			value = decValue%16;
			decValue = decValue/16;
			if(value>=0 && value<=9)
			{
				result = Integer.toString(value) + result;
			}
			else
			{
				switch(value)
				{
					case 10:
						result = 'A' + result;
						break;
					case 11:
						result = 'B' + result;
						break;
					case 12:
						result = 'C' + result;
						break;
					case 13:
						result = 'D' + result;
						break;
					case 14:
						result = 'E' + result;
						break;
					case 15:
						result = 'F' + result;
						break;
					default:
						break;
				}
			}
		}
		return result;
	}
	
	static Boolean checkHexadecimal(String hexValue)
	{
		//to check whether a number is hexadecimal or not
		for(int i=0 ; i<hexValue.length() ; i++)
		{
			if(!((hexValue.charAt(i)>='0' && hexValue.charAt(i)<='9') || (hexValue.charAt(i)>='A' && hexValue.charAt(i)<='F') || (hexValue.charAt(i)>='a' && hexValue.charAt(i)<='f')))
				return false;
		}
		return true;
	}
	
	static String perfectValueMethod(String value)
	{
		//Remove zeros from starting of any hexadecimal value
		while(value.charAt(0)=='0')
		{
			value = value.substring(1);
		}
		return value;
	}
	
	static Boolean hexEqual(String hexVal1, String hexVal2)
	{
		//To check whether two hexadecimal is equal or not 
		if(!(checkHexadecimal(hexVal1) && checkHexadecimal(hexVal2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			//System.exit(0);
			return false;
		}
		else
		{
			hexVal1 = perfectValueMethod(hexVal1);
			hexVal2 = perfectValueMethod(hexVal2);
			if(hexVal1.length()!=hexVal2.length())
			{
				return false;
			}
			else
			{
				for(int i=0 ; i<hexVal1.length() ; i++)
				{
					if(hexVal1.charAt(i)!=hexVal2.charAt(i))
						return false;
				}
			}
		}
		return true;
	}
	
	static Boolean hexGreaterThan(String hexVal1, String hexVal2)
	{
		//To check whether first hexadecimal is greater than the next or not
		if(!(checkHexadecimal(hexVal1) && checkHexadecimal(hexVal2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			hexVal1 = perfectValueMethod(hexVal1);
			hexVal2 = perfectValueMethod(hexVal2);
			if(hexVal1.length() < hexVal2.length())
				return false;
			else if(hexVal1.length() == hexVal2.length())
			{
				for(int i=0 ; i<hexVal1.length() ; i++)
				{
					if(hexVal1.charAt(i)<hexVal2.charAt(i))
						return false;
				}
			}
		}
		return true;
	}
	
	static Boolean hexLessThan(String hexVal1, String hexVal2)
	{
		//To check whether first hexadecimal is less than the next or not 
		if(!(checkHexadecimal(hexVal1) && checkHexadecimal(hexVal2)))
		{
			System.out.println("You didnot entered Hexadecimal Value");
			System.exit(0);
		}
		else
		{
			hexVal1 = perfectValueMethod(hexVal1);
			hexVal2 = perfectValueMethod(hexVal2);
			if(hexVal1.length() > hexVal2.length())
				return false;
			else if(hexVal1.length() == hexVal2.length())
			{
				for(int i=0 ; i<hexVal1.length() ; i++)
				{
					if(hexVal1.charAt(i)>hexVal2.charAt(i))
						return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HexCalc hc = new HexCalc();
		String result = "", value1="", value2 = "";
		int operation;
		Boolean compareResult;
		
		do
		{
			System.out.println("Select the operation you want to perform:");
			System.out.println("1.Add hexadecimal values");
			System.out.println("2.Subtract hexadecimal values");
			System.out.println("3.Multiply hexadecimal values");
			System.out.println("4.Divide hexadecimal values");
			System.out.println("5.Compare, if hexadecimal values are equal");
			System.out.println("6.Compare, if first hexadecimal value is greater than second one.");
			System.out.println("7.Compare, if first hexadecimal value is lesser than second one.");
			System.out.println("8.Convert hexadecimal values to decimal values.");
			System.out.println("9.Convert decimal value to hexadecimal value.");
			System.out.println("10.Exit");
			operation = sc.nextInt();
			
			if(operation>0 && operation<9)
			{
				System.out.println("Enter two hexadecimal Values");
				value1 = sc.next();
				value2 = sc.next();
			}
			
			switch(operation)
			{
				case 1:
					result = hc.add(value1, value2);
					System.out.println("Result(Hexadecimal) : " + result);
					break;
				case 2:
					result = hc.subtract(value1, value2);
					System.out.println("Result(Hexadecimal) : " + result);
					break;
				case 3:
					result = hc.multiply(value1, value2);
					System.out.println("Result(Hexadecimal) : " + result);
					break;
				case 4:
					result = hc.divide(value1, value2);
					System.out.println("Result(Hexadecimal) : " + result);
					break;
				case 5:
					compareResult = hexEqual(value1, value2);
					if(compareResult)
					{
						System.out.println(value1 + " is equal to " + value2);
					}
					else
						System.out.println(value1 +" is not equal to " + value2);
					
					break;
				case 6:
					compareResult = hexGreaterThan(value1, value2);
					if(compareResult)
					{
						System.out.println(value1 + " is greater than " + value2);
					}
					else
						System.out.println(value1 +" is not greater than " + value2);
					
					break;
				case 7:
					compareResult = hexLessThan(value1, value2);
					if(compareResult)
					{
						System.out.println(value1 + " is less than " + value2);
					}
					else
						System.out.println(value1 +" is not less than " + value2);
					
					break;
				case 8:
					int number1 = hc.hexadecimalToDecimal(value1);
					int number2 = hc.hexadecimalToDecimal(value2);
					System.out.println("1st hexadecimal value to decimal : " + number1);
					System.out.println("2nd hexadecimal value to decimal : " + number2);
				case 9:
					System.out.println("Enter a decimal value: ");
					int decimal = sc.nextInt();
					result = hc.decimalToHexadecimal(decimal);
					System.out.println("Hexadecimal : " + result);
					break;
				case 10:
					System.exit(0);
				default:
					System.out.println("Sorry!! You selected invalid option.");
					System.exit(0);
					break;
			}
			
			
		}while(operation!=10);
		
		
		sc.close();

	}

}
