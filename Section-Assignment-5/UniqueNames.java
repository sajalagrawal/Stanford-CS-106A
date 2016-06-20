/*
 * File:UniqueNames.java
 * ---------------------
 * This program asks the user for a list of names and then removes 
 * all the duplicates of the names and prints out the unique names.
 */

import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram{
	public void run(){
		addUniqueNamesToArrayList();
		printNames();
	}
	
	/**Takes name input, add it to ArrayList if is unique.*/
	private void addUniqueNamesToArrayList(){
		while(true){
		String line=readLine("Enter name:");
		if(line.equals("")) break;
		if(!names.contains(line)){
			names.add(line);
		}
	    }
	}
	
	/**prints out the ArrayList now containing only unique names.*/
	private void printNames(){
		println("Unique names list contains:");
		for(int i=0;i<=names.size();i++){
			println(names.get(i));
		}
	}
	
	private ArrayList<String> names=new ArrayList<String>();
}
