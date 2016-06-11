/*
 * File: HangmanLexicon.java
 * ----------------------------
 * This file provides words from the Lexicon.
 */

import acm.util.*;   //for ErrorException() 
import java.io.*;
import java.util.*; //for ArrayList
public class HangmanLexicon {
	
	private ArrayList<String> wordList=new ArrayList<String>();
	
	/*Read words from the text file and store it in an ArrayList.*/
	public HangmanLexicon(){
		try{
			BufferedReader rd=new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true){
				String line=rd.readLine();
				if(line==null)  break;
				wordList.add(line);
			}
			rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);
		}
	}
	
	/**Returns the number of words in the lexicon.*/
	public int getWordCount(){
		return wordList.size();
	}
	
	/**Returns the word at the specified index.*/
	public String getWord(int index){
		return wordList.get(index);
	}
}
