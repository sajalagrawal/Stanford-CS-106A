/*
 * File:Mode.java
 * --------------
 * This program calculates Mode of a given array.
 */

import acm.program.*;

public class Mode extends ConsoleProgram{
	public void run(){
		double[] array={65,84,95,75,82,79,82,72,84,94,86,90,84};
		print("Initially: ");
		printArray(array);
		sortArray(array);
		print("After sorting: ");
		printArray(array);
		println("Mode:"+mode(array));
	}
	
	
	private double mode(double[] d){
		int max=1,count=1,index=0; //max and count initialised as 1 as each element will occur atleast once.
		for(int i=0;i<=d.length-2;i++){
			if(d[i]==d[i+1]){
				count++;
				if(count>max){
					max=count;
					index=i;
				}
			}else{
				count=1;
			}
		}
		return d[index];
	}
	
	private void sortArray(double[] d){
		for(int i=0;i<d.length-1;i++){
			for(int j=0;j<d.length-i-1;j++){
				if(d[j]>d[j+1]){
					double temp=d[j];
					d[j]=d[j+1];
					d[j+1]=temp;
				}
			}
		}
	}
	
	private void printArray(double[] d){
		for(int i=0;i<d.length-1;i++){
			print(d[i]+", ");
		}
		print(d[d.length-1]+"\n");
	}
}
