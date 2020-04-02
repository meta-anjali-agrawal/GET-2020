/**
 * Queue Interface
 * @author Anjali
 */
public interface QueueInterface 
{
	/**
	 * This function is used to add item in queue
	 * @param data to be added
	 * @return true if successfully added
	 */
	boolean enqueue(int data);

	/**
	 * This function is used to delete the item from queue
	 * @return deleted item
	 */
	int dequeue();

	/**
	 * This function checks for underflow
	 * @return true if underflow
	 */
	boolean checkUnderflow();

	/**
	 * This function checks for underflow
	 * @return true if overflow
	 */
	boolean checkOverflow();
}
