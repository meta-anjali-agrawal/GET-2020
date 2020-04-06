/**
 * 
 * @author Anjali
 * This class holds the functionalities of linked list
 */
public class LinkedList {

	private static Node head = null;
	private static int linkedListSize = 0;
	
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
	 * To print the Linked List
	 */
	public void printList() {
		Node current = head;
		
		while(current.getNext() != null) {
			System.out.print(current.getData() + "-> ");
			current = current.getNext();
		}
		System.out.print(current.getData());
	}
	
	/**
	 * To rotate Sublist
	 * @param leftPosition of Sublist
	 * @param rightPosition of Sublist
	 * @param noOfSteps to rotate
	 * @return
	 */
	public boolean rotateSubList(int leftPosition, int rightPosition, int noOfSteps) {
		
		if(head == null || linkedListSize < leftPosition || linkedListSize < rightPosition || rightPosition < leftPosition){
			return false;
		}
		if(noOfSteps == rightPosition-leftPosition+1 || rightPosition == leftPosition){
			return true;
		}
		
		Node leftPointer, rightPos, rightPointer, shiftPos, temp=head;
		int counter = 1;
		
		while(counter != leftPosition-1) {
			temp = temp.getNext();
			counter++;
		}
		leftPointer = temp;
		
		while(counter != leftPosition+noOfSteps-1) {
			temp = temp.getNext();
			counter++;
		}
		rightPointer = temp;
		shiftPos = rightPointer.getNext();
		
		while(counter != rightPosition) {
			temp = temp.getNext();
			counter++;
		}
		rightPos = temp;
		
		rightPointer.setNext(rightPos.getNext());
		rightPos.setNext(leftPointer.getNext());
		leftPointer.setNext(shiftPos);
		
		return true;
	}
	
	public static void main(String args[]) {
		
		LinkedList lList = new LinkedList();
		lList.insertElement(2);
		lList.insertElement(3);
		lList.insertElement(4);
		lList.insertElement(5);
		lList.insertElement(6);
		lList.insertElement(7);
		lList.printList();
		boolean result = lList.rotateSubList(2, 5, 2);
		System.out.println(result);
		System.out.println();
		lList.printList();
		
	}
	
}
