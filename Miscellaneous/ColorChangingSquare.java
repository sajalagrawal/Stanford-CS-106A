/*
 * File: ColorChangingSquare.java
 * --------------------------------
 * This program puts up a square in the center of the window 
 * and randomly changes its color every second.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;        /*for RandomGenerator class.*/

public class ColorChangingSquare extends GraphicsProgram{
	/*Size of the square in pixels*/
	private static final int SQ_SIDE = 100;
	
	/*Pause time in milliseconds*/
	private static final int PAUSE_TIME = 1000;
	
	public void run(){
		GRect square = new GRect(SQ_SIDE, SQ_SIDE); 
		double x = getWidth()/2 - SQ_SIDE/2;
		double y= getHeight()/2 - SQ_SIDE/2;
		square.setFilled(true); 
		add(square,x,y);
		/*Infinite loop. */
		while(true){
			square.setColor(rgen.nextColor());
			pause(PAUSE_TIME);
		}
	}
	
	/*Private instance variable */
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
