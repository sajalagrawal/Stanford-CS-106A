/*
 * File:ProbabilityBoard.java
 * ---------------------------
 * This program simulates the operation of dropping 50 marbles into a probability 
 * board with 10 channels along the bottom and displays the result graphically.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*; 

public class ProbabilityBoard extends GraphicsProgram{
	
	//distance between two consecutive bars
	private static final double DIS=40;
	//radius of the ball
	private static final double RAD=18;
	
	public void run(){
		//variable to keep track of turn at every peg.
		boolean b;
		//x-coordinate of leftmost bar
		double START_X=getWidth()/2-5*DIS;
		
		//loop for 50 balls
		for(int i=0;i<50;i++){
			int count=0;
			//loop for 9 pegs
			for(int j=0;j<9;j++){
				b=rgen.nextBoolean(0.5);
				if(b){
					count++;
				}
			}
			int mod=Math.abs(count-9);
			array[mod]++;
		}
		
		//loop for creating bars
		for(int i=0;i<11;i++){
			double x=START_X+i*DIS;
			GLine line =new GLine(x,getHeight(),x,0);
			add(line);
		}
		
		//loop for creating appropriate number of balls
		for(int i=0;i<10;i++){
			for(int j=0;j<array[i];j++){
				double x=START_X+i*DIS+DIS/2.0-RAD;
				double y=getHeight()-5-RAD*2*(j+1);
				GOval ball=new GOval(2*RAD,2*RAD);
				ball.setFilled(true);
				add(ball,x,y);
			}
		}
	}
	
	/*private instance variables.*/
	private RandomGenerator rgen=RandomGenerator.getInstance();
	private int[] array=new int[10];
}
