/*
 * File:Histogram.java
 * -------------------
 * This program reads in scores from a text file and displays a histogram.
 */

import acm.program.*;
import java.io.*;
import acm.util.*;  //for ErrorException

public class Histogram extends ConsoleProgram{
	public void run(){
	    rd=openFile("Enter filename:");
		histogramArray=new int[11];
		initHistogram();
		readScoresIntoHistogram();
		println("\nHISTOGRAM-");
		printHistogram();
	}
	
	/**asks the user to input file name.*/
	private BufferedReader openFile(String prompt){
		rd=null;
		while(rd==null){
			try{
				String fname=readLine(prompt);
				rd=new BufferedReader(new FileReader(fname));
			}catch(IOException ex){
				println("Bad File.");
			}
		}
		return rd;
	}
	
	/**Initialise histogram array with 0.*/
	private void initHistogram(){
		for(int i=0;i<11;i++){
			histogramArray[i]=0;
		}
	}
	
	/**reads in scores from text file and updates histogram array.*/
	private void readScoresIntoHistogram(){
		try{
		while(true){
			String line=rd.readLine();
			if(line==null) break;
			int score=Integer.parseInt(line);   //converts String to integer.
			if(score<0 || score>100){
				throw new ErrorException("Score is out of range.");
			}
			else{
				int range=score/10;
				histogramArray[range]++;
			}
		}
		}catch(IOException ex){
			throw new ErrorException(ex);
		}
	}
	
	/**prints out the stars corresponding to the particular range.*/
	private void printHistogram(){
		for(int i=0;i<11;i++){
			String label;
			switch(i){
			case 0:label="00-09";  break;
			case 10:label="  100"; break;
			default:label=i*10+"-"+(i*10+9);
			}
			print(label+": ");
			for(int j=0;j<histogramArray[i];j++){
				print("*");
			}
			print("\n");
		}
	}
	
	/*private instance variables.*/
	private int[] histogramArray;
	private BufferedReader rd;
}
