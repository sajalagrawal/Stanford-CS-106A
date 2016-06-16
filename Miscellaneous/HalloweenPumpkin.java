/*
 * File: HalloweenPumpkin.java
 * ---------------------------
 * This program draws a Halloween Pumpkin.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class HalloweenPumpkin extends GraphicsProgram{
	
	private static final double HEAD_RAD=175;
	private static final double STEM_WIDTH=0.1*HEAD_RAD;
	private static final double STEM_HEIGHT=1/8.0*HEAD_RAD;
	private static final double TRI_WIDTH=0.30*HEAD_RAD;
	private static final double TRI_HEIGHT=TRI_WIDTH*Math.tan(22/(7*3.0))/2;
	private static final double MOUTH_HEIGHT=TRI_HEIGHT;
	private static final double MOUTH_WIDTH=TRI_WIDTH/2;
	private static final double posX=50;
	private static final double posY=50;
	
	public void run(){
		drawHead();
		drawStem();
		drawLeftEye();
		drawRightEye();
		drawNose();
		drawMouth();
	}
	
	private void drawHead(){
		GOval head= new GOval(2*HEAD_RAD,2*HEAD_RAD);
		head.setFilled(true);
		head.setColor(Color.ORANGE);
		add(head,posX,posY);
	}
	
	private void drawStem(){
		GRect stem=new GRect(STEM_WIDTH,STEM_HEIGHT);
		stem.setFilled(true);
		add(stem,posX+HEAD_RAD-STEM_WIDTH/2,posY-STEM_HEIGHT);
	}
	
	private void drawLeftEye(){
		GPolygon leftEye=drawTriangle();
		add(leftEye,posX+HEAD_RAD/2+TRI_WIDTH/2,posY+HEAD_RAD/2+TRI_WIDTH/2);
	}
	
	private void drawRightEye(){
		GPolygon rightEye=drawTriangle();
		add(rightEye,posX+HEAD_RAD*3/2.0-TRI_WIDTH/2,posY+HEAD_RAD/2+TRI_WIDTH/2);
	}
	
	private void drawNose(){
		GPolygon nose=drawTriangle();
		nose.rotate(180);
		add(nose,posX+HEAD_RAD,posY+HEAD_RAD);
	}
	
	private GPolygon drawTriangle(){
		GPolygon triangle=new GPolygon();
		triangle.addVertex(-TRI_WIDTH/2,-TRI_HEIGHT/2);
		triangle.addVertex(TRI_WIDTH/2,-TRI_HEIGHT/2);
		triangle.addVertex(0,TRI_HEIGHT/2);
		triangle.setFilled(true);
		return triangle;
	}
	
	private void drawMouth(){
		GPolygon mouthR=new GPolygon();
		mouthR.addVertex(0,-MOUTH_HEIGHT/2); //1
		mouthR.addVertex(MOUTH_WIDTH/2,-MOUTH_HEIGHT/4);  //3
		mouthR.addVertex(MOUTH_WIDTH,-MOUTH_HEIGHT/2); //5
		mouthR.addVertex(MOUTH_WIDTH*3/2.0,-MOUTH_HEIGHT/4); //7
		mouthR.addVertex(MOUTH_WIDTH*2,-MOUTH_HEIGHT/2);  //9
		mouthR.addVertex(MOUTH_WIDTH*5/2.0,-MOUTH_HEIGHT/4); //10
		mouthR.addVertex(MOUTH_WIDTH*3/2.0,MOUTH_HEIGHT/2); //8
		mouthR.addVertex(MOUTH_WIDTH,MOUTH_HEIGHT/4);  //6
		mouthR.addVertex(MOUTH_WIDTH/2,MOUTH_HEIGHT/2); //4
		mouthR.addVertex(0,MOUTH_HEIGHT/4); //2
		
		GPolygon mouthL=new GPolygon();
		mouthL.addVertex(0,-MOUTH_HEIGHT/2); //1
		mouthL.addVertex(-MOUTH_WIDTH/2,-MOUTH_HEIGHT/4);  //11
		mouthL.addVertex(-MOUTH_WIDTH,-MOUTH_HEIGHT/2);   //13
		mouthL.addVertex(-MOUTH_WIDTH*3/2.0,-MOUTH_HEIGHT/4);  //15
		mouthL.addVertex(-MOUTH_WIDTH*2,-MOUTH_HEIGHT/2); //17
		mouthL.addVertex(-MOUTH_WIDTH*5/2.0,-MOUTH_HEIGHT/4);  //18
		mouthL.addVertex(-MOUTH_WIDTH*3/2.0,MOUTH_HEIGHT/2);  //16
		mouthL.addVertex(-MOUTH_WIDTH,MOUTH_HEIGHT/4); //14
		mouthL.addVertex(-MOUTH_WIDTH/2,MOUTH_HEIGHT/2); //12
		mouthL.addVertex(0,MOUTH_HEIGHT/4); //2
		
		mouthR.setFilled(true);
		mouthL.setFilled(true);
		add(mouthR,posX+HEAD_RAD,posY+HEAD_RAD*3/2.0);
		add(mouthL,posX+HEAD_RAD,posY+HEAD_RAD*3/2.0);
	}
}
