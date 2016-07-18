/*
 * File:TargetSeeker.java
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*; //for color
import java.awt.event.*; //for mouse events

public class TargetSeeker extends GraphicsProgram{
	public void run(){
		initTarget();
		initSeeker();
		addMouseListeners();
		
		//always keep seeking the target
		while(true){
			seek();
		}
	}
	
	//target is a filled red square that starts in center of the screen
	private void initTarget(){
		targetSquare=new GRect(TARGET_SIZE,TARGET_SIZE);
		targetSquare.setFilled(true);
		targetSquare.setColor(Color.RED);
		targetX=getWidth()/2;
		targetY=getHeight()/2;
		add(targetSquare,targetX-TARGET_SIZE/2,targetY-TARGET_SIZE/2);
	}
	
	//seeker is an unfilled square that starts at origin
	private void initSeeker(){
		seeker=new GRect(SEEKER_SIZE,SEEKER_SIZE);
		add(seeker,0,0);
	}
	
	//move center of target to position of mouse click
	public void mouseClicked(MouseEvent e){
		targetX=e.getX();
		targetY=e.getY();
		remove(targetSquare);
		add(targetSquare,targetX-TARGET_SIZE/2,targetY-TARGET_SIZE/2);
	}
	
	//seek target by taking small steps towards the target
	private void seek(){
		pause(PAUSE_TIME);
		double seekerMidX=seeker.getX()+SEEKER_SIZE/2;
		double seekerMidY=seeker.getY()+SEEKER_SIZE/2;
		if(targetX>seekerMidX){
			seeker.move(1,0);
		}else{
			seeker.move(-1, 0);
		}
		
		if(targetY>seekerMidY){
			seeker.move(0,1);
		}else{
			seeker.move(0,-1);
		}
	}
	
	/*constants*/
	private static final double TARGET_SIZE=10;
	private static final double SEEKER_SIZE=20;
	private static final double PAUSE_TIME=10;
	
	/*private instance variables*/
	private double targetX;
	private double targetY;
	private GRect targetSquare;
	private GRect seeker;
	
}
