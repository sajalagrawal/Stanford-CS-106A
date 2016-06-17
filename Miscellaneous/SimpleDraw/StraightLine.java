import acm.graphics.*;

public class StraightLine extends GCompound{
	public StraightLine(double width,double height){
		GRect outerRect=new GRect(width,height);
		add(outerRect,0,0);
		GLine line=new GLine(width/4,height*3/4.0,width*3/4.0,height/4);
		add(line);
	}
}
