/*
* File: CheckWordLadder.java
* --------------------------
* Solution for checking a word ladder from the practice final exam.
*/

import java.io.*;
import acm.util.*;
import acm.program.*;

public class CheckWordLadder extends ConsoleProgram{
	public void run(){
		println("Program to check a word ladder.");
		println("Enter a sequence of words ending with a blank line.");
		while(true){
			String word;
			try {
				word = readAndCheckWord(previousWord);
			} catch (IOException ex) {
				throw new ErrorException(ex);
			}
			if(word==null){
				break;
			}
		}
		println("Word Ladder ends.");
	}
	
	/**
	 * Checks if the word is present in the lexicon file and also checks for
	 * difference of one character from it's predecessor.
	 */
	private String readAndCheckWord(String pre) throws FileNotFoundException{
		String word=readLine("");
		if(word.equals("")){
			return null;
		}
		if(!lexicon.isEnglishWord(word)){
			println("That word is not legal. Try again.");
			word=readAndCheckWord(pre);
		}
		if(!oneLetterChanged(pre,word)){
			println("Only one letter should be changed. Try again.");
			word=readAndCheckWord(pre);
		}
		return word;
	}
	
	/**Returns true if a word differ from its predecessor in exactly one character position*/
	private boolean oneLetterChanged(String pre,String word) throws FileNotFoundException{
		if(pre.equals("")){
			if(lexicon.isEnglishWord(word)){
				previousWord=word;
				return true;
			}
		}else if(pre.length()!=word.length()){
			return false;
		}else{
			int count=0;
			for(int i=0;i<pre.length();i++){
				if(pre.charAt(i)!=word.charAt(i)){
					count++;
				}
			}
			if(count==1){
				previousWord=word;
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	/*Private instance variables*/
	private Lexicon lexicon=new Lexicon("english.txt");
	private String previousWord="";
}
