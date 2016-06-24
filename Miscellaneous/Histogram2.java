/*
 * File:Histogram2.java
 * ---------------------
 * This program prints out a histogram based on the input values.
 */

import acm.program.*;
import java.util.*;

public class Histogram2 extends ConsoleProgram{
	public void run(){
		println("Enter -1 to mark the end of input.");
		while(true){
			int value=readInt("?");
			if(value==-1) break;
			else if(value<0 || value>100){
				println("Illegal value. Try Again.");
			}
			else{
				alist.add(value);
			}	
		}
		array=new int[11];
		for(int i=0;i<alist.size();i++){
			int temp=alist.get(i);
			temp/=10;
			array[temp]++;
		}
		println("\nHISTOGRAM");
		for(int i=0;i<11;i++){
			String s;
			switch(i){
			case 0:s="0-9    |"; break;
			case 10:s="100    |";  break;
			default:s=i*10+"-"+(i*10+9)+"  |";
			}
			print(s+"  ");
			for(int j=0;j<array[i];j++){
				print("*");
			}
			println();
		}
	}
	
	/*private instance variables.*/
	private ArrayList<Integer> alist=new ArrayList<Integer>();
    private	int[] array;
}
