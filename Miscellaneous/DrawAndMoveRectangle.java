/*
 * File:DrawAndMoveRectangle.java
 * --------------------------------
 * This program allows user to draw a rectangle by pressing and
 * dragging mouse. Clicking the mouse inside an existing rectangle 
 * allows you to drag that rectangle to a new position on the canvas.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class DrawAndMoveRectangle extends GraphicsProgram{
	public void run(){
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e){
		gobj=getElementAt(e.getX(),e.getY());
		START_X=e.getX();
		START_Y=e.getY();
		if(gobj==null){
			rectangle=new GRect(START_X,START_Y,0,0);
			rectangle.setFilled(true);
			add(rectangle);
		}
	}

	public void mouseDragged(MouseEvent e){
		if(gobj==rectangle){
			rectangle.move(e.getX()-START_X,e.getY()-START_Y);
			START_X=e.getX();
			START_Y=e.getY();
		}
		if(gobj==null){
			double x=Math.min(START_X,e.getX());
			double y=Math.min(START_Y,e.getY());
			double width=Math.abs(START_X-e.getX());
			double height=Math.abs(START_Y-e.getY());
			rectangle.setBounds(x,y,width,height);
		}
	}
	
	private GRect rectangle;
	private GObject gobj;
	private double START_X,START_Y,lastX,lastY;
}
