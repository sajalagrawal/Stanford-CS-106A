/*
 * File: ConsecutiveHeads.java
 * ---------------------------------
 * This program simulates flipping a coin repeatedly and continues
 * until three consecutive heads are tossed.
 */

import acm.program.*;
import acm.util.*;

public class ConsecutiveHeads extends ConsoleProgram{
	public void run(){
		boolean i=false,j=false,k=false;
		int count=0;
		while(true){
			k=j;
			j=i;
			i=rgen.nextBoolean();
			if(i==true)
				println("Heads.");
			else
				println("Tails.");
			count++;
			if(i==true && j==true && k==true)
				break;
		}
		println("It took "+count+" flips to get 3 consecutive heads.");
		
	}
	
	/*private instance variable. */
	private RandomGenerator rgen=RandomGenerator.getInstance();

}
