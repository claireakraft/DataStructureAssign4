package assign4LSQ;

import support.LLNode;
/*** COSC 2100–Fall2021* Assignment#4
 * <This class holds the methods created for the linked special Queue>
 * * @edited by<Claire Kraft>*/

public class LinkedSpecialQueue{
	protected LLNode<Integer> front;     // reference to the front of this queue
	protected LLNode<Integer> rear;      // reference to the rear of this queue
	protected int numElements = 0;       // number of elements in this queue
	protected int numSpecial = 0;        // number of special elements in this queue

	public LinkedSpecialQueue() {
		front = null;
		rear = null;
	}

	public int size() {
		// Returns the number of elements in this queue.
		return numElements;
	}

	public int sizeSpecial() {
		// Returns the number of "special" elements in this queue.
		return numSpecial;
	}

	
	public void enqueue(int element) {
		//TODO (1) Implement this method to add a "regular" element to the
		// rear of the queue. "Special" element should be added to the
		// front of the queue, maintaining a queue of 'special' elements.
		
		// adds to rear if element is between 10 and 65 
		if (element > 10 && element < 65) {
			enqueuerear(element);
		}
		// else adds the element a special way 
		else {
			//enqueuefront(element);
			enqueuespecial(element);
		}
	}

	@Override
	public String toString() {
		//TODO (2) Implement this method to return the nicely formatted
		// String representation of the object
		
		String returnstring;
		LLNode<Integer> temp;
		temp = front;
		// if queue is empty return string that says queue is empty 
		if (front == null)
			return "The Queue is empty";
		
		// else add each element to the returnstring variable 
		else 
			returnstring = "Front  " + front.getInfo();
			while(temp.getLink() != null) {
				temp = temp.getLink();
				returnstring = returnstring + " --> " + temp.getInfo();
			}
		returnstring = returnstring + "  Rear";
		return returnstring;	
	}

	public LinkedSpecialQueue[] split() {
		//TODO (3) Implement this method to split the queue into two
		// queues and return the array containing two smaller queues.
	
			LLNode<Integer> temp;
			temp = front;
			LinkedSpecialQueue lsq1 = new LinkedSpecialQueue();
			LinkedSpecialQueue lsq2 = new LinkedSpecialQueue();
			// from elements from 1 to the number of elements in the queue add the odds to the first queue and 
			// evens to the second queue
			for (int x = 1; x <= numElements; x++)
				if (x%2 == 1) {
					lsq1.enqueuerear(temp.getInfo());
					temp = temp.getLink();			
				}
				else {
					lsq2.enqueuerear(temp.getInfo());
					temp = temp.getLink();
				}
			// create array for queues and add each queue to the array
			LinkedSpecialQueue[] lsqArray = new LinkedSpecialQueue[2];
			lsqArray[0] = lsq1;
			lsqArray[1] = lsq2;
		return lsqArray;
	}
	
	// Helper Methods 
	public void enqueuefront(int element)
	  // Adds element to the front of this queue.
	  // not used in this assignment 
	  { 
	    LLNode<Integer> newNode = new LLNode<Integer>(element);
	    if (front == null)
	      rear = newNode;
	    else
	      newNode.setLink(front);
	    front = newNode;
	    numElements++;
	  }    
	
	public void enqueuerear(int element) {
		// adds element to the end of the queue
		LLNode<Integer> newNode = new LLNode<Integer>(element);
		// if the rear is null then queue is empty, front and rear are set equal to newNode
		if (rear == null) {
		  front = newNode;
	      rear = newNode;
		}
		
		// else set rear link to the new node, and set the rear to the new node 
		else {
		  rear.setLink(newNode);
		  rear = newNode;
		}
		numElements++;
		     
	
	}
	
	public void enqueuespecial(int element) {
		LLNode<Integer> newNode = new LLNode<Integer>(element);
		LLNode<Integer> frontsp;
		//LLNode<Integer> front2;
		// if the front node is equal to zero set the front and the back to the new node (only one node in queue)
		if (front == null) {
		    rear = newNode;
		    front = newNode;
		}
		
		// else if the first node of the queue is a regular number add the special number to the front of the queue
		else if (front.getInfo() > 10 && front.getInfo() < 65 ){
			newNode.setLink(front);
			front = newNode;
		}
		
		// else if the first node is special, go through the special nodes until you hit a regular node 
		
		else {
		frontsp = front;
			// if the last node is special (all nodes are special) add the new node to the end of the queue 
			if (rear.getInfo() <= 10 || rear.getInfo() >= 65) {
				rear.setLink(newNode);
				rear = newNode;
			}
			// else go through the special node until a regular node 
			else {
				while (frontsp.getLink().getInfo() <= 10 || frontsp.getLink().getInfo() >= 65) {
					frontsp = frontsp.getLink();
				}
				// set the new special node to the first regular node and set the last special node to the new special node
				newNode.setLink(frontsp.getLink());
				frontsp.setLink(newNode);
		
			}
		}
		numSpecial++;
		numElements++;
	}
}
