/**
 * @author Anjali
 * @date 16-01-2020
 * class Marksheet, which reads in grades of n no of students. 
 * Assume n as a positive integer and grades will be between 0 and 100 both inclusive.
 * Average of all grades. 
 * Maximum of all grades.
 * Minimum of all grades.
 * Percentage of students passed. (Assume grade >= 40 as Pass)
 */
import java.text.DecimalFormat;
import java.util.*;

public class Marksheet
{
	/**
	 * Method to find Average of all Grades
	 * @param grades, is a parameter of double type array 
	 * @param noOfStudent, is a parameter of int type
	 * @return gradeAverage, of double type
	 * @throws ArithmeticException, to handle arithmetic Exceptions 
	 */
	public static double gradeAverageMethod(double[] grades, int noOfStudent) throws ArithmeticException
	{
		//To find average of all the grades
		double gradeAverage = 0;
		for(int i=0 ; i<grades.length ; i++)
		{
			gradeAverage += grades[i];
		}
		gradeAverage = gradeAverage/noOfStudent;
		return gradeAverage;
	}
	
	/**
	 * Method to find Maximum Grade of all Grades
	 * @param grades, is a parameter of double type array 
	 * @return maxGrade, MAximun Grade of double type
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double maxGradeMethod(double[] grades) throws ArithmeticException
	{
		//To find maximum grade
		double maxGrade = 0;
		for(int i=0 ; i<grades.length ; i++)
		{
			if(grades[i]>maxGrade)
				maxGrade = grades[i];
		}
		return maxGrade;
	}
	
	/**
	* Method to find Minimum Grade of all Grades
	 * @param grades, is a parameter of double type array
	 * @return minGrade, of double type
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double minGradeMethod(double[] grades) throws ArithmeticException
	{
		//To find maximum grade
		double minGrade = 110;
		for(int i=0 ; i<grades.length ; i++)
		{
			if(grades[i]<minGrade)
				minGrade = grades[i];
		}
		return minGrade;
	}
	/**
	 * Method to find percentage of Students Passed
	 * @param grades, is a parameter of double type array
	 * @return percentage, double type
	 * @throws ArithmeticException, to handle arithmetic Exceptions
	 */
	public static double percentagePassedStudentMethod(double[] grades) throws ArithmeticException
	{
		//To find percentage of Students who are pass
		double percentage = 0;
		double passingMarks = 40;
		for(int i=0 ; i<grades.length ; i++)
		{
			if(grades[i]>=passingMarks)
				percentage++;
		}
		percentage = (percentage/grades.length)*100;
		return percentage;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00");
		
		System.out.println("Enter number of Students : ");
		int noOfStudent = sc.nextInt();
		double[] grades = new double[noOfStudent];
		
		if(noOfStudent<=0)
		{
			System.out.println("You didn't entered Positive Value.");
		}
		else
		{
			for(int i=0 ; i<noOfStudent ; i++)
			{
				System.out.println("Grade of Student " + (i+1));
				grades[i] = sc.nextDouble();
				if(!(grades[i]>=0 && grades[i]<=100))
				{
					System.out.println("Please Enter grade between 0 to 100.");
					i--;
				}
			}
			
			System.out.println("Average of Grades : " + df.format(gradeAverageMethod(grades, noOfStudent)));
			System.out.println("Maximum of all Grades : " + df.format(maxGradeMethod(grades)));
			System.out.println("Minimum of all Grades : " + df.format(minGradeMethod(grades)));
			System.out.println("Percentage of student passed : " + df.format(percentagePassedStudentMethod(grades)));
		}
		
		sc.close();
	}

}
