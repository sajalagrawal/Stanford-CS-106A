/*
 * File:GuessTheNumber.java
 * ------------------------
 * This program plays a number-guessing game with its user, 
 * who is presumably an elementary-school child. The child thinks of a 
 * number and then answers a series of questions from the computer 
 * until it correctly guesses the number.
 */

import acm.program.*;

public class GuessTheNumber extends ConsoleProgram{
	public void run(){
		int MAX_LIMIT=100;
		int MIN_LIMIT=1;
		println("Think of a number between "+MIN_LIMIT+" and "+MAX_LIMIT+" and I'll guess it.");
		int mid=(MAX_LIMIT+MIN_LIMIT)/2;
		while(true){
			String ans=readLine("Is it "+mid+"?");
			if(ans.equals("yes")){
				println("I guessed the number!");
				break;
			}
			else{
				if(MIN_LIMIT==MAX_LIMIT){
					println("You guessed incorrectly.");
					break;
				}
				String lesser=readLine("Is it less than "+mid+"?");
				if(lesser.equals("yes")){
					MAX_LIMIT=mid-1;
				}else{
					MIN_LIMIT=mid+1;
				}
				mid=(MIN_LIMIT+MAX_LIMIT)/2;
			}
		}
	}
}
