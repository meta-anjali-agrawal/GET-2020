/**
 * 
 * @author Anjali
 * LinkedList class
 * contains method to store node in a linkedlist
 */
public class LinkedList 
{
	Node listHead;
	/**
	 * Method to insert node in a linked list
	 * @param string : string of polynomial
	 * @param degree : degree of polynomial
	 */
	public void insertNode(String string, int degree) 
	{ 
		Node newNode = new Node(string, degree);
		if (listHead == null) { 
			listHead = newNode; 
		} 
		else { 
			Node current = listHead; 
			while (current.getNext() != null) { 
				current = current.getNext(); 
			} 
			current.setNext(newNode); 
		} 
	} 
}
