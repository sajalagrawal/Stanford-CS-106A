import acm.program.*;
import acm.graphics.*;  //for GCanvas
import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //for gridLayout

public class TextAndGraphics extends ConsoleProgram{
	public void init(){
		setLayout(new GridLayout(1,3));
		
		//Note:console is the first element of our layout.
		
		leftCanvas=new GCanvas();
		add(leftCanvas);
		
		rightCanvas=new GCanvas();
		add(rightCanvas);
		
		textField=new JTextField(10);
		add(new JLabel("Some text"),SOUTH);
		add(textField,SOUTH);
		textField.addActionListener(this);
		
		add(new JButton("Draw Left"),SOUTH);
		add(new JButton("Draw Right"),SOUTH);
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==textField){
			println("You typed:"+textField.getText());
		}
		String cmd=e.getActionCommand();
		if(cmd.equals("Draw Left")){
			leftCanvas.add(drawFilledRect(),20,leftY);
			leftY+=SPACER;
		}else if(cmd.equals("Draw Right")){
			rightCanvas.add(drawFilledRect(),20,rightY);
			rightY+=SPACER;
		}
	}
	
	private GRect drawFilledRect(){
		GRect rect = new GRect(rectWidth,rectHeight);
		rect.setFilled(true);
		return rect;
	}
	
	/*constants*/
	private static final double SPACER=30;
	private static final double rectWidth=50;
	private static final double rectHeight=20;
	
	private double leftY=10;
	private double rightY=10;
	
	/*private instance variables*/
	private GCanvas leftCanvas;
	private GCanvas rightCanvas;
	private JTextField textField;
}
