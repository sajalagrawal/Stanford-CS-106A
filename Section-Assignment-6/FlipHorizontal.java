/*
 * File:FlipHorizontal.java
 * ------------------------
 * This program reverses the picture in the horizontal dimension.
 */

import acm.program.*;
import acm.graphics.*;

public class FlipHorizontal extends GraphicsProgram{
	public void run(){
		GImage orig=new GImage("milkmaid.PNG");
		add(orig,40,40);
		add(flipHorizonatal(orig),400,40);
	}
	
	private GImage flipHorizonatal(GImage orig){
		int[][] array=orig.getPixelArray();
		int height=array.length;
		int width=array[0].length;
		for(int row=0;row<height;row++){
			for(int p1=0;p1<width/2;p1++){
				int p2=width-p1-1;
				int temp=array[row][p1];
				array[row][p1]=array[row][p2];
				array[row][p2]=temp;
			}
		}
		return new GImage(array);
	}
}
