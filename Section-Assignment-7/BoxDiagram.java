/*
 * File:BoxDiagram.java
 * ----------------------
 * This program allows the user to create a set of boxes with labels
 * and then drag them around in the window. Also user can remove a particular
 * label or remove all the labels together.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BoxDiagram extends GraphicsProgram{
	public void init(){ 	
		setupInteractors();
		addActionListeners();
		addMouseListeners();
	}
	  
	/*Sets up the user interface*/
	private void setupInteractors(){
		add(new JLabel("Name"),SOUTH);
		
		nameField=new JTextField(30);
		add(nameField,SOUTH);
		nameField.addActionListener(this);
		
		add=new JButton("Add");
		remove=new JButton("Remove");
		clear=new JButton("Clear");
		
		add(add,SOUTH);
		add(remove,SOUTH);
		add(clear,SOUTH);
	}
	
	/*called in response to button events*/
	public void actionPerformed(ActionEvent e){
		//user can either press enter key or click add button to add a box
		if(e.getSource()==add||e.getSource()==nameField){
			addBox(nameField.getText());
		}else if(e.getSource()==remove){
			removeBox(nameField.getText());
		}else if(e.getSource()==clear){
			removeAllBoxes(); 
		}
	}
	
	/*Adds a box with the given name at the center of the window.*/
	private void addBox(String name){
		GCompound box=new GCompound();  //reference point as center of the box
		GRect rect=new GRect(BOX_WIDTH,BOX_HEIGHT);
		GLabel text=new GLabel(name);
		box.add(rect,-BOX_WIDTH/2,-BOX_HEIGHT/2);
		box.add(text,-text.getWidth()/2,text.getAscent()/2);
		add(box,getWidth()/2,getHeight()/2);  //adding data box to canvas screen
		contents.put(name,box); //adding data box to HashMap
	}
	
	/*removes the box with the given name.*/
	private void removeBox(String name){
		if(contents.containsKey(name)){
			GObject delObj=contents.get(name);
			remove(delObj);   //removing data box from the canvas screen
			contents.remove(name);   //removing the data box from hashmap
		}
	}
	
	/*removes all the boxes on the screen.*/
	private void removeAllBoxes(){
		Iterator<String> it=contents.keySet().iterator();
		//iterating through all the elements present in the hashmap
		while(it.hasNext()){
			String name=it.next();
			GObject delObj=contents.get(name);
			remove(delObj);
		}
		contents.clear(); //clears all the entries from the HashMap
	}
	
	/*called on mouse press to record co-ordinates of the click.*/
	public void mousePressed(MouseEvent e){
		obj=getElementAt(e.getX(),e.getY());
		lastX=e.getX();
		lastY=e.getY();
	}
	
	/*called on mouse drag to reposition the object.*/
	public void mouseDragged(MouseEvent e){
		if(obj!=null){
			obj.move(e.getX()-lastX,e.getY()-lastY);
			lastX=e.getX();
			lastY=e.getY();
		}
	}
	
	/*private constants*/
	private static final double BOX_WIDTH=120;
	private static final double BOX_HEIGHT=50;
	
	private double lastX;
	private double lastY;
	
	/*private instance variables*/
	private HashMap<String, GObject> contents=new HashMap<String, GObject>();
	private GObject obj;
	private JTextField nameField;
	private JButton add;
	private JButton remove;
	private JButton clear;
}
