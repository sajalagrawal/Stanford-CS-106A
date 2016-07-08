/*
 * File:BubbleSort.java
 * ---------------------
 * This program sorts an array of integers using Bubble Sort algorithm.
 */

import acm.program.*;

public class BubbleSort extends ConsoleProgram{
	public void run(){
		int[] a={9,8,7,6,5,4,3,2,1};
		println("Before sorting:");
		printArray(a);
		sortIntegerArray(a);
		println("\nAfter sorting:");
		printArray(a);
	}
	
	private void sortIntegerArray(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		println("Array after "+i+1+" pass:");
		printArray(a);
		}
	}
	
	private void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			println(a[i]);
		}
	}
}
