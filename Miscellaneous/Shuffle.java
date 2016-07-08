/*
 * File:Shuffle.java
 * ------------------
 * This program displays the integers between 1 and 52 in a randomly sorted order.
 */

import acm.program.*;
import acm.util.*;

public class Shuffle extends ConsoleProgram{
	public void run(){
		int[] array=new int[52];
		for(int i=0;i<array.length;i++){
			array[i]=i+1;
		}
		println("Initially");
		printArrayElements(array);
		println("\nShuffling...");
		shuffle(array);
		printArrayElements(array);
		println("\nShuffling again...");
		shuffle(array);
		printArrayElements(array);
	}
	
	private void shuffle(int[] a){
		for(int i=0;i<a.length;i++){
			int value=rgen.nextInt(i,a.length-1);
			//swapping
			int temp=a[i];
			a[i]=a[value];
			a[value]=temp;
		}
	}
	
	private void printArrayElements(int[] array){
		for(int i=0;i<array.length-1;i++){
			print(array[i]+", ");
		}
		print(array[array.length-1]);
	}
	
	private RandomGenerator rgen=RandomGenerator.getInstance();
}


