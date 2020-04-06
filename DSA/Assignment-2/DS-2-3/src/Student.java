/**
 * @author Anjali
 * This is the POJO class of Student where program name and program preferred
 */
public class Student
{
	
	private String studentName;
	private String[] programPreferred;
	
	Student(String name, String[] program)
	{
		studentName = name;
		if(program.length>5)
		{
			throw new AssertionError("List of program should be 5");
		}
		else
		{
			programPreferred = program;
		}
	}

	public String getStudentName() {
		return studentName;
	}

	public String[] getProgramPreferred() {
		return programPreferred;
	}
	
}
