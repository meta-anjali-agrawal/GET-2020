import static org.junit.Assert.*;
import org.junit.Test;

public class MarksheetTest
{
	@Test
	public void gradeAverageMethodTest()
	{
		double result = Marksheet.gradeAverageMethod(new double[]{10,20,50,90}, 4);
		assertEquals(42.5, result, 2);
	}
	
	@Test
	public void maxGradeMethodTest()
	{
		double result = Marksheet.maxGradeMethod(new double[]{10,20,50,90});
		assertEquals(90, result, 2);
	}
	
	@Test
	public void minGradeMethodTest()
	{
		double result = Marksheet.minGradeMethod(new double[]{10,20,50,90});
		assertEquals(10, result, 2);
	}
	
	@Test
	public void percentagePassedStudentMethodTest()
	{
		double result = Marksheet.percentagePassedStudentMethod(new double[]{10,20,50,90});
		assertEquals(50, result, 2);
	}
}
