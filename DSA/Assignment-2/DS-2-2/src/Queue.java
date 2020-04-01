/**
 * @author Anjali
 * Queue class extends Oueue Interface for circular queue implementation using array
 */
public class Queue implements QueueInterface
{
	
	private static int front = -1, rear = 0, capacity; 
	private static int[] queue; 
	
	public int[] getQueue() {
		return queue;
	}

	public static void setQueue(int[] queue) {
		Queue.queue = queue;
	}

	/**
	 * Constructor
	 * @param capacity is the limit of queue
	 */
	Queue(int capacity) 
	{  
		this.capacity = capacity; 
		queue = new int[this.capacity]; 
	}
	
	/**
	 * This function is used to add item in queue
	 * @param data to be added
	 * @return true if successfully added
	 */
	public boolean enqueue(int data) 
	{ 
		if(data == -1)
		{
			System.out.println("-1 is not valid");
			return false;
		}
		else if(checkOverflow())
		{  
			return false; 
		} 
		else if(front == -1)
		{
			front = rear = 0; 
			queue[rear] = data; 
		}
		else if (rear == capacity-1 && front != 0) 
		{ 
			rear = 0; 
			queue[rear] = data; 
		}
		else 
		{ 
			rear++;
			queue[rear] = data;  
		} 
		return true; 
	} 
	
	/**
	 * This function is used to delete the item from queue
	 * @return deleted item
	 */
	public int dequeue() 
	{ 
		if(checkUnderflow())
		{ 
			return -1; 
		} 
		int temp = queue[front];
		queue[front] = -1;
		if (front == rear) 
		{ 
			front = -1; 
			rear = -1; 
		} 
		else if (front == capacity-1) 
			front = 0; 
		else
			front++;
		return temp;
	} 
	
	/**
	 * This function checks for underflow
	 * @return true if underflow
	 */
	public boolean checkUnderflow()
	{
		if(front == -1)
		{
			System.out.println("Underflow"); 
			return true; 
		}
		return false;
	}
	
	/**
	 * This function checks for underflow
	 * @return true if overflow
	 */
	public boolean checkOverflow()
	{

		if ((front == 0 && rear == capacity -1) || (rear == (front-1)%(capacity -1))) 
		{ 
			System.out.println("Qverflow"); 
			return true; 
		} 
		return false;
	}
	
}
