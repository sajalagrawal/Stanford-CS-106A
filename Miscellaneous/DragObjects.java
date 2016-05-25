/*
* File: DragObjects.java
* ----------------------
* Example program to show mouse and keyboard interactions.
* This program allows us to move objects on the screen
* by dragging then with the mouse. We can also change the
* color of the last object moved to a random color by typing a key.
*/

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;   //for mouse and keyboard events
import acm.util.*;  //for RandomGenerator
import java.awt.*; //for color

/** This class displays a mouse-draggable rectangle and oval */
public class DragObjects extends GraphicsProgram{
	
	// Initializes the program
	public void run(){
		GOval oval=new GOval(50,50,150,100);
		oval.setFilled(true);
		add(oval);
		GRect rect=new GRect(100,100,150,100);
		rect.setFilled(true);
		add(rect);
		
		addMouseListeners();
		addKeyListeners();
	}
	
	// Called on mouse press to record the coordinates of the click */
	public void mousePressed(MouseEvent e){
		// GPoint has X and Y coordinate
		last=new GPoint(e.getPoint());
		gobj=getElementAt(last);
	}
	
	// Called on mouse drag to reposition the object
	public void mouseDragged(MouseEvent e){
		if(gobj!=null){
			gobj.move(e.getX()-last.getX(),e.getY()-last.getY());
			last=new GPoint(e.getPoint());
		}
	}
	
	// Change color of last object dragged
	public void keyPressed(KeyEvent e){
		if(gobj!=null){
			gobj.setColor(rgen.nextColor());
		}
	}
	
	/* Private instance variables */
	private GObject gobj;  /* The object being dragged */
	private GPoint last;   /* The last mouse position */
	private RandomGenerator rgen= RandomGenerator.getInstance();

}
