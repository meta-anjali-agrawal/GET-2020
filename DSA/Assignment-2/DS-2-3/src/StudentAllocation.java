/**
 * @author Anjali
 * This is the POJO class of Student Allocation where student name and program preferred is stored
 */

public class StudentAllocation 
{
	
	private String studentName;
	private String programPreferred;
	
	StudentAllocation(String name, String program)
	{
		studentName = name;
		programPreferred = program;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getProgramPreferred() {
		return programPreferred;
	}
	
}
