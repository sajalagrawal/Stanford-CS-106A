/*
 * File:UseExpandableArray.java
 * ----------------------------
 * This program implements the ExpandableArray class that makes use
 * of an array that dynamically expands to accomodate whatever index we 
 * try to access. Returns null if we try to access an element which is 
 * out-of-bounds of the array (that was created dynmaically).
 */

import acm.program.*;

public class UseExpandableArray extends ConsoleProgram{
	public void run(){
		ExpandableArray myList=new ExpandableArray();
		myList.set(18, "Bob");
		myList.set(21, "Sally");
		
		String value=(String)myList.get(18); //cast is required
		if(value!=null){
			println("Value at index 18: "+value);
		}
		value=(String)myList.get(21); 
		if(value!=null){
			println("Value at index 21: "+value);
		}
		//index 54 is not defined hence get() method returns null
		value=(String)myList.get(54);
		println("Value at index 54: "+value);
	}
}
