/*
* File: Checkerboard.java
* -----------------------
* This program draws a checkerboard.
*/

import acm.program.*;
import acm.graphics.*;

/*
* This class draws a checkerboard on the graphics window.
* The size of the checkerboard is specified by the
* constants NROWS and NCOLUMNS, and the checkboard fills
* the vertical space available.
*/

public class Checkerboard extends GraphicsProgram{
	
	private static final int NROWS = 8;  //number of rows
	
	private static final int NCOLS = 8;  //number of columns

	public void run(){
		int sqSide = getHeight()/NROWS;
		for(int i=0 ; i < NROWS ; i++){    //loop for creating rows
			for(int j=0 ; j < NCOLS ; j++){     //loop for creating columns
				 int x = j*sqSide;
				 int y = i*sqSide;
				 GRect square = new GRect(x,y,sqSide,sqSide);
				 if((i+j)%2==0)
					 square.setFilled(false);
				 else
					 square.setFilled(true);
				 add(square);
			}
		}
	}

}
