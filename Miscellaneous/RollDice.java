/*
 * File: RollDice.java
 * ----------------------
 * This program stimulates rolling of some dice until
 * the maximal value on all the dice is rolled.
 */

import acm.program.*;
import acm.util.*;       /*for RandomGenerator class.*/

public class RollDice extends ConsoleProgram {
	
	/*Number of sides on each dice. */
	private static final int NUM_SIDES = 6;
	
	public void run(){
		int numOfDice=readInt("Number of Dice: ");
		int maxRoll=numOfDice*NUM_SIDES;
		int count=0;
		while(true){
			int roll=RollDice(numOfDice);
			count++;
			if(roll==maxRoll)
				break;
			else{
				println("You rolled "+roll);
				println("Rolling Again...");
			}
				
		}
		println("Rolled "+maxRoll+" after "+count+" rolls.");
	}
	
	/* Returns the total of rolling numOfDice dice. */
	private int RollDice(int numOfDice){
		int i,total=0;
		for(i=0;i<numOfDice;i++){
			total=total+rgen.nextInt(1,NUM_SIDES);
		}
		return total;
	}
	
	/*private instance variable. */
	private RandomGenerator rgen= RandomGenerator.getInstance();

}
