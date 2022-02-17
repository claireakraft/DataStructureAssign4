package assign4LSQ;
/*** COSC 2100–Fall2021
* Assignment#4* <Dr. Jain's driver class to test the functionality of the LinkedSpecialQueue>
* * @edited by<Claire Kraf>*/

/*
 * COSC 2100 - Fall '21
 * Driver program to test the complete functionality of LinkedSpecialQueue
 * We create a queue, add elements to it, and split the queue into two queues
 * when the condition for split is met.
 * @author Dr. Jain
 */

import java.util.Random;
import java.util.Scanner;

public class TestLSQ {
	public static void main(String[] args) {	
		LinkedSpecialQueue lsq = new LinkedSpecialQueue();

		Random r = new Random();
		Scanner s = new Scanner(System.in);
		System.out.println("How many elements do you want in the queue?");
		int num = s.nextInt();

		//populate the queue with random integers (here ages)
		System.out.println("Creating " + num + " Person objects with following ages:");
		for(int i = 0; i<num; i++) {
			//Creating Person object with random age [0,120)
			Person newP = new Person(r.nextInt(120));
			lsq.enqueue(newP.age); 
			System.out.println(newP.age);
		}
		s.close(); //close the scanner

		//Display the queue contents
		System.out.println("\nQueue contents:\n" + lsq);

		System.out.println("\nSize of special queue = " + lsq.sizeSpecial());

		//splitting the queue if the condition is met
		if(lsq.sizeSpecial()>=lsq.size()/2) {
			System.out.println("\nWe should split the queue!!");
			System.out.println("Queue 1");
			System.out.println(lsq.split()[0]);
			System.out.println("Queue 2");
			System.out.println(lsq.split()[1]);
		}
		else {
			System.out.println("\nNo need to split the queue!!");
		}
	}
}
