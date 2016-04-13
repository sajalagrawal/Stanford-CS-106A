/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int SENTINEL=0;
		
	public void run() {
		println("This program finds the largest and smallest numbers.");
		int firstNumber=readInt("? ");
		if(firstNumber==SENTINEL)
			println("This is not a valid first number.");  //if the first number is the sentinal, displays message.
		
		int smallestNumber=firstNumber;   //the first number is currently the smallest number.
		int largestNumber=firstNumber;    //the first number is also the largest number.	
		
		/*Pre-condition: The first number is not sentinel.
		 * compare each new number the user enters to the existing smallest and largest numbers, 
		 * and stores them as the smallest or largest if they are smallest or largest.
		 */
		
		while(firstNumber!=SENTINEL){
			int secondNumber=readInt("? ");  //prompt to input the next number.
			
			if(secondNumber!=SENTINEL){
				if(secondNumber>largestNumber)   //if the new number is greater than the largest number
					largestNumber=secondNumber;   //it is stored as largest number.
				
				if(secondNumber<smallestNumber)   //if the new number is smaller than the smallest number
					smallestNumber=secondNumber;  //it is store as smallest number.
			}
			
			if(secondNumber==SENTINEL){
				println("smallest: "+smallestNumber);
				println("largest: "+largestNumber);
				break;   //to stop the while loop.
			}
						
		}
	}
}

