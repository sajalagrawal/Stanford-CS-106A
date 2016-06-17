import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.*;

public class GraphicNumbers extends GraphicsProgram{
	private static final double START_X=50;
	private static final double START_Y=50;
	
	public void run(){
		addMouseListeners();
	}

	public void mouseClicked(MouseEvent e){
		//create a new Label
		GLabel label=new GLabel("#"+labelList.size());
		label.setFont("Courier-18");
		
		//move all existing labels down one row
		double dy=label.getHeight();
		for(int i=0;i<labelList.size();i++){
			labelList.get(i).move(0,dy);
		}
		labelList.add(label);
		add(label,START_X,START_Y);
	}
	
	private ArrayList<GLabel> labelList=new ArrayList<GLabel>();
}
