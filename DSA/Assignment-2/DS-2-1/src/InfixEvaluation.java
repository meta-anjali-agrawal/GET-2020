import java.util.ArrayList;


public class InfixEvaluation 
{
	
	private String postfixExpression = "";
	private static ArrayList<String> stack = new ArrayList<String>();
	private static ArrayList<Integer> evaluateStack = new ArrayList<Integer>();
	
	/**
	 * To check the precedence of a operator
	 * @param ch to be checked
	 * @return preference
	 */
	private int precedence(String ch){
		if(ch.equalsIgnoreCase("+") || ch.equalsIgnoreCase("-"))
			return 1;
		else if(ch.equalsIgnoreCase("*") || ch.equalsIgnoreCase("/"))
			return 2;
		else if(ch.equalsIgnoreCase("^"))
			return 3;
		else
			return -1;
	}
	
	/**
	 * To separate input with space
	 * @param input to be separated
	 * @return String array
	 */
	private String[] separation(String input) 
	{
		String inputArray[] = input.split(" ");
		return inputArray;
	}
	
	/**
	 * To check whether a value is Digit or not
	 * @param value
	 * @return true if digit, else false
	 */
	private boolean isDigit(String value)
	{
		char ch;
		for(int i=0 ; i<value.length() ; i++)
		{
			ch = value.charAt(i);
			if(!Character.isDigit(ch))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Converts infix expression to postfix for evaluation
	 * @param input to converted
	 * @return true if successful conversion
	 */
	public boolean infixToPostfix(String input)
	{
		String inputArray[] = separation(input);
		int countParanthesis = 0;
		String ch;
		
		for(int i=0 ; i<inputArray.length ; i++)
		{
			ch = inputArray[i];
			if(isDigit(ch))
			{
				postfixExpression += ch + " ";
			}
			else
			{
				if(ch.equalsIgnoreCase("("))
				{
					push(ch);
					countParanthesis++;				
				}
				else if(ch.equalsIgnoreCase(")"))
				{
					while (!stack.isEmpty() && !peek().equalsIgnoreCase("("))
					{
						postfixExpression += pop() + " ";
					}
					pop();
					countParanthesis--;
				}
				else
				{
					while (!stack.isEmpty() && precedence(ch) <= precedence(peek()))
					{
						postfixExpression += pop() + " ";
					}
						
					push(ch);
				}
			}
		}
		
		while (!stack.isEmpty())
			postfixExpression += pop() + " ";

		if (countParanthesis != 0){
			System.out.println("invalid expression");
			return false;
		}
		return true;
	}
	
	/**
	 * Refers to the top element in stack
	 * @return value at top of stack
	 */
	private static String peek() {
		return stack.get(stack.size()-1);
	}
	
	/**
	 * Deletes top element from stack
	 * @return deleted element
	 */
	public static String pop() {
		String ch = peek();
		stack.remove(stack.size()-1);
		return ch;
	}

	/**
	 * Adds new element in stack
	 * @param ch to be added
	 */
	public static void push(String ch) {
		stack.add(ch);
	}
	
	/**
	 * Refers to top element in evaluateStack
	 * @return top element
	 */
	private static int peekEval() {
		return evaluateStack.get(evaluateStack.size()-1);
	}

	/**
	 * Deletes top element
	 * @return deleted value
	 */
	public static int popEval() {
		int ch = peekEval();
		evaluateStack.remove(evaluateStack.size()-1);
		return ch;
	}


	/**
	 * Adds new element to evaluateStack
	 * @param ch to be added
	 */
	public static void pushEval(int ch) {
		evaluateStack.add(ch);
	}

	/**
	 * Evaluates infix arithmetic expression
	 * @param exp to be evaluated
	 * @return result
	 */
	public int evaluate(String input) {
		infixToPostfix(input);
		System.out.println("postfix : " +  postfixExpression);
		String postfixArray[] = separation(postfixExpression);
		String ch;
		for (int i=0; i<postfixArray.length; i++){
			ch = postfixArray[i];
			if (isDigit(ch))
				pushEval(Integer.valueOf(ch));
			else{
				int value1 = popEval();
				int value2 = popEval();
				if (ch.equalsIgnoreCase("+"))
					pushEval(value1 + value2);
				else if (ch.equalsIgnoreCase("-"))
					pushEval(Math.abs(value1 - value2));
				else if (ch.equalsIgnoreCase("*"))
					pushEval(value1 * value2);
				else
					pushEval(value1 / value2);
			}
		}
		return popEval();
	}
	
}
