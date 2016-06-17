/*
 * File:ColorNames.java
 * -----------------------
 * This program puts up labels on the screen in a random position 
 * and in a random color. Pressing the mouse button on top of one of the 
 * GLabels temporarily resets its color to the one that matches its name.
 * Releasing the mouse button chooses a new random color for the label.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import java.awt.*;

public class ColorNames extends GraphicsProgram{
	public void run(){
		Red=new GLabel("RED");
		Red.setColor(rgen.nextColor());
		Red.setFont("Courier-25-BOLD");
		add(Red,rgen.nextDouble(0,getWidth()-Red.getWidth()),rgen.nextDouble(0,getHeight()-Red.getHeight()));
		
		Orange=new GLabel("ORANGE");
		Orange.setColor(rgen.nextColor());
		Orange.setFont("Courier-25-BOLD");
		add(Orange,rgen.nextDouble(0,getWidth()-Orange.getWidth()),rgen.nextDouble(0,getHeight()-Orange.getHeight()));
		
		Yellow=new GLabel("YELLOW");
		Yellow.setColor(rgen.nextColor());
		Yellow.setFont("Courier-25-BOLD");
		add(Yellow,rgen.nextDouble(0,getWidth()-Yellow.getWidth()),rgen.nextDouble(0,getHeight()-Yellow.getHeight()));
		
		Green=new GLabel("GREEN");
		Green.setColor(rgen.nextColor());
		Green.setFont("Courier-25-BOLD");
		add(Green,rgen.nextDouble(0,getWidth()-Green.getWidth()),rgen.nextDouble(0,getHeight()-Green.getHeight()));
		
		Cyan=new GLabel("CYAN");
		Cyan.setColor(rgen.nextColor());
		Cyan.setFont("Courier-25-BOLD");
		add(Cyan,rgen.nextDouble(0,getWidth()-Cyan.getWidth()),rgen.nextDouble(0,getHeight()-Cyan.getHeight()));
		
		Blue=new GLabel("BLUE");
		Blue.setColor(rgen.nextColor());
		Blue.setFont("Courier-25-BOLD");
		add(Blue,rgen.nextDouble(0,getWidth()-Blue.getWidth()),rgen.nextDouble(0,getHeight()-Blue.getHeight()));
		
		Magenta=new GLabel("MAGENTA");
		Magenta.setColor(rgen.nextColor());
		Magenta.setFont("Courier-25-BOLD");
		add(Magenta,rgen.nextDouble(0,getWidth()-Magenta.getWidth()),rgen.nextDouble(0,getHeight()-Magenta.getHeight()));
		
		addMouseListeners();
	}
	
	/*Changes the label's color to actual color depending on label name
	 * when the mouse is pressed on that particular label.*/
	public void mousePressed(MouseEvent e){
		if(getElementAt(e.getX(),e.getY())!=null){
			if(getElementAt(e.getX(),e.getY())==Red){
				Red.setColor(Color.RED);
			}
			if(getElementAt(e.getX(),e.getY())==Orange){
				Orange.setColor(Color.ORANGE);
			}
			if(getElementAt(e.getX(),e.getY())==Yellow){
				Yellow.setColor(Color.YELLOW);
			}
			if(getElementAt(e.getX(),e.getY())==Green){
				Green.setColor(Color.GREEN);
			}
			if(getElementAt(e.getX(),e.getY())==Cyan){
				Cyan.setColor(Color.CYAN);
			}
			if(getElementAt(e.getX(),e.getY())==Blue){
				Blue.setColor(Color.BLUE);
			}
			if(getElementAt(e.getX(),e.getY())==Magenta){
				Magenta.setColor(Color.MAGENTA);
			}
		}
	}
	
	/*Changes the label's color to a random one when the mouse is released.*/
	public void mouseReleased(MouseEvent e){
		if(getElementAt(e.getX(),e.getY())!=null){
			if(getElementAt(e.getX(),e.getY())==Red){
				Red.setColor(rgen.nextColor());
			}
			if(getElementAt(e.getX(),e.getY())==Orange){
				Orange.setColor(rgen.nextColor());
			}
			if(getElementAt(e.getX(),e.getY())==Yellow){
				Yellow.setColor(rgen.nextColor());
			}
			if(getElementAt(e.getX(),e.getY())==Green){
				Green.setColor(rgen.nextColor());
			}
			if(getElementAt(e.getX(),e.getY())==Cyan){
				Cyan.setColor(rgen.nextColor());
			}
			if(getElementAt(e.getX(),e.getY())==Blue){
				Blue.setColor(rgen.nextColor());
			}
			if(getElementAt(e.getX(),e.getY())==Magenta){
				Magenta.setColor(rgen.nextColor());
			}
		}
	}
	
	/*private instance variables.*/
	private GLabel Red,Orange,Yellow,Green,Cyan,Blue,Magenta;
	private RandomGenerator rgen=RandomGenerator.getInstance();
}
