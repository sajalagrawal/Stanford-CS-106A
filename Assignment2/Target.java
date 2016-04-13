/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;     //for using COLOR

public class Target extends GraphicsProgram {	
	public void run() {
		putOuterCircle();
		putMiddleCircle();
		putInnerCircle();
	}
	
	private void putOuterCircle(){
		int radius=72;
		int x=getWidth()/2-radius;    //to find the right coordinates so as to put the circle
		int y=getHeight()/2-radius;   //at the center of the screen.
		GOval outerCircle=new GOval(x,y,radius*2,radius*2);
		outerCircle.setFilled(true);
		outerCircle.setColor(Color.RED);
		add(outerCircle);
	}
	
	private void putMiddleCircle(){
		double radius=65*72/100;
		double x=getWidth()/2-radius;
		double y=getHeight()/2-radius;
		GOval middleCircle=new GOval(x,y,radius*2,radius*2);
		middleCircle.setFilled(true);
		middleCircle.setColor(Color.WHITE);
		add(middleCircle);
	}
	
	private void putInnerCircle(){
		double radius=3*72/10;
		double x=getWidth()/2-radius;
		double y=getHeight()/2-radius;
		GOval innerCircle= new GOval(x,y,radius*2,radius*2);
		innerCircle.setFilled(true);
		innerCircle.setColor(Color.RED);
		add(innerCircle);
	}
}
