/**
 * Priority Queue Class
 * @author Anjali
 *
 */
public class PriorityQueue 
{
	private static int pQueue[] = new int[4];
	private static int size;
	
	/**
	 * To check full
	 * @return true if full
	 */
	private static boolean isFull() 
	{
		if (size == pQueue.length)
			return true;
		return false;
	}

	/**
	 * To add new element as per priority in queue
	 * @param data to be added
	 */
	static void enqueue(int data) 
	{
		if (isFull())
			System.out.println("queue is full");
		else{
			int i;
			for (i=size-1; i>=0; i--)
			{
				if (data > pQueue[i])
					pQueue[i+1] = pQueue[i];
				else
					break;
			}
			pQueue[i+1] = data;
			size++;
		}
	}
	
	/**
	 * To check if empty
	 * @return true if empty
	 */
	private static boolean isEmpty() 
	{
		if (size == 0)
			return true;
		return false;
	}
	
	/**
	 * To remove top element from queue
	 * @return top element
	 */
	static int dequeue()
	{
		if (isEmpty())
		{
			System.out.println("queue is empty");
			return 0;
		}
		else
			return pQueue[--size];
	}
	
	/**
	 * To display the queue
	 */
	static void display() {
		for (int i=0; i<size; i++)
			System.out.print("->" +pQueue[i]);
	}

	public static void main(String[] args)
	{
		enqueue(1);
		enqueue(2);
		enqueue(30);
		enqueue(4);
		//enqueue(50);
		display();
		System.out.println();
		System.out.println("dequeue " +dequeue());
		System.out.println("dequeue " +dequeue());
		enqueue(6);
		enqueue(7);
		//enqueue(8);
		display();
	}

}
