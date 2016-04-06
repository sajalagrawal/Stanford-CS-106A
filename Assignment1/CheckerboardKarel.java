/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */


import stanford.karel.*;


public class CheckerboardKarel extends SuperKarel {
	
	public void run(){
		checkWall();
		while(frontIsClear()){
			putBeepersEast();
			comeBack();
		}
	}
	
	private void checkWall(){
		if(frontIsBlocked()){
			turnLeft();
			while(frontIsClear()){
				if(noBeepersPresent()){
					putBeeper();
				}
				move();
				if(frontIsClear()){
					move();
					if(noBeepersPresent()){
						putBeeper();
					}
				}
			}
		}
	}
	
	private void putBeepersEast(){
		while(frontIsClear()){
			if(noBeepersPresent())
				putBeeper();
			move();
			if(frontIsClear()){
				move();
				if(noBeepersPresent()){
					putBeeper();
				}			
			}
		}
	}
	
	private void comeBack(){
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnRight();
		if(frontIsClear()){
			if(beepersPresent()){
				move();
				turnRight();
				move();
			}
			else{
				move();
				turnRight();
			}
		}
	}
}
