/*
* File: RandomCircles.java
* ------------------------
* This program draws a set of 10 circles with different sizes,
* positions, and colors. Each circle has a randomly chosen
* color, a randomly chosen radius between 5 and 50 pixels,
* and a randomly chosen position on the canvas, subject to
* the condition that the entire circle must fit inside the
* canvas without extending past the edge.
*/

import acm.program.*;
import acm.graphics.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram{
	
	/*Number of circles.*/
	private static final int N_CIRCLES=10;
	
	/*Minimum radius.*/
	private static final double MIN_RAD=5.0;
	
	/*Maximum radius.*/
	private static final double MAX_RAD=75.0;
	
	/*private instance variable.*/
	private GOval circle;
	
	public void run(){
		int i;
		for(i=0;i<N_CIRCLES;i++){
			double rad=rgen.nextDouble(MIN_RAD,MAX_RAD);
			circle=new GOval(2*rad,2*rad);
			double x=rgen.nextDouble(0,getWidth()-2*rad);
			double y=rgen.nextDouble(0,getHeight()-2*rad);
			circle.setColor(rgen.nextColor());
			circle.setFilled(true);
			add(circle,x,y);
		}
	}
	/*private instance variable.*/
	private RandomGenerator rgen=RandomGenerator.getInstance();
}
