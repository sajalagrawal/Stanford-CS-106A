/*
* File: EtchASketch.java
* ----------------------
* This program solves the Etch-a-Sketch problem from the practice final.
* Added- Clear Button
*/
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*; //for JButton
import javax.swing.*;    //for JButton 
import java.awt.*; //for Color

public class EtchASketch extends GraphicsProgram{
	/*Cross size*/
	private static final double CROSS_SIZE=10;
	
	/*Step size*/
	private static final double STEP_SIZE=20;
	
	/**Initialise the application*/
	public void run(){
		//Initialise buttons
		JButton North=new JButton("North");
		add(North,SOUTH);
		JButton South=new JButton("South");
		add(South,SOUTH);
		JButton East=new JButton("East");
		add(East,SOUTH);
		JButton West=new JButton("West");
		add(West,SOUTH);
		JButton Clear=new JButton("Clear");
		add(Clear,SOUTH);
		addActionListeners();
		
		x=getWidth()/2;
		y=getHeight()/2;
		double delta=CROSS_SIZE/2;
		cross.add(new GLine(-delta,-delta,delta,delta));
		cross.add(new GLine(delta,-delta,-delta,delta));
		add(cross,x,y);
	}
	
	/**Called when an Action Event is detected*/
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("North")){
			moveCross(0,-STEP_SIZE);
		}else if(cmd.equals("South")){
			moveCross(0,STEP_SIZE);
		}else if(cmd.equals("East")){
			moveCross(-STEP_SIZE,0);
		}else if(cmd.equals("West")){
			moveCross(STEP_SIZE,0);
		}else if(cmd.equals("Clear")){
			removeAll();
			x=getWidth()/2;
			y=getHeight()/2;
			add(cross,x,y);
		}
	}
	
	/**
	 * Moves the cross and adds a red line to the canvas connecting its
	 * old and new positions.
	 */
	private void moveCross(double dx,double dy){
		GLine line=new GLine(x,y,x+dx,y+dy);
		line.setColor(Color.RED);
		add(line);
		//update the centre of the cross
		x+=dx;
		y+=dy;
		cross.move(dx,dy);
	}
	
	/*Private instance variables*/
	private GCompound cross=new GCompound();
	private double x,y; //keeps track of center of the cross.
}
