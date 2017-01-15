import acm.program.*;
import acm.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SliderProgram extends GraphicsProgram{
	public void run(){
		add(new JButton("Slide"),SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("Slide")){
			Slider slider=new Slider(SIZE,rgen.nextColor());
			add(slider,0,rgen.nextInt(0,360));
			Thread sliderThread=new Thread(slider);
			sliderThread.start();
		}
	}
	
	private static final int SIZE=20;
	
	private RandomGenerator rgen=RandomGenerator.getInstance();
}