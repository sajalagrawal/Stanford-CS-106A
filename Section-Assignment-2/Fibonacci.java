/*
* File: Fibonacci.java
* --------------------
* This program lists the terms in the Fibonacci sequence up to
* a constant MAX_TERM_VALUE, which is the largest Fibonacci term
* the program will display.
*/

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	
	private static final int MAX_TERM_VALUE = 10000;
	
	public void run(){
			println("This program lists the Fibonacci sequence.");
			int t1=0,t2=1,t3;
			while(t1<=MAX_TERM_VALUE){
				println(t1);
				t3=t1+t2;
				t1=t2;
				t2=t3;
			}
	}
}
