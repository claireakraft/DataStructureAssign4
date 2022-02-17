package assign4LSQ;

import java.util.Random;
import java.util.Scanner;

/*** COSC 2100–Fall2021
* Assignment#4* < My driver class to test the functionality of the LinkedSpecialQueue>
* * @edited by<Claire Kraft>*/

public class TestLSQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			// lsq.enqueuerear(newP.age); 
			System.out.println(newP.age);
		}
		s.close(); //close the scanner
		//String o = lsq.toString();
		//System.out.print(o);
		System.out.print(lsq.toString());
		
		
		
	}

}
