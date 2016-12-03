/*
 * File: TimesSquare.java
 * ----------------------
 * This program displays the text of the string HEADLINE
 * on the screen in an animated way that moves it across
 * the display from left-to-right.
 */

import acm.program.*;
import acm.graphics.*;

public class TimesSquare extends GraphicsProgram{
	private static final double DELTA_X=2.0;
	
	private static final int DELAY=20;
	
	private static final String HEADLINE="When in the course of human events it becomes "+
	"neccessary for one people to dissolve the political bands which conneted them "+
	"with another...";
	
	public void run(){
		GLabel label=new GLabel(HEADLINE);
		label.setFont("Times-72");
		add(label,getWidth(),getHeight()/2+label.getAscent()/2);
		while(label.getX()+label.getWidth()>0){
			label.move(-DELTA_X,0);
			pause(DELAY);
		}
	}

}
