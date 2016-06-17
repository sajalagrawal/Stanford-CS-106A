/*
 * File:SimpleDraw.java
 * --------------------
 * This program allows the user to select a particular shape 
 * from a palette given and draw that shape on the canvas. 
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class SimpleDraw extends GraphicsProgram{
	
	private static final double BOX_SIDE=50;
	private static final double MARGIN=20;
	
	public void run(){
		setupPalette();
		addMouseListeners();
	}
	
	//choose a particular shape
	public void mouseClicked(MouseEvent e){
		gobj=getElementAt(e.getX(),e.getY());
	}
	
	public void mousePressed(MouseEvent e){
		if(e.getX()>MARGIN+BOX_SIDE){      //canvas only outside the palette
			if(gobj==drawFilledRect){
				START_X=e.getX();
				START_Y=e.getY();
				filledRect=new GRect(0,0);
				filledRect.setFilled(true);
				add(filledRect,e.getX(),e.getY());
			}
			if(gobj==drawOutlinedRect){
				START_X=e.getX();
				START_Y=e.getY();
				rect=new GRect(0,0);
				add(rect,e.getX(),e.getY());
			}
			if(gobj==drawFilledOval){
				START_X=e.getX();
				START_Y=e.getY();
				filledOval=new GOval(0,0);
				filledOval.setFilled(true);
				add(filledOval,e.getX(),e.getY());
			}
			if(gobj==drawOutlinedOVal){
				START_X=e.getX();
				START_Y=e.getY();
				oval=new GOval(0,0);
				add(oval,e.getX(),e.getY());
			}
			if(gobj==drawStraightLine){
				line=new GLine(e.getX(),e.getY(),e.getX(),e.getY());
				add(line);
			}
		}
	}
	
	public void mouseDragged(MouseEvent e){
		if(gobj==drawFilledRect){
			double x=Math.min(e.getX(),START_X);
			double y=Math.min(e.getX(),START_Y);
			double width=Math.abs(e.getX()-START_X);
			double height=Math.abs(e.getY()-START_Y);
			filledRect.setBounds(x,y,width,height);
		}
		if(gobj==drawOutlinedRect){
		   double x=Math.min(START_X,e.getX());
		   double y=Math.min(START_Y,e.getY());
		   double width=Math.abs(START_X-e.getX());
		   double height=Math.abs(START_Y-e.getY());
		   rect.setBounds(x,y,width,height);
		}
		if(gobj==drawFilledOval){
			double x=Math.min(START_X,e.getX());
			double y=Math.min(START_Y,e.getY());
		    double width=Math.abs(START_X-e.getX());
		    double height=Math.abs(START_Y-e.getY());
			filledOval.setBounds(x,y,width,height);
		}
		if(gobj==drawOutlinedOVal){
			double x=Math.min(START_X,e.getX());
			double y=Math.min(START_Y,e.getY());
		    double width=Math.abs(START_X-e.getX());
		    double height=Math.abs(START_Y-e.getY());
			oval.setBounds(x,y,width,height);
		}
		if(gobj==drawStraightLine){
			line.setEndPoint(e.getX(),e.getY());
		}
	}
	
	/**Sets up the palette with different shapes on the left hand side.*/
	private void setupPalette(){
		drawFilledRect=new FilledRect(BOX_SIDE,BOX_SIDE);
		add(drawFilledRect,MARGIN,MARGIN);
		drawOutlinedRect=new OutlinedRect(BOX_SIDE,BOX_SIDE);
		add(drawOutlinedRect,MARGIN,MARGIN+BOX_SIDE*1.5);
		drawFilledOval=new FilledOval(BOX_SIDE,BOX_SIDE);
		add(drawFilledOval,MARGIN,MARGIN+BOX_SIDE*3.0);
		drawOutlinedOVal=new OutlinedOval(BOX_SIDE,BOX_SIDE);
		add(drawOutlinedOVal,MARGIN,MARGIN+BOX_SIDE*4.5);
		drawStraightLine=new StraightLine(BOX_SIDE,BOX_SIDE);
		add(drawStraightLine,MARGIN,MARGIN+BOX_SIDE*6.0);
	}
	
	//Objects on the palette.
	private FilledRect drawFilledRect;
	private OutlinedRect drawOutlinedRect;
	private FilledOval drawFilledOval;
	private OutlinedOval drawOutlinedOVal;
	private StraightLine drawStraightLine;
	
	//Objects on canvas.
	private GRect rect,filledRect;
	private GOval oval,filledOval;
	private GLine line;
	
	//stores the object which is selected from the palette.
	private GObject gobj;
	
	private double START_X,START_Y;
}