/*
 * File:MorseCode.java
 * --------------------
 * This program reads in a String and translates it into its equivalent Morse code.
 */

import acm.program.*;

public class MorseCode extends ConsoleProgram{
	private static final String[] ar={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	
	public void run(){
		println("This program translates a line into Morse Code.");
		String plaintext=readLine("Enter English Text:");
		printMorseCode(plaintext);
	}
	
	private void printMorseCode(String s){
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			ch=Character.toUpperCase(ch);
			if(ch==' '){
				println("");
				continue;
			}
			int t=ch-'A';
			print(ar[t]+" ");
		}
	}
}
