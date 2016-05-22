/*
 * File: BouncingBall.java
 * ----------------------------
 * This program graphically simulates a bouncing ball.
 * User needs to click on the screen once to start the simulation.
 * On each collision with the ground the ball changes its color randomly.
 */

import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;

public class BouncingBall extends GraphicsProgram{
	
	/**Size(diameter) of the ball.*/
	private static final int DIA_BALL=30;
	
	/**Amount Y velocity is increased or decreased in moving upwards
	 * or downwards due to gravity.*/
	private static final double GRAVITY=3.0;
	
	/**Animation delay or pause time between ball moves.*/
	private static final int DELAY=50;
	
	/**Amount Y velocity is reduced as a result of collision.*/
	private static final double BOUNCE_REDUCE=0.9;
	
	/**Initial X and Y locations of the ball.*/
	private static final double X_START=0;
	private static final double Y_START=0;
	
	/**X and Y velocities. X velocity remains constant till the end.*/
	private static final double X_VEL=5; 
	private static double Y_VEL=0;
	
	/**private instance variable.*/
	private GOval ball;
	
	public void run(){
		setup();
		waitForClick(); //wait for user's click to start the simulation.
		
		//Simulation ends when the ball goes off right hand.
		//end of screen.
		while(ball.getX()<getWidth()){
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	//creates and places ball on the canvas.
	//color is selected randomly.
	private void setup(){
		ball= new GOval(X_START,Y_START,DIA_BALL,DIA_BALL);
		ball.setFilled(true);
		add(ball);
		ball.setColor(rgen.nextColor());
	}

	//update and moves ball.
	private void moveBall(){
		//increase or decrease Y velocity due to gravity in
		//moving downwards or upwards.
		Y_VEL+=GRAVITY;
		ball.move(X_VEL,Y_VEL);
	}
	
	/**Determine if collosion with the floor, update velocities, change color randomly
	 * and location as appropriate.*/
	private void checkForCollision(){
		
		//determine if the ball has dropped below the floor.
		if(ball.getY()>(getHeight()-DIA_BALL)){
			
			//change ball's Y velocity now to bounce upwards
			Y_VEL=-Y_VEL*BOUNCE_REDUCE;
			
			//assume bounce will move ball an amount above the 
			//floor equal to the amount it would have dropped below the floor.
			double diff=ball.getY()-(getHeight()-DIA_BALL);
			ball.move(0,-2*diff);
			
			//change ball's color randomly on each collision.
			ball.setColor(rgen.nextColor());
		}
	}
	
	/**private instance variable.*/
	private RandomGenerator rgen=RandomGenerator.getInstance();
}
