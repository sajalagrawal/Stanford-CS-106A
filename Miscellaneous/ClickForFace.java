/*
 * File: ClickForFace.java
 * -------------------------
 * This program displays a face in every location the user
 * clicks on. It is an example of an event-driven program.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class ClickForFace extends GraphicsProgram{
	
	//private constants
	private static final double FACE_DIAM=30;

	//NOTE: no run() method in this program
	
	//init() method is called when program starts
	public void init(){
		//must call this method to be able to get mouse events.
		addMouseListeners();
	}
	
	//this method is called everytime user clicks mouse.
	public void mouseClicked(MouseEvent e){
		GFace face=new GFace(FACE_DIAM,FACE_DIAM);
		add(face,e.getX(),e.getY());
	}
}
