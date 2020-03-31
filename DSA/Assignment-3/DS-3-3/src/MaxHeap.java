import java.util.*;

/**
 * @author Anjali
 *
 */
public class MaxHeap 
{
	
	Bowler[] heap ;
	int size;
	int maxsize;

	/**
	 * To initialize heap.
	 * @param maxsize represents maximum size of heap.
	 */
	public MaxHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = -1;
		heap = new Bowler[this.maxsize ];
	}
	
	/**
	 * To add a bowler to heap
	 * @param bowler is the bowler
	 */
	public void add(Bowler[] bowler)
	{
		try{
			for(Bowler b : bowler)
			{
				heap[++size] = b; 
				int current = size; 
				while (heap[current].noOfBalls > heap[parent(current)].noOfBalls)
				{ 
					swap(current, parent(current)); 
					current = parent(current); 
				} 
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * To find parent of a given node
	 * @param position of node
	 * @return parent position
	 */
	private int parent(int position){
		return position/2;
	}
	
	/**
	 * To swap elements
	 * @param a First Element
	 * @param b Second Element
	 */
	private void swap(int a, int b){
		Bowler temp;
		temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	/**
	 * To remove a bowler from heap
	 * @param quotaVirat is number of balls Virat is going to play.
	 * @return bowler removed
	 */
	public List<String> extractMax(int quotaVirat)
	{
		try
		{
			List<String> order = new ArrayList<String>();
			while(quotaVirat != 0)
			{
				Bowler max = heap[0];
				heapify(0);
				max.noOfBalls--;
				quotaVirat--;
				order.add(max.name);        
				Bowler[] bowlerN = new Bowler[size];
				for(int i = 0; i < size ; i++)
				{
					bowlerN[i] = heap[i];
				}

				size = -1;
				add(bowlerN);
			}

			return order;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * To heapify the heap 
	 * @param position of node
	 */
	public void heapify(int position){
		try{
			if(isLeaf(position))
			{
				return;
			}
			if(heap[position].noOfBalls < heap[leftChild(position)].noOfBalls ||
					heap[position].noOfBalls < heap[rightChild(position)].noOfBalls )
			{
				if(heap[leftChild(position)].noOfBalls > heap[rightChild(position)].noOfBalls)
				{
					swap(position, leftChild(position));
					heapify(leftChild(position));
				}
				else
				{
					swap(position, rightChild(position));
					heapify(rightChild(position));
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * To find whether given node is leaf
	 * @param position of node
	 * @return true or false accordingly
	 */
	private boolean isLeaf(int position)
	{
		if (position >= (size / 2) && position <= size)
		{ 
			return true; 
		} 

		return false; 
	}
	
	/**
	 * To find left Child of a given node
	 * @param position of node
	 * @return left Child position
	 */
	private int leftChild(int position)
	{
		return (2*position + 1);
	}

	/**
	 * To find right Child of a given node
	 * @param position of node
	 * @return right Child position
	 */
	private int rightChild(int position)
	{
		return (2*position + 2);
	}
	
	public static void main(String args[]) 
	{
		MaxHeap heap = new MaxHeap(5); 
		Bowler[] bowler = new Bowler[5];
		bowler[0] = new Bowler("B1", 1);
		bowler[1] = new Bowler("B2", 2);
		bowler[2] = new Bowler("B3", 3);
		bowler[3] = new Bowler("B4", 4);
		bowler[4] = new Bowler("B5", 1);
		heap.add(bowler);
		System.out.println(heap.extractMax(4));
	}
	
}
