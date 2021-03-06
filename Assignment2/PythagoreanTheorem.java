/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter values to compute Pythagorean theorem.");
		int a=readInt("a: ");    //asks user to enter an integer for a
		int b=readInt("b: ");    //asks user to enter an integer for b
		double x=(double)a;      // converts variable "a" from an integer to a double 
		double c=Math.sqrt(x*x+b*b);
		println("c = "+c);
	}
	
}
