import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class DragFace extends GraphicsProgram {
	public void run(){
		face=new GFace(FACE_WIDTH,FACE_HEIGHT);
		add(face,getWidth()/2-FACE_WIDTH/2,getHeight()/2-FACE_HEIGHT/2);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e){
		lastX=e.getX();
		lastY=e.getY();
		gobj=getElementAt(e.getX(),e.getY());
	}
	
	public void mouseDragged(MouseEvent e){
		if(gobj==face){
			face.move(e.getX()-lastX, e.getY()-lastY);
			lastX=e.getX();
			lastY=e.getY();
		}
		
	}
	
	private static final int FACE_WIDTH=200;
	private static final int FACE_HEIGHT=300;
	private GFace face;
	private GObject gobj;
	private double lastX,lastY;
}
