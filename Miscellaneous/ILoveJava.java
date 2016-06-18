/*
 * File:ILovejava.java
 * --------------------
 * This program puts up a label on screen and bounces it around the canvas.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class ILoveJava extends GraphicsProgram {
	/*Animation delay.*/
	private static final double DELAY=5;
	
	public void run(){
		//puts up a label at the center of the screen.
		GLabel java=new GLabel("I Love Java");
		java.setFont("Sans Serif-28");
		add(java,getWidth()/2-java.getWidth()/2,getHeight()/2+java.getAscent()/2);
		vx=rgen.nextDouble(1.0,3.0);
		if(rgen.nextBoolean(0.5)){
			vx=-vx;
		}
		//loop for bouncing the label 
		while(true){
			java.move(vx,vy);
			
			//to not allow label to move outside the canvas.
			if(java.getX()+java.getWidth()>=getWidth() || java.getX()<=0){  
				vx=-vx;
			}
			if(java.getY()>=getHeight() || java.getY()<=java.getAscent()){
				vy=-vy;
			}
			
			pause(DELAY);
		}
	}
	
	/*randomise the initial speed in x-direction*/
	private RandomGenerator rgen=RandomGenerator.getInstance();
	
	/*Velocities in x and y directions.*/
	private double vx;
	private double vy=3;
}
