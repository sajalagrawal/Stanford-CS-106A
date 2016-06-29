/*
* File: CountNames.java
* ---------------------
* This program shows an example of using a HashMap. It reads a
* list of names from the user and list out how many times each name
* appeared in the list.
*/

import acm.program.*;
import java.util.*;

public class CountNames extends ConsoleProgram{
	public void run(){
		HashMap<String,Integer> nameMap=new HashMap<String,Integer>();
		
		readNames(nameMap);
		printNames(nameMap);
	}
	
	/*
	* Reads a list of names from the user, storing names and how many
	* times each appeared in the map that is passed in as a parameter.
	*/
	private void readNames(HashMap<String,Integer> map){
		while(true){
			String name=readLine("Enter name:");
			if(name.equals("")) break;
			// See if that name previously appeared in the map. Update count if it did.
			if(map.containsKey(name)){
				int count=map.get(name);
				count+=1;
				map.put(name,count);
			}else{
				//if name did not appear previously, add a new count=1
				map.put(name,1);
			}
		}
	}
	
	/*
	* Prints out list of entries (and associated counts) from the map
	* that is passed in as a parameter.
	*/
	private void printNames(HashMap<String,Integer> map){
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			String key=it.next();
			int value=map.get(key);
			println("Entry ["+key+"] has count "+value);
		}
	}
}
