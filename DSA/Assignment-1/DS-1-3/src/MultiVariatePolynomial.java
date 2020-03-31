/**
 * 
 * @author Anjali
 * MultivariatePolynomial class which contains method to find the degree of multivariant polynomial
 */
public class MultiVariatePolynomial 
{
	
	public PolyNode head;
	/**
	 * Method to insert polynomial in Polynode as a nested list
	 * @param list : linked list which is to be added
	 */
	public void insertPolynomial(int coefficient, LinkedList list){
		PolyNode newPolyNode = new PolyNode(coefficient, list);
		if(head == null) {
			//newPolyNode.setCoefficient(coefficient);
			//newPolyNode.setPolynomialData(list);
			head = newPolyNode;
		}
		else{
			PolyNode current = head;
			while(current.getNextPolyNode() != null){
				current = current.getNextPolyNode(); 
			}
			current.setNextPolyNode(newPolyNode);
			//newPolyNode.polynomialData = list;
		}
	}
	/**
	 * Method to find the maximum degree in multivariant polynomial
	 * @return : maximum degree
	 */
	public int findDegree() {
		if(head == null){
			return 0;
		}
		PolyNode tempPolyHead = head;
		int max = -1;
		while(tempPolyHead != null) {
			int sum = 0;
			Node tempHead = tempPolyHead.getPolynomialData().listHead;
			while(tempHead != null){
				sum = sum + tempHead.getExponent();
				tempHead = tempHead.getNext();
			}
			if(sum > max){ 
				max = sum;
			}
			tempPolyHead  = tempPolyHead.getNextPolyNode();
		}
		return max;
	}
	
}
