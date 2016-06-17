/*
 * File:LincolnMemorial.java
 * --------------------------
 * This program draws a picture of Lincoln Memorial in Washington, D.C.
 */

import acm.program.*;
import acm.graphics.*;

public class LincolnMemorial extends GraphicsProgram{
	private static final double PILLAR_WIDTH=25;
	private static final double PILLAR_HEIGHT=150;
	private static final double PILLAR_DIS=PILLAR_WIDTH*4/3.0;
	private static final double BODY_WIDTH=12*PILLAR_WIDTH+11*PILLAR_DIS;
	private static final double BODY_HEIGHT=PILLAR_HEIGHT*5/3.0;
	private static final double MAN_HEIGHT=PILLAR_HEIGHT/4;
	private static final double MAN_WIDTH=PILLAR_WIDTH*7/8.0;
	private static final double posX=40;
	private static final double posY=100;
	private static final double RADIUS=MAN_WIDTH*3/8.0;
	
	public void run(){
		drawBody();
		drawPillars();
		drawMan();
		drawCircles();
	}

	private void drawBody(){
		GRect body=new GRect(BODY_WIDTH,BODY_HEIGHT);
		add(body,posX,posY);
		GRect innerRect=new GRect(BODY_WIDTH,PILLAR_HEIGHT);
		add(innerRect,posX,posY+PILLAR_HEIGHT*1/3.0);
		GRect headRect=new GRect((PILLAR_WIDTH+PILLAR_DIS)*10,PILLAR_HEIGHT*1/3.0);
		add(headRect,posX+PILLAR_WIDTH+PILLAR_DIS/2,posY-PILLAR_HEIGHT*1/3.0);
	}
	
	private void drawPillars(){
		for(int i=0;i<12;i++){
			GRect pillar=new GRect(PILLAR_WIDTH,PILLAR_HEIGHT);
			add(pillar,posX+(PILLAR_WIDTH+PILLAR_DIS)*i,posY+PILLAR_HEIGHT*1/3.0);
		}
	}
	
	private void drawMan(){
		GRect body=new GRect(MAN_WIDTH,MAN_HEIGHT);
		add(body,posX+6*PILLAR_WIDTH+5.5*PILLAR_DIS-MAN_WIDTH/2,posY+PILLAR_HEIGHT*4/3.0-MAN_HEIGHT);
		GOval face=new GOval(RADIUS*2,RADIUS*2);
		add(face,posX+6*PILLAR_WIDTH+5.5*PILLAR_DIS-RADIUS,posY+PILLAR_HEIGHT*4/3.0-MAN_HEIGHT-RADIUS*2);
	}
	
	private void drawCircles(){
		for(int i=0;i<12;i++){
			GOval circle=new GOval(RADIUS*2,RADIUS*2);
			add(circle,posX+PILLAR_WIDTH/2+(PILLAR_WIDTH+PILLAR_DIS)*i-RADIUS,posY+PILLAR_HEIGHT/6.0-RADIUS);
		}
	}
}
