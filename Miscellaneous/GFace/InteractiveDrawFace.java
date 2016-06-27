/*
* File: InteractiveDrawFace.java
* ------------------------------
* This program draws GFaces on the screen, but allows the
* use to modify their size and color.
*/

import acm.program.*;
import acm.graphics.*;
import java.awt.*; //for Color
import java.awt.event.*;  //for MouseEvents and ActionEvents
import javax.swing.*;

public class InteractiveDrawFace extends GraphicsProgram{
	//init method is called when the program starts.
	public void init(){
		//button to clear display
		JButton clear=new JButton("Clear");
		add(clear,SOUTH);
		
		//check box to display front or back of the face
		checkbox=new JCheckBox("Front");
		checkbox.setSelected(true);
		add(checkbox,SOUTH);
		
		initRadioButtons();
		initComboBox();
		
		//must call this method to be able to get mouse events.
		addMouseListeners();
		
		//must call this method to get button press events
		addActionListeners();
	}
	
	private void initRadioButtons(){
		//Radio Button for size
		smallRB=new JRadioButton("Small");
		medRB=new JRadioButton("Medium");
		largeRB=new JRadioButton("Large");
		
		ButtonGroup size=new ButtonGroup();
		
		//add all radio buttons to button group
		size.add(smallRB);
		size.add(medRB);
		size.add(largeRB);
		
		//set initial radio button selection
		medRB.setSelected(true);
		
		//add all radio buttons to control bar
		add(smallRB,SOUTH);
		add(medRB,SOUTH);
		add(largeRB,SOUTH);
	}
	
	private void initComboBox(){
		//create combo box with color choices
		pickColor=new JComboBox();
		pickColor.addItem("Black");
		pickColor.addItem("Blue");
		pickColor.addItem("Green");
		pickColor.addItem("Red");
		
		//don't allow user to type in a color
		pickColor.setEditable(false);
		
		//set initial color selection
		pickColor.setSelectedItem("Black");
		
		//create label(with separating spaces) for combobox
		add(new JLabel("   Color:"),SOUTH);
		
		//add combo box to control bar
		add(pickColor,SOUTH);
	}
	
	//returns diameter size corresponding to radio button
	private double getDiamSize(){
		double size=0;
		if(smallRB.isSelected()){
			size=SMALL_DIAM;
		}else if(medRB.isSelected()){
			size=MED_DIAM;
		}else {
			size=LARGE_DIAM;
		}
		return size;
	}
	
	private Color getCurrentColor(){
		String name=(String)pickColor.getSelectedItem();
		if(name.equals("Red")){
			return Color.RED;
		}else if(name.equals("Blue")){
			return Color.BLUE;
		}else if(name.equals("Green")){
			return Color.GREEN;
		}else{
			return Color.BLACK;
		}
	}
	
	//called everytime user clicks mouse
	public void mouseClicked(MouseEvent e){
		GObject obj;
		double diam=getDiamSize();
		if(checkbox.isSelected()){
			obj=new GFace(diam,diam);
		}else{
			obj=new GOval(diam,diam);
		}
		obj.setColor(getCurrentColor());
		add(obj,e.getX(),e.getY());
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("Clear")){
			removeAll(); //clear canvas
		}
	}
	
	/* Private constants */
	private static final double SMALL_DIAM=20;
	private static final double MED_DIAM=40;
	private static final double LARGE_DIAM=60;
	
	/* Private instance variables */
	// Use instance variables to keep track of interactors whose
	// "state" you need to check as your program runs
	private JCheckBox checkbox;
	private JRadioButton smallRB,medRB,largeRB;
	private JComboBox pickColor;
}
