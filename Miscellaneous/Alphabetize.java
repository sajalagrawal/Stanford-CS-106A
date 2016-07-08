/*
 * File:Alphabetize.java
 * -------------------
 * This program sorts an array of strings into lexicographic order.
 */

import acm.program.*;

public class Alphabetize extends ConsoleProgram{
	public void run(){
		String[] s={"aagrav","aasa","abaa","abba","zen","sosh","aagrap","aagrapp"};
		alphabetize(s);
		for(int i=0;i<s.length;i++){
			println(s[i]);
		}
	}
	
	private void alphabetize(String[] s){
		for(int i=0;i<s.length;i++){
			int smallestIndex=i;
			for(int j=i+1;j<s.length;j++){
				if(s[j].compareTo(s[smallestIndex])<0){
					smallestIndex=j;
				}
			}
			String temp=s[i];
			s[i]=s[smallestIndex];
			s[smallestIndex]=temp;
		}
	}
}
