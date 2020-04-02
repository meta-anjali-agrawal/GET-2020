/**
 * Node class
 * @author Anjali
 *
 */
public class Node
{
	private String string;
	private int exponent;
	private Node next;
	
	Node(String string, int exponent)
	{
		this.string = string;
		this.exponent = exponent;
		this.next = null;
	}
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
