/**
 * 
 * @author Anjali
 * This class holds the functionalities of linked list
 */
public class LinkedList {

	private Node head = null;
	private int linkedListSize = 0;
	
	/**
	 * To get Head of LinkedList
	 * @return head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * To set Head of LinkedList
	 * @param head
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * To get size of LinkedList
	 * @return size of linked list
	 */
	public int getLinkedListSize() {
		return linkedListSize;
	}

	/**
	 * To add new node in list	
	 * @param data of node
	 */
	public void insertElement(int data)
	{
		Node node = new Node(data);
		if(head == null) {
			head = node;
		}
		else {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
		linkedListSize++;
	}
	
	/**
	 * To add new node in list 
	 * @return true, if in loop , else false.
	 */
	public boolean checkLoop() {
		if(head == null){
			return false;
		}
		Node temp1 = head;
		Node temp2 = head;
		
		while(temp1.getNext() != null && temp2.getNext() != null && temp2.getNext().getNext() != null){
			temp1 = temp1.getNext();
			temp2 = temp2.getNext().getNext();
			if(temp1 == temp2){
				return true;
			}
		}
		return false; 
	}
	
	
}
