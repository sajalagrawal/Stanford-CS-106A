/*
 * File: Slider.java
 * -----------------------
 * This class is an example of a runnable class that
 * animates a square sliding across the screen.
 */

import acm.graphics.*;
import java.awt.*;

public class Slider extends GRect implements Runnable {
	
	public Slider(int size, Color color) {
		super(size, size); // calls GRect constructor to set width, height
		setFilled(true);
		setColor(color);
	}
	
	public void run() {
		// animate a slide across the screen
		for(int i = 0; i < 1000/STEP; i++) {
			pause(40);
			move(STEP, 0);
		}
	}

	/* constants */
	private static final double STEP = 5;
}