/*
 * File:Median.java
 * ----------------
 * This program returns the median of an array of doubles.
 */

import acm.program.*;

public class Median extends ConsoleProgram{
	public void run(){
		double[] array1={6.3,2.1,7.2,1.2,4.5,8.1,3.6,5.4,9.6};
		double[] array2={1.2,3.6,5.4,7.2};
		println("Array 1: 6.3,2.1,7.2,1.2,4.5,8.1,3.6,5.4,9.6");
		println("Median:"+median(array1));
		println("Array 2: 1.2,3.6,5.4,7.2");
		println("Median:"+median(array2));
	}
	
	private double median(double[] a){
		//sorting the array
		for(int i=0;i<a.length;i++){
			int smallestIndex=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[smallestIndex]){
					smallestIndex=j;
				}
			}
			//swapping the elements
			double temp=a[i];
			a[i]=a[smallestIndex];
			a[smallestIndex]=temp;
		}
		
		//finding the median
		if(a.length%2==1){
			int mid=(a.length)/2;
			return a[mid];
		}else{
			int midLeft=(a.length/2)-1;
			int midRight=a.length/2;
			return (a[midLeft]+a[midRight])/2.0;
		}
	}
}
