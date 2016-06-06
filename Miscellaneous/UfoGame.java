/*
 * File: UfoGame.java 
 * ------------------ 
 * This program plays a game where the user tries to 
 * shoot a UFO before the UFO "lands". 
 * NOTE: Include the audio file "collision.au".
 */

import acm.program.*;
import acm.util.MediaTools;
import acm.graphics.*;

import java.applet.AudioClip;
import java.awt.*; //for color
import java.awt.event.*; //for mouse events

public class UfoGame extends GraphicsProgram{
	/*Size and speed of UFO.*/
	private static final int UFO_WIDTH=40;
	private static final int UFO_HEIGHT=UFO_WIDTH/2;
	private static final int UFO_SPEED=5;
	
	/*size and speed of bullets.*/
	private static final int BULLET_SPEED=10;
	private static final int BULLET_DIAM=5;
	
	/*Animation cycle delay.*/
	private static final int DELAY=10;
	
	public void run(){
		setup();
		addMouseListeners();	
		while(!gameOver()){
			moveUfo();
			moveBullet();
			checkForCollision();
			pause(DELAY);
		}
		if(gameOver()){
			printGameOver();
		}
	}
	
	/*Setup UFO.*/
	private void setup(){
		ufo=new GRect(UFO_WIDTH,UFO_HEIGHT);
		ufo.setFilled(true);
		add(ufo,getWidth(),0);
		ufoToLeft=true;
	}
	
	/** determines if game is over -- true if the UFO lands */
	private boolean gameOver(){
		if(ufo.getY()>=getHeight()-UFO_HEIGHT){
			pause(1000);
			remove(ufo);
			return true;
		}
		return false;
	}
	
	/** moves UFO, if UFO has moved to edge of screen, moves
	* UFO down and changes UFO direction.
	*/
	private void moveUfo(){
		if(ufoToLeft){
			ufo.move(-UFO_SPEED, 0);
			if(ufo.getX()<=0){
				ufoToLeft=false;
				ufo.move(0,UFO_HEIGHT);
			}
		}
		else{
			ufo.move(UFO_SPEED,0);
			if(ufo.getX()>=getWidth()){
				ufoToLeft=true;
				ufo.move(0, UFO_HEIGHT);
			}
		}
	}
	
	/** when mouse is clicked create bullet, unless a bullet
	* already exists.
	*/
	public void mouseClicked(MouseEvent e){
		if(bullet==null){
			bullet= new GOval(BULLET_DIAM,BULLET_DIAM);
			bullet.setFilled(true);
			bullet.setColor(Color.RED);
			double x=getWidth()/2-BULLET_DIAM/2;
			double y=getHeight();
			add(bullet,x,y);
		}
	}
	
	/**moves bullet.*/
	private void moveBullet(){
		if(bullet!=null){
			bullet.move(0,-BULLET_SPEED);
		}
	}
	
	/**Check for bullet colliding with the UFO.*/
	private void checkForCollision(){
		if(bullet!=null){
			GObject obj=getElementAt(bullet.getX(),bullet.getY());
			if(obj==ufo){
				//plays the audio clip.
				collision.play();
				remove(ufo);
				remove(bullet);
				bullet=null;
				ufo=null;
				printWinner();
				exit();
			}
			moveOffScreen();
		}
	}
	
	/** determines if bullet has moved of screen,
	* if it has, removes bullet, sets variable to null
	*/
	private void moveOffScreen(){
		if(bullet.getY()<=-BULLET_DIAM){
			remove(bullet);
			bullet=null;
		}
	}
	
	/**If the UFO is destroyed by the bullet this method 
	 * prints a winner message.*/
	private void printWinner(){
		GLabel win=new GLabel("YOU WIN!");
		win.setFont("Times New Roman-32");
		double x=getWidth()/2-win.getWidth()/2;
		double y=getHeight()/2-win.getAscent()/2;
		add(win,x,y);
		GLabel exit=new GLabel("CLICK TO EXIT...");
		exit.setFont("Times New Roman-24");
		add(exit,getWidth()/2-exit.getWidth()/2,getHeight()-exit.getAscent()*2);
		waitForClick();
	}
	
	/**Prints a game over message.*/
	private void printGameOver(){
		GLabel gameOver=new GLabel("GAME OVER!");
		gameOver.setFont("Times New Roman-32");
		double x=getWidth()/2-gameOver.getWidth()/2;
		double y=getHeight()/2-gameOver.getAscent()/2;
		add(gameOver,x,y);
		GLabel exit=new GLabel("CLICK TO EXIT...");
		exit.setFont("Times New Roman-24");
		add(exit,getWidth()/2-exit.getWidth()/2,getHeight()-exit.getAscent()*2);
		waitForClick();
	}
	
	/*private instance variables.*/
	private GRect ufo;
	private GOval bullet;
	private boolean ufoToLeft;    //when true, UFO is moving to left
	
	//used for adding an audio clip when bullet collides with UFO.
	AudioClip collision = MediaTools.loadAudioClip("collision.au");
}
