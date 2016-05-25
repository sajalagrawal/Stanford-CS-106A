/*
 * File: MouseTracker.java
 * -------------------------
 * This program displays the (x,y) location of the mouse.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram {
	
	public void run(){
		label=new GLabel("");
		label.setFont("Times New Roman-32");
		add(label,50,50);
		//must call this method to be able to get mouse events.
		addMouseListeners();
	}
	
	//this method is called everytime user moves mouse.
	public void mouseMoved(MouseEvent e){
		label.setLabel("MOUSE: ( "+e.getX()+","+e.getY()+" )");
	}
	
	//private instance variables.
	private GLabel label;

}
