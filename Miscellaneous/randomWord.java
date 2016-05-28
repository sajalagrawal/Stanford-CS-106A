/*
 * File: randomWord.java
 * This program returns a randomly constructed “word” consisting
 * of randomly chosen letters. The number of letters in the word should also be chosen
 * randomly by picking a number between the values of the named constants
 * MIN_LETTERS and MAX_LETTERS.
 */

import acm.program.*;
import acm.util.*;

public class randomWord extends ConsoleProgram{
	
	/**Min and Max number of letters in the word.*/
	private static final int MIN_LETTERS=3;
	private static final int MAX_LETTERS=6;

	public void run(){
		for(int i=0;i<5;i++)
			println(returnRandomWord());
	
	}
	
	/**This method returns a randomly generated word with it's 
	 * first letter in uppercase.
	 */
	private String returnRandomWord(){
		String result="";
		int length=rgen.nextInt(MIN_LETTERS,MAX_LETTERS);
		int u=rgen.nextInt(65,90);
		result+=(char)u;
		
		for(int i=0;i<length-1;i++){
			int l=rgen.nextInt(97,122);
		    result+=(char)l;
		}
		return result;
	}
	
	/*private instance variable.*/
	private RandomGenerator rgen=RandomGenerator.getInstance();
}
