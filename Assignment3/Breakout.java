/*
* File: Breakout.java
* -------------------
* AUTHOR: SAJAL AGRAWAL. 
* @sajal.agrawal1997@gmail.com
* ---------------------------------
* This file will eventually implement the game of Breakout.
*/

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {
	
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;
	
	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;
	
	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;
	
	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;
	
	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;
	
	/** Separation between bricks */
	private static final int BRICK_SEP = 4;
	
	/** Width of a brick */
	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
	
	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;
	
	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;
	
	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;
	
	/** Number of turns */
	private static final int NTURNS = 3;
	
	/**Ball velocity*/
	private double vx,vy;
	
	/**Random number generator for vx*/	
	private RandomGenerator rgen=RandomGenerator.getInstance();
	
	/** Animation delay or pause time between ball moves */	
	private static final int DELAY=10;
	
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		for(int i=0;i<NTURNS;i++){
			//keeps track the number of times the ball hits the paddle.
			counter=0;
			//to initialize number of bricks on each turn.
			brickCounter=100;
			//initialize score on each turn.
			score=0;
			currentScore=new GLabel("Score: "+score);
			add(currentScore,getWidth()/2-PADDLE_WIDTH/2,getHeight()-PADDLE_Y_OFFSET+currentScore.getAscent());
			//displays the number of bricks left.
			bricks=new GLabel("Bricks Left: "+brickCounter);
			add(bricks,25,getHeight()-5);
			setupGame();
			playGame();	
			if(brickCounter==0){
				removeAll();
				printWinner();
				break;
			}
			//Removes all the bricks if the ball hits the lower wall so that 
			//if the player has any chances left then the new bricks created are 
			//not superimposed on the previous ones. Instead previous ones are 
			//removed and new ones added.
			if(brickCounter > 0) {
				removeAll();
			}
			remove(paddle);
		}
		if(brickCounter>0){
			removeAll();
			printGameOver();
		}
	}
	
	//GLabel object counter for displaying remaining bricks.
	private GLabel bricks;
	
	//drawing and setting up game objects.
	private void setupGame(){
		setupBricks();
		setupPaddle();
		setupBall();
	}
	
	//adding an individual brick object
	private GRect brick;
	
	//drawing and setting up all the bricks necessary for the game
	private void setupBricks(){
		
		/*need to have several columns in each row
		 * so there need to be two for loops, 
		 * one for loop for the rows and one for loop for the columns.
		 */ 
		
		for(int row=0;row<NBRICK_ROWS;row++){
			
			for(int column=0;column<NBRICKS_PER_ROW;column++){
				
				/* To get the x coordinate for the starting width:
				 * 	start at the center width, 
				 * 	subtract half of the bricks (width) in the row,  
				 * 	subtract half of the separations (width) between the bricks in the row,
				 *  now you're at where the first brick should be, 
				 *  so for the starting point of the next bricks in the column, you need to: 
				 * 	add a brick width 
				 * 	add a separation width
				 */
				double x=getWidth()/2-NBRICKS_PER_ROW*BRICK_WIDTH/2.0-(NBRICKS_PER_ROW-1)*BRICK_SEP/2.0+column*(BRICK_WIDTH+BRICK_SEP);
				
				/* To get the y coordinate of the starting height:
				 * 	start at the given length from the top for the first row,
				 * 	then add a brick height and a brick separation for each of the following rows
				 */
				double y=BRICK_Y_OFFSET+row*BRICK_HEIGHT+row*BRICK_SEP;
				brick=new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
				brick.setFilled(true);
				add(brick);
				
				//Setting colors depending on which row the bricks are in
				if(row==0 || row==1)
					brick.setColor(Color.RED);
				if(row==2 || row==3)
					brick.setColor(Color.ORANGE);
				if(row==4 || row==5)
					brick.setColor(Color.YELLOW);
				if(row==6 || row==7)
					brick.setColor(Color.GREEN);
				if(row==8 || row==9)
					brick.setColor(Color.CYAN);
			}
		}
	}
	
	//adding individual paddle object
	private GRect paddle;
	
	//creating and setting up of the paddle.
	private void setupPaddle(){
		//starting the paddle in the middle of the screen
		double x=getWidth()/2-PADDLE_WIDTH/2;
		//the paddle height stays consistent throughout the game
		//need to make sure to subtract the PADDLE_HEIGHT, 
		//since the rectangle gets drawn from the top left corner
		double y=getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT;
		paddle=new GRect(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.GRAY);
		add(paddle);
		//to be able to control paddle using mouse.
		addMouseListeners();
	}
	
	//making the mouse track the paddle
	public void mouseMoved(MouseEvent e){
		
		/* The mouse tracks the middle point of the paddle, 
		 * the x location of the paddle is set at where the mouse is minus half a paddle's width, 
		 * and the height remains the same
		 */
		if((e.getX()<=getWidth()-PADDLE_WIDTH/2) && (e.getX()>=PADDLE_WIDTH/2)){
			paddle.setLocation(e.getX()-PADDLE_WIDTH/2,getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
			currentScore.setLabel("Score: "+score);
			currentScore.setLocation(e.getX()-PADDLE_WIDTH/2,getHeight()-PADDLE_Y_OFFSET+currentScore.getAscent());
		}
	}
	
	//adding an individual ball object
	private GOval ball;
	
	//creating and setting up of the ball.
	private void setupBall(){
		double x=getWidth()/2-BALL_RADIUS;
		double y=getHeight()/2-BALL_RADIUS;
		ball=new GOval(x,y,BALL_RADIUS*2,BALL_RADIUS*2);
		ball.setFilled(true);
		ball.setColor(Color.GRAY);
		add(ball);
	}
	
	private void playGame(){
		//adds a message.
		GLabel clickToStart=new GLabel("CLICK ANYWHERE TO START.");
		add(clickToStart,getWidth()/2-clickToStart.getWidth()/2,getHeight()/2-2*clickToStart.getAscent());
		pause(1000);
		remove(clickToStart);
		//waits for user to click to start the game.
		waitForClick();
		//sets up the initial ball velocity.
		vx=rgen.nextDouble(1.0,3.0);
		vy=3.0;
		//half of the times ball goes on left half of the screen and other times on right half at the start.
		if(rgen.nextBoolean(0.5)){
			vx=-vx;
		}
		while(true){
			moveBall();
			
			if(ball.getY()>=getHeight()){
				break;
			}
			if(brickCounter==0){
				break;
			}
		}
	}
	
	/**Returns the object to which the ball collides if any otherwise "null".*/
	private GObject getCollidingObject(){
		if(getElementAt(ball.getX(),ball.getY())!=null)
			return getElementAt(ball.getX(),ball.getY());
		else if(getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY())!=null)
			return getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY());
		else if(getElementAt(ball.getX(),ball.getY()+2*BALL_RADIUS)!=null)
			return getElementAt(ball.getX(),ball.getY()+2*BALL_RADIUS);
		else if(getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY()+2*BALL_RADIUS)!=null)
			return getElementAt(ball.getX()+2*BALL_RADIUS,ball.getY()+2*BALL_RADIUS);
		//need to return null if there are no objects present
		else
			return null;
	}
	
	//keeps track of the score.
	private int score;
	private GLabel currentScore;
	
	//keeps track the number of times the ball hits the paddle. 
	private int counter;
	
	private void moveBall(){
		ball.move(vx,vy);
		
		//check for walls
		//need to get vx and vy at the point closest to 0 or the other edge
		if(ball.getX()>=getWidth()-BALL_RADIUS*2  || ball.getX()<=0){
			vx=-vx;
		}
		
		//We don't need to check for the bottom wall, since the ball can fall through the wall at that point
		if(ball.getY()<=0){
			vy=-vy;
		}
		
		//check for other objects
		GObject collider=getCollidingObject();
		
		if(collider==paddle){
			counter++;
			if(ball.getY()<=getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT-BALL_RADIUS*2){
				//increasing the horizontal velocity of the ball the seventh time it hits the paddle,
				if(counter==7){
					vx=2*vx;
					counter=0;
				}
				vy=-vy;
			}
			
		}
		
		//since we lay down a row of bricks, the last brick in the brick wall is assigned the value brick.
		//so we narrow it down by saying that the collier does not equal to a paddle or null or
		//the "Bricks Left: " label, so all that is left is the brick
		else if(collider!=null && collider!=bricks && collider!=currentScore){
			//plays the audio clip.
			bounceClip.play();
			
			//generates points depending on the color of the brick the ball breaks.
			//bricks are more valuable higher up in the array, so that you get more points for red
			//bricks than cyan bricks.
			if(collider.getColor()==Color.RED){
				score+=10;
			}
			else if(collider.getColor()==Color.ORANGE){
				score+=9;
			}
			else if(collider.getColor()==Color.YELLOW){
				score+=8;
			}
			else if(collider.getColor()==Color.GREEN){
				score+=7;
			}
			else if(collider.getColor()==Color.CYAN){
				score+=6;
			}
			remove(collider);
			brickCounter--;
			//updates the "Bricks Left: " counter on the screen.
			bricks.setLabel("Bricks Left: "+brickCounter);
			vy=-vy;
		}
		pause(DELAY);
	}
	
	/**This variable keeps track of the number of bricks remaining.*/
	private int brickCounter=NBRICKS_PER_ROW*NBRICK_ROWS;
	
	//creates a GLabel object used to display final score.
	private GLabel endScore;
	
	/**prints game over if the player loses and also displays the score.*/
	private void printGameOver(){
		endScore=new GLabel("YOUR SCORE:"+score);
		endScore.setColor(Color.RED);
		endScore.setFont("Times New Roman-32");
		add(endScore,getWidth()/2-endScore.getWidth()/2,getHeight()/2+endScore.getAscent());
		
		GLabel gover=new GLabel("GAME OVER");
		gover.setColor(Color.RED);
		gover.setFont("TimesNewRoman-32");
		add(gover,getWidth()/2-gover.getWidth()/2,getHeight()/2-gover.getAscent()/2);
	}

	/**prints the winner message and displays the score.*/
	private void printWinner(){
		endScore=new GLabel("YOUR SCORE:"+score);
		endScore.setColor(Color.GREEN);
		endScore.setFont("Times New Roman-32");
		add(endScore,getWidth()/2-endScore.getWidth()/2,getHeight()/2+endScore.getAscent());
		
		GLabel winner=new GLabel("YOU WIN");
		winner.setColor(Color.GREEN);
		winner.setFont("Times New Roman-32");
		add(winner,getWidth()/2-winner.getWidth()/2,getHeight()/2-winner.getAscent()/2);
	}
	
	//used for adding an audio clip each time the ball hits a brick.
	AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
}
