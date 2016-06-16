import acm.program.*;
import acm.graphics.*;

public class DrawHouse extends GraphicsProgram{
	
	private static final double BODY_WIDTH=400;
	private static final double BODY_HEIGHT=300;
	private static final double TRI_HEIGHT=BODY_HEIGHT/3;
	private static final double GATE_WIDTH=BODY_WIDTH/7;
	private static final double GATE_HEIGHT=BODY_HEIGHT/3;
	private static final double PANE_WIDTH=BODY_WIDTH/16;
	private static final double PANE_HEIGHT=BODY_HEIGHT/8;
	private static final double posX=125;
	private static final double posY=125;
	
	public void run(){
		drawTriangle();
		drawBody();
		drawWindows();
		drawGate();
	}
	
	private void drawTriangle(){
		GPolygon triangle= new GPolygon();
		triangle.addVertex(0,-TRI_HEIGHT/2);
		triangle.addVertex(-BODY_WIDTH/2,TRI_HEIGHT/2);
		triangle.addVertex(BODY_WIDTH/2,TRI_HEIGHT/2);
		add(triangle,posX+BODY_WIDTH/2,posY-TRI_HEIGHT/2);
	}
	
	private void drawBody(){
		GRect body=new GRect(BODY_WIDTH,BODY_HEIGHT);
		add(body,posX,posY);
	}
	
	private void drawWindows(){
		drawFourPaneWindows();
		drawSixPaneWindows();
	}
	
	private void drawFourPaneWindows(){
		//left window
		TwoPanes pane1=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane1,posX+BODY_WIDTH/4-PANE_WIDTH,posY+BODY_HEIGHT/2-2.5*PANE_HEIGHT);
		TwoPanes pane2=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane2,posX+BODY_WIDTH/4,posY+BODY_HEIGHT/2-2.5*PANE_HEIGHT);
		//right window
		TwoPanes pane3=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane3,posX+BODY_WIDTH*3/4.0-PANE_WIDTH,posY+BODY_HEIGHT/2-2.5*PANE_HEIGHT);
		TwoPanes pane4=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane4,posX+BODY_WIDTH*3/4.0,posY+BODY_HEIGHT/2-2.5*PANE_HEIGHT);
		
	}

	private void drawSixPaneWindows(){
		//left window
		TwoPanes pane1=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane1,posX+BODY_WIDTH/4-PANE_WIDTH*1.5,posY+BODY_HEIGHT-3*PANE_HEIGHT);
		TwoPanes pane2=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane2,posX+BODY_WIDTH/4-PANE_WIDTH*0.5,posY+BODY_HEIGHT-3*PANE_HEIGHT);
		TwoPanes pane3=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane3,posX+BODY_WIDTH/4+PANE_WIDTH*0.5,posY+BODY_HEIGHT-3*PANE_HEIGHT);
		//right window
		TwoPanes pane4=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane4,posX+BODY_WIDTH*3/4.0-PANE_WIDTH*1.5,posY+BODY_HEIGHT-3*PANE_HEIGHT);
		TwoPanes pane5=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane5,posX+BODY_WIDTH*3/4.0-PANE_WIDTH*0.5,posY+BODY_HEIGHT-3*PANE_HEIGHT);
		TwoPanes pane6=new TwoPanes(PANE_WIDTH,PANE_HEIGHT);
		add(pane6,posX+BODY_WIDTH*3/4.0+PANE_WIDTH*0.5,posY+BODY_HEIGHT-3*PANE_HEIGHT);
	}
	
	
	private void drawGate(){
		GRect gate=new GRect(GATE_WIDTH,GATE_HEIGHT);
		add(gate,posX+BODY_WIDTH/2-GATE_WIDTH/2,posY+BODY_HEIGHT-GATE_HEIGHT);
		GOval circle=new GOval(GATE_WIDTH/6,GATE_WIDTH/5);
		add(circle,posX+BODY_WIDTH/2+GATE_WIDTH/6,posY+BODY_HEIGHT-GATE_HEIGHT/2-GATE_WIDTH/5);
	}
}
