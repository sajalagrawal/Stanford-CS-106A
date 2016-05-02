/* File: Calendar.java
 * ----------------
 * This program draws a calendar. 
 */

import acm.program.*;
import acm.graphics.*;

public class Calendar extends GraphicsProgram {
		/* The number of days in the month */
		private static final int DAYS_IN_MONTH = 31;
		
		/* The day of the week on which the month starts */
		/* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
		private static final int DAY_MONTH_STARTS = 5;
		
		/* The width in pixels of a day on the calendar */
		private static final int DAY_WIDTH = 80;
		
		/* The height in pixels of a day on the calendar */
		private static final int DAY_HEIGHT = 60;
		
		public void run(){
			int rows,i,j;
			int boxes = DAYS_IN_MONTH + DAY_MONTH_STARTS;
			if((float)boxes/7 > boxes/7)
				rows = boxes/7 + 1;
			else
				rows = boxes/7;
			int day=1;
			for(i=0;i<rows;i++){
				for(j=0;j<7;j++){
					double x = j*DAY_WIDTH;
					double y = i*DAY_HEIGHT;
					GRect box = new GRect(x,y,DAY_WIDTH,DAY_HEIGHT);
					add(box);
					if((i>0 || j>=DAY_MONTH_STARTS) && day<=DAYS_IN_MONTH){
						GLabel date =  new GLabel(""+day);
						y = y + date.getAscent();
						add(date,x+3,y+3);
						day++;
					}
				}
			}
		}
}
