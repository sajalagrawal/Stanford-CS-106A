/*
 * File:MagicSquare.java
 * ---------------------
 * This program checks whether the input NxN array contains a Magic Square.
 */

import acm.program.*;

public class MagicSquare extends ConsoleProgram{
	public void run(){
		int n=readInt("Enter N for NxN matrix:");
		int[][] matrix=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=readInt("");
			}
		}
		if(isMagicSqaure(matrix)){
			println("YES, It is a magic square.");
		}
		else{
			println("NO, It is not a magic square.");
		}
	}
	
	private boolean isMagicSqaure(int[][] a){
		int sum=0,n=a.length;
		//sum of elements of first row
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0){
					sum+=a[i][j];
				}
			}
		}
		//checking for rows
		for(int i=0;i<n;i++){
			int check=0;
			for(int j=0;j<n;j++){
				check+=a[i][j];
			}
			if(check!=sum){
				return false;
			}
		}
		//checking for columns
		for(int j=0;j<n;j++){
			int check=0;
			for(int i=0;i<n;i++){
				check+=a[i][j];
			}
			if(check!=sum){
				return false;
			}
		}
		//checking for anti-diagonal
		for(int i=0;i<n;i++){
			int check=0;
			for(int j=n-1;j>=0;j--){
				check+=a[i][j];
			}
			if(check!=sum){
				return false;
			}
		}
		//checking for main diagonal
		int check=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j){
					check+=a[i][j];
				}
			}
		}
		if(check!=sum){
			return false;
		}
		
		return true;
	}
}
