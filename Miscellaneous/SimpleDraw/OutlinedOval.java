import acm.graphics.*;

public class OutlinedOval extends GCompound{
	public OutlinedOval(double width,double height){
		GRect outerRect=new GRect(width,height);
		add(outerRect,0,0);
		GOval oval=new GOval(width*3/4.0,height*0.5);
		add(oval,width*1/8.0,height*0.25);
	}
}
