/* File: RobotFace.java 
 * This program draws a robot face. */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	
	/* Parameters for the drawing */
    private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 300;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 120;
	private static final int MOUTH_HEIGHT = 40;
	
	public void run(){
		drawHead();
		drawEyes();
		drawMouth();
	}
	
	private void drawHead(){
		int x = getWidth()/2 - HEAD_WIDTH/2;
		int y = getHeight()/2 - HEAD_HEIGHT/2;
		GRect head = new GRect(x,y,HEAD_WIDTH,HEAD_HEIGHT);
		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		add(head);
	}
	
	private void drawEyes(){
		int x = getWidth()/2 - HEAD_WIDTH/4 - EYE_RADIUS;
		int y = getHeight()/2 - HEAD_HEIGHT/4 - EYE_RADIUS;
		GOval eye = new GOval(x,y,2*EYE_RADIUS,2*EYE_RADIUS);
		eye.setFilled(true);
		eye.setColor(Color.YELLOW);
		add(eye);
		x = x + HEAD_WIDTH/2;
		eye = new GOval(x,y,2*EYE_RADIUS,2*EYE_RADIUS);
		eye.setFilled(true);
		eye.setColor(Color.YELLOW);
		add(eye);
	}
	
	private void drawMouth(){
		int x = getWidth()/2 - MOUTH_WIDTH/2;
		int y = getHeight()/2 + HEAD_HEIGHT/4 - MOUTH_HEIGHT/2;
		GRect mouth = new GRect(x,y,MOUTH_WIDTH,MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}
}
