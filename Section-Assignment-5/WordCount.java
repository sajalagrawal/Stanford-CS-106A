/*
 * File:WordCount.java
 * -------------------
 * This program reads a file and reports how many lines, words, and characters appear in it.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;

public class WordCount extends ConsoleProgram{
	public void run(){
		rd=openFile("Enter filename:");
		int lines=0,words=0,ch=0;
		while(true){
			try{
				String line=rd.readLine();
				if(line==null) break;
				lines++;
				words+=countWordsInLine(line);
				ch+=line.length();
			}catch(IOException ex){
				throw new ErrorException(ex);
			}
		}
		println("Lines:"+lines);
		println("Words:"+words);
		println("Chars:"+ch);
	}
	
	private BufferedReader openFile(String prompt){
		rd=null;
		while(rd==null){
			try{
				String fname=readLine(prompt);
				rd=new BufferedReader(new FileReader(fname));
			}catch(IOException ex){
				println("Bad file.");
			}
		}
		return rd;
	}
	
	private int countWordsInLine(String line){
		int words=0;
		boolean insideWord=false;
		for(int i=0;i<line.length();i++){
			char ch=line.charAt(i);
			if(Character.isLetterOrDigit(ch)){
				insideWord=true;
			}
			else{
				if(insideWord){
					words++;
				}
				insideWord=false;
			}
		}
		//if at the line there is no punctuation and there is a letter 
		//or digit then else part for that line won't get executed.
		if(insideWord)words++;
		return words;
	}
	
	/*private instance variable.*/
	private BufferedReader rd;
}
