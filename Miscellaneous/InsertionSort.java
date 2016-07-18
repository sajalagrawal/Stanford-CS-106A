/*
 * File:InsertionSort.java
 * ------------------------
 * This program sorts an integer array using Insertion sort algorithm.
 */

import acm.program.*;

public class InsertionSort extends ConsoleProgram{
	public void run(){
		int[] a={31,41,59,26,53,58,97,93};
		println("Initial array:");
		printArray(a);
		sortIntegerArray(a);
		println("\n\nAfter Sorting:");
		printArray(a);
	}
	
	private void sortIntegerArray(int[] a){
		println("\n\nAfter pass 1:");
		printArray(a);
		//array upto 1 element is already sorted, hence loop starts from 1
		for(int i=1;i<a.length;i++){
			int t=i;
			//finding how many positions the element needs to be moved
			while(a[i]<a[t-1]){
				t--;
				if(t==0) break;  //so that a[-1] would not be checked and executed in while()
			}
			//storing the element (into a temporary variable) which is to be placed at its correct position
			int temp=a[i];
			//moving array elements to make space for the element which is to be placed at its correct position
			for(int j=i;j>t;j--){
				a[j]=a[j-1];
			}
			//placing the appropriate element at the correct place
			a[t]=temp;
			println("\nAfter pass "+(i+1)+": ");
			printArray(a);
		}
	}

	private void printArray(int[] a){
		for(int i=0;i<a.length-1;i++){
			print(a[i]+", ");
		}
		print(a[a.length-1]);
	}
}