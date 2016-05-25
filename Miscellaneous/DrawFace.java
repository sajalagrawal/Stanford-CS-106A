/*
 * File: DrawFace.java
 * ---------------------
 * This program draws a face at the center of the screen.
 */

import acm.program.*;
import acm.graphics.*;

public class DrawFace extends GraphicsProgram {
	
	//width of the face
	private static final double FACE_WIDTH=200;
	
	//height of the face
	private static final double FACE_HEIGHT=300;
	
	public void run(){
		GFace face=new GFace(FACE_WIDTH,FACE_HEIGHT);
		add(face,getWidth()/2-FACE_WIDTH/2,getHeight()/2-FACE_HEIGHT/2);
	}
}
