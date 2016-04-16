/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final int WIDTH=150;     //width of each box in the picture
	private static final int HEIGHT=60;     //height of each box in the picture
	
	public void run() {
		//calling all the methods
		drawProgramBox();
		drawGraphicsBox();
		drawConsoleBox();
		drawDialogBox();
		drawGraphicsLine();
		drawDialogLine();
		drawConsoleLine();
		
	}
	
	private void drawProgramBox(){
		double x = getWidth()/2 - WIDTH/2;   //finds x-coordinate of starting point for Program Box
		double y = getHeight()/2 - HEIGHT;   //finds y-coordinate of starting point for Program Box
		GRect programBox = new GRect(x,y,WIDTH,HEIGHT);
		add(programBox);    //adds the Program Box
		GLabel program = new GLabel("Program");
		x = x + WIDTH/2 - program.getWidth()/2;   //finds the x-coordinate of starting point for "program" label
		y = y + HEIGHT/2 + program.getAscent()/2; //finds the y-coordinate of starting point for "program" label
		add(program,x,y);   //adds the "Program" label
	}
	
	private void drawGraphicsBox(){
		double x = getWidth()/2 - 2*WIDTH;   //finds x-coordinate of starting point for Graphics Box
		double y = getHeight()/2 + HEIGHT;   //finds y-coordinate of starting point for Graphics Box
		GRect graphicsBox = new GRect(x,y,WIDTH,HEIGHT);
		add(graphicsBox);   //adds the Graphics Box
		GLabel graphics = new GLabel("GraphicsProgram");
		x = x + WIDTH/2 - graphics.getWidth()/2;    //finds the x-coordinate of starting point for "GraphicsProgram" label
		y = y + HEIGHT/2 + graphics.getAscent()/2;  //finds the y-coordinate of starting point for "GraphicsProgram" label
		add(graphics,x,y);  //adds the "GraphicsProgram" label
	}
	
	private void drawConsoleBox(){
		double x = getWidth()/2 - WIDTH/2;  //finds x-coordinate of starting point for Console Box
		double y = getHeight()/2 + HEIGHT;  //finds y-coordinate of starting point for Console Box
		GRect consoleBox = new GRect(x,y,WIDTH,HEIGHT);
		add(consoleBox);   //adds the Console Box
		GLabel console = new GLabel("ConsoleProgram");
		x = x + WIDTH/2 - console.getWidth()/2;    //finds the x-coordinate of starting point for "ConsoleProgram" label
		y = y + HEIGHT/2 + console.getAscent()/2;  //finds the y-coordinate of starting point for "ConsoleProgram" label
		add(console,x,y); //adds the "ConsoleProgram" label
	}
	
	private void drawDialogBox(){
		double x = getWidth()/2 + WIDTH;    //finds x-coordinate of starting point for Dialog Box
		double y = getHeight()/2 + HEIGHT;  //finds y-coordinate of starting point for Dialog Box
		GRect dialogBox = new GRect(x,y,WIDTH,HEIGHT);
		add(dialogBox);    //adds the Dialog Box
		GLabel dialog =  new GLabel("DialogProgram");
		x = x + WIDTH/2 - dialog.getWidth()/2;    //finds the x-coordinate of starting point for "DialogProgram" label
		y = y + HEIGHT/2 + dialog.getAscent()/2;  //finds the y-coordinate of starting point for "DialogProgram" label
		add(dialog,x,y);   //adds the "DialogProgram" label
	}
	
	private void drawGraphicsLine(){
		double x1 = getWidth()/2;  //x-coordinate of centre of screen
		double y1 = getHeight()/2; //y-coordinate of centre of screen
		double x2 = getWidth()/2 - 3*WIDTH/2;  //x-coordinate of centre of top of GraphicsBox
		double y2 = getHeight()/2 + HEIGHT;    //y-coordinate of centre of top of GraphicsBox
		GLine graphicsLine = new GLine(x1,y1,x2,y2);
		add(graphicsLine);  //adds the GraphicsLine 
	}
	
	private void drawDialogLine(){
		double x1 = getWidth()/2;
		double y1 = getHeight()/2;
		double x2 = getWidth()/2 + 3*WIDTH/2;  //x-coordinate of centre of top of DialogBox
		double y2 = getHeight()/2 + HEIGHT;    //y-coordinate of centre of top of DialogBox
		GLine dialogLine = new GLine(x1,y1,x2,y2);
		add(dialogLine); //adds the DialogLine
	}
	
	private void drawConsoleLine(){
		double x1 = getWidth()/2;
		double y1 = getHeight()/2;
		double x2 = getWidth()/2;             //x-coordinate of centre of top of ConsoleBox
		double y2 = getHeight()/2 + HEIGHT;   //y-coordinate of centre of top of ConsoleBox
		GLine consoleLine = new GLine(x1,y1,x2,y2);
		add(consoleLine);  //adds the ConsoleLine
	}
}

