/**
 * @author Anjali
 * @date 16-01-2020
 * Class Area to calculate areas for different shapes.
 * Method to return area of a Triangle.
 * Method to return area of a Rectangle.
 * Method to return area of a Square.
 * Method to return area of a Circle.
 * Assuming that height, width and radius will be greater than zero.
 */
import java.util.*;

public class Area 
{
	/**
	 * Method to return area of a Triangle.
	 * @param width, as double
	 * @param height, as double
	 * @return area, as double
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double triangleAreaMethod(double width, double height) throws ArithmeticException
	{
		double area = (width*height)/2;
		return area;
	}
	
	/**
	 * Method to return area of a Rectangle.
	 * @param width, as double
	 * @param height, as double
	 * @return area, as double
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double rectangleAreaMethod(double width, double height) throws ArithmeticException
	{
		return width*height;
	}
	
	/**
	 * Method to return area of a Square.
	 * @param width, as double
	 * @return area, as double
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double squareAreaMethod(double width) throws ArithmeticException
	{
		return width*width;
	}
	
	/**
	 * Method to return area of a Circle.
	 * @param radius, as double
	 * @return area, as double
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double circleAreaMethod(double radius) throws ArithmeticException
	{
		return Math.PI*radius*radius;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double height=0 , width=0 , radius=0;
		int option;
		
		do
		{
			System.out.println("Find the area of : ");
			System.out.println("1. Triangle");
			System.out.println("2. Rectangle");
			System.out.println("3. Square");
			System.out.println("4. Circle");
			System.out.println("5. Exit");
			option = sc.nextInt();
			
			if(option<3 && option>0)
			{
				System.out.println("Enter height : ");
				height = sc.nextDouble();
				System.out.println("Enter width : ");
				width = sc.nextDouble();
			}
			
			switch(option)
			{
				case 1:
					System.out.println("Area of Triangle : " + triangleAreaMethod(width, height));
					break;
				case 2:
					System.out.println("Area of Rectangle : " + rectangleAreaMethod(width, height));
					break;
				case 3:
					System.out.println("Enter width : ");
					width = sc.nextDouble();
					System.out.println("Area of Square : " + squareAreaMethod(width));
					break;
				case 4:
					System.out.println("Enter radius : ");
					radius = sc.nextDouble();
					System.out.println("Area of Circle : " + circleAreaMethod(radius));
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Enter a valid option.");
					break;
			}
		}while(option!=5);
		
		sc.close();
	}

}
