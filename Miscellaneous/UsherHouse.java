/*
 * File: UsherHouse.java
 * ----------------------
 * This program draws a diagram of the House of Usher.
 */

import acm.graphics.*;
import acm.program.*;

public class UsherHouse extends GraphicsProgram{
	private static final double HEAD_WIDTH=250;
	private static final double HEAD_HEIGHT=300;
	private static final double WINDOW_SIDE=HEAD_WIDTH/5;
	private static final double GATE_WIDTH=HEAD_WIDTH/5;
	private static final double GATE_HEIGHT=HEAD_HEIGHT/4;
	private static final double PILLAR_WIDTH=HEAD_WIDTH/4;
	private static final double PILLAR_HEIGHT=HEAD_HEIGHT*7/6.0;	
	private static final double posX=200;
	private static final double posY=250;
	
	public void run(){
		drawMainBody();
		drawWindows();
		drawGate();
		drawMiddleTriangle();
		drawTwoPillars();
		drawPillarTriangles();
	}

	private void drawMainBody(){
		GRect body= new GRect(HEAD_WIDTH,HEAD_HEIGHT);
		add(body,posX,posY);
	}
	
	private void drawWindows(){
		GRect win1=new GRect(WINDOW_SIDE,WINDOW_SIDE);
		add(win1,posX+HEAD_WIDTH/4-WINDOW_SIDE/2,posY+HEAD_HEIGHT/4-WINDOW_SIDE/2);
		GRect win2=new GRect(WINDOW_SIDE,WINDOW_SIDE);
		add(win2,posX+HEAD_WIDTH*3/4.0-WINDOW_SIDE/2,posY+HEAD_HEIGHT/4-WINDOW_SIDE/2);
	}
	
	private void drawGate(){
		GRect gateRect=new GRect(GATE_WIDTH,GATE_HEIGHT);
		add(gateRect,posX+HEAD_WIDTH/2-GATE_WIDTH/2,posY+HEAD_HEIGHT-GATE_HEIGHT);
		GPolygon gateTri=createTriangle(GATE_WIDTH,GATE_WIDTH);
		add(gateTri,posX+HEAD_WIDTH/2,posY+HEAD_HEIGHT-GATE_HEIGHT-GATE_WIDTH/2);
	}
	
	private GPolygon createTriangle(double width,double height){
		GPolygon tri=new GPolygon();
		tri.addVertex(0,-height/2);
		tri.addVertex(-width/2,height/2);
		tri.addVertex(width/2,height/2);
		return tri;
	}
	
	private void drawMiddleTriangle(){
		GPolygon midTri=createTriangle(HEAD_WIDTH,HEAD_WIDTH*3/4.0);
		add(midTri,posX+HEAD_WIDTH/2,posY-HEAD_WIDTH*3/8.0);
	}
	
	private void drawTwoPillars(){
		GRect pLeft=new GRect(PILLAR_WIDTH,PILLAR_HEIGHT);
		add(pLeft,posX-PILLAR_WIDTH,posY+HEAD_HEIGHT-PILLAR_HEIGHT);
		GRect pRight=new GRect(PILLAR_WIDTH,PILLAR_HEIGHT);
		add(pRight,posX+HEAD_WIDTH,posY+HEAD_HEIGHT-PILLAR_HEIGHT);
	}
	
	private void drawPillarTriangles(){
		 GPolygon triLeft=createTriangle(PILLAR_WIDTH,PILLAR_WIDTH*2);
		 add(triLeft,posX-PILLAR_WIDTH/2,posY+HEAD_HEIGHT-PILLAR_HEIGHT-PILLAR_WIDTH);
		 GPolygon triRight=createTriangle(PILLAR_WIDTH,PILLAR_WIDTH*2);
		 add(triRight,posX+HEAD_WIDTH+PILLAR_WIDTH/2,posY+HEAD_HEIGHT-PILLAR_HEIGHT-PILLAR_WIDTH);
	}
}
