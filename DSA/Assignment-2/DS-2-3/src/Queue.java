/**
 * @author Anjali
 * This class is used to store student for counseling in FIFO order
 */
public class Queue 
{
	
	private static int front = -1, rear = -1, maxSize=100;
	private static Student student[] = new Student[100];

	/**
	 * This adds new student to queue
	 * @param item new student for counseling
	 * @return true if added successfully
	 */
	static boolean enQueue(Student item) 
	{
		if (checkOverflow())
			return false;
		else {
			if (rear == front && front == -1) {
				front = 0;
				student[++rear] = item;
			}
			else{
				student[++rear] = item;
			}
			return true;
		}
	}

	/**
	 * This function deletes student from queue
	 * @return student object which is deleted from queue
	 */
	static Student deQueue() 
	{
		if (checkUnderflow())
			return null;
		else 
		{
			Student item = student[front];
			if (rear == front) 
			{
				rear = -1;
				front = -1;
			}
			else
				front++;

			return item;
		}
	}

	/**
	 * This function checks the overflow condition for queue
	 * @return true if overflow
	 */
	static boolean checkOverflow() 
	{
		if ((rear + 1) % maxSize == front)
		{
			System.out.println("Overflow");
			return true;
		}
		return false;
	}

	/**
	 * This function checks for underflow condition for queue
	 * @return true if underflow
	 */
	static boolean checkUnderflow() 
	{
		if (front == rear && rear == -1 && front==-1)
		{
			System.out.println("Underflow");
			return true;
		}
		return false;
	}
	
}
