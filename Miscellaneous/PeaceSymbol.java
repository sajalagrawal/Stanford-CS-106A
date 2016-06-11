/*
 * File: PeaceSymbol.java
 * ----------------------
 * This program draws Peace Symbol
 */

import acm.program.*;
import acm.graphics.*;

public class PeaceSymbol extends GraphicsProgram{
	private static final int RAD=100;
	private static final int X=100;
	private static final int Y=100;
	
	public void run(){
		drawPeaceSymbol(X,Y,RAD);
	}

	private void drawPeaceSymbol(double x,double y,double r){
		GOval circle=new GOval(x,y,2*r,2*r);
		add(circle);
		GLine lineV=new GLine(x+r,y,x+r,y+2*r);
		add(lineV);
		double rsine=r*Math.sin(22/(4.0*7));
		double rcosine=r*Math.cos(22/(4.0*7));
		GLine line2= new GLine(x+r,y+r,x+r-rsine,y+r+rcosine);
		add(line2);
		GLine line3=new GLine(x+r,y+r,x+r+rsine,y+r+rcosine);
		add(line3);
	}
}
