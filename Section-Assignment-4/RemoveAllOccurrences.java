/*
 * File: RemoveAllOccurrences.java
 * This program removes all occurrences of a given character
 * from a given string.
 */

import acm.program.*;

public class RemoveAllOccurrences extends ConsoleProgram {
	public void run(){
		while(true){
			String str=readLine("Input:");
			String ch=readLine("Char to be removed:");
			char c=ch.charAt(0);
			println("After removal of \'"+ch+"\' :"+removeAllOccurrences(str,c));
		}
	}

	private String removeAllOccurrences(String str,char ch){
		String result="";
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)!=ch){
				result+=str.charAt(i);
			}
		}
		return result;
	}
}
