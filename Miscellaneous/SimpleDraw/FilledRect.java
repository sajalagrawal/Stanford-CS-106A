import acm.graphics.*;

public class FilledRect extends GCompound{
	public FilledRect(double width,double height){
		GRect outerRect=new GRect(width,height);
		add(outerRect,0,0);
		GRect innerRect=new GRect(width*3/4.0,height*0.5);
		innerRect.setFilled(true);
		add(innerRect,width*1/8.0,height*0.25);
	}
}
