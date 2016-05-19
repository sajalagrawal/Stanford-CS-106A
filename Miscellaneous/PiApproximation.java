/*
 * File: PiApproximation.java
 * ----------------------------
 * This program computes an approximation to pi by simulating 
 * a dart board. The general technique is called Monte Carlo Integration.
 */

import acm.program.*;
import acm.util.*;

public class PiApproximation extends ConsoleProgram{
	
	/*Number of darts to throw. */
	private static final int NDARTS = 1000;
	
	public void run(){
		int inside=0;
		int i;
		for(i=0;i<NDARTS;i++){
			double x=rgen.nextDouble(-1.0,+1.0);
			double y=rgen.nextDouble(-1.0,+1.0);
			
			/* Consider circle of radius = 1, centered at (0, 0) */
			if(x*x+y*y<1.0){
				inside++;
			}
		}
		
		/* 
		 * Note: area of circle = PI * r * r = PI * 1 * 1 = PI 
		 * area of square = side * side = 2 * 2 = 4
		 * So, PI/4 is the fraction of darts landing in circle:
		 * darts in circle = NDARTS * PI/4
		 * PI = (4 * darts in circle)/NDARTS 
		 */
		double pi=(inside*4.0)/NDARTS;
		println("Pi is approximately = "+pi);
	}
	
	/*private instance variable. */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
