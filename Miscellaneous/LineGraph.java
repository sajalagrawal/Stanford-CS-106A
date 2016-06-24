/*
 * File:LineGraph.java
 * -------------------
 * This program generates a line graph, given an array of x-coordinate values 
 * and a second array of the corresponding y-coordinate values.
 */

import acm.program.*;
import acm.graphics.*;

public class LineGraph extends GraphicsProgram{
	//radius of circle denoting a point
	private static final double RAD=5;
	
	public void run(){
		//for scaling up the graph, otherwise it would be very small to be visible.
		for(int i=0;i<aX.length;i++){
			aX[i]*=200;
			aY[i]*=200;
		}
		//for moving the entire graph a bit right.
		for(int i=0;i<aX.length;i++){
			aX[i]+=10;
		}
		DrawLineGraph(aX,aY);
	}
	
	private void DrawLineGraph(double[] aX,double[] aY){
		for(int i=0;i<aX.length-1;i++){
			GOval point=new GOval(2*RAD,2*RAD);
			point.setFilled(true);
			add(point,aX[i]-RAD,getHeight()-aY[i]-RAD);
			GLine line=new GLine(aX[i],getHeight()-aY[i],aX[i+1],getHeight()-aY[i+1]);
			add(line);
		}
		//for last point
		GOval point=new GOval(2*RAD,2*RAD);
		point.setFilled(true);
		add(point,aX[9]-RAD,getHeight()-aY[9]-RAD);
	}
	
	//arrays containing x and y-coordinates
	private double[] aX={0.0,0.4,0.8,1.2,1.6,2.0,2.4,2.8,3.2,3.6};
	private double[] aY={0.67,0.68,0.71,0.86,0.86,1.04,1.30,1.81,1.46,1.86};
}
