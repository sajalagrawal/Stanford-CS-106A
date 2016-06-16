import acm.graphics.*;

public class TwoPanes extends GCompound{
	public TwoPanes(double width,double height){
		GRect upperpane=new GRect(width,height);
		add(upperpane,0,0);
		GRect lowerpane=new GRect(width,height);
		add(lowerpane,0,height);
	}
}
