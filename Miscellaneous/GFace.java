/*
 * File: GFace.java
 * This class implements a face as a GCompound.
 */

//NOTE: Only need acm.graphics since this is not actually a
// program, but just a class using graphics.
import acm.graphics.*;

/**Defines a compound GFace class.*/
public class GFace extends GCompound{
	
	/**Constants specifying feature size as a fraction of the head size.*/
	private static final double EYE_WIDTH=0.15;
	private static final double EYE_HEIGHT=0.15;
	private static final double NOSE_WIDTH=0.15;
	private static final double NOSE_HEIGHT=0.10;
	private static final double MOUTH_WIDTH=0.50;
	private static final double MOUTH_HEIGHT=0.03;
	
	/**Creates a new GFace object with the specified dimensions.*/
	public GFace(double width,double height){
		head=new GOval(width,height);
		leftEye=new GOval(width*EYE_WIDTH,height*EYE_HEIGHT);
		rightEye=new GOval(width*EYE_WIDTH,height*EYE_HEIGHT);
		nose=createNose(width*NOSE_WIDTH,height*NOSE_HEIGHT);
		mouth= new GRect(width*MOUTH_WIDTH,height*MOUTH_HEIGHT);
		
		add(head,0,0);
		add(leftEye,0.25*width-EYE_WIDTH*width/2,0.25*height-EYE_HEIGHT*height/2);
		add(rightEye,0.75*width-EYE_WIDTH*width/2,0.25*height-EYE_HEIGHT*height/2);
		// reference point for nose is center of nose.
		add(nose,width/2,height/2);  
		add(mouth,width/2-MOUTH_WIDTH*width/2,0.75*height-MOUTH_HEIGHT*height/2);
	}
	
	/**Creates a triangle for nose.*/
	private GPolygon createNose(double width,double height){
		GPolygon poly=new GPolygon();
		poly.addVertex(-width/2,height/2);
		poly.addVertex(width/2,height/2);
		poly.addVertex(0,-height/2);
		return poly;
	}
	
	/*Private instance variables.*/
	private GOval head,leftEye,rightEye;
	private GRect mouth;
	private GPolygon nose;
}
