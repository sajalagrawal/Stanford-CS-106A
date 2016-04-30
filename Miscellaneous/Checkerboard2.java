/*File: Checkerboard2.java
 * -------------------
 * This program draws a Checkerboard.
 */

import acm.program.*;
import acm.graphics.*;

public class Checkerboard2 extends GraphicsProgram {
	/*side of the square boxes in pixels. */
	private static final int SIDE = 50;
	
	/*radius of the circle present inside squares. */
	private static final int RAD = 20;

	public void run(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				int x= j*SIDE;
				int y= i*SIDE;		
				GRect square = new GRect(x,y,SIDE,SIDE);
				add(square);
				x = x + SIDE/2 - RAD;
				y = y + SIDE/2 - RAD;
				GOval circle = new GOval(x,y,2*RAD,2*RAD);
				if((i+j)%2!=0)
					add(circle);
			}
		}
	}

}
