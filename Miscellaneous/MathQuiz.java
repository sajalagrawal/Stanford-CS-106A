/*
 * File: MathQuiz.java
 * -------------------------
 * This program poses a series of simple arithmetic 
 * problems for a student to answer.
 * 
 * The program should meet the following requirements:
 * 
 * 1.It should ask a series of 5 questions.
 * 
 * 2.Each question should consist of a single addition or subtraction problem
 *   involving just two numbers such as "What is 2+3?" or "What is 11-7?".  The type
 *   of problem - addition or subtraction - should be chosen randomly for each question.
 *   
 * 3.To make sure the problems are appropriate for first or second graders, none of the
 *   numbers involved, including the answer, should be less than 0 or greater than 20.
 *   This restriction means that your program should never ask questions like "What is 11+13?"
 *   or "What is 4-7?" because the answers are outside the legal range.  Within these constraints
 *   your program should choose the numbers randomly.
 *  
 * 4.The program should give the students 3 chances to answer each question. 
 *   if the student gives the correct answer, your program should indicate that fact in
 *   some properly congratulatory way and go on to the next question.  If the student
 *   does not get the answer in 3 tries, the program should give the answer and go on to
 *   another problem.
 *   
 * 5. Congragulatory messages should be random.
 */

import acm.program.*;
import acm.util.*;

public class MathQuiz extends ConsoleProgram{
	
	/*Total number of questions.*/
	private static final int NUM_QUESTIONS=5;
	
	/*The lower limit for the numbers involved, including the answer.*/
	private static final int LOWER_LIMIT=0;
	
	/*The upper limit for the numbers involved, including the answer.*/
	private static final int UPPER_LIMIT=20;
	
	public void run(){
		int i,x,y,j;
		println("WELCOME TO MATH QUIZ\n");
		int score=0;
		
		/* Loops through a set number of equations. */
		for(i=0;i<NUM_QUESTIONS;){
			int answer=0;
			int response=0;
			
			 /* Generates a boolean value to be used to determine whether the equation is addition or subtraction.*/
			boolean operator=rgen.nextBoolean();
			if(operator){
				x=rgen.nextInt(LOWER_LIMIT,UPPER_LIMIT);
				y=rgen.nextInt(LOWER_LIMIT,UPPER_LIMIT-x);
				answer=x+y;
			}
			else{
				x=rgen.nextInt(LOWER_LIMIT,UPPER_LIMIT);
				y=rgen.nextInt(LOWER_LIMIT,UPPER_LIMIT);
				answer=x-y;
			}
			if(answer>=LOWER_LIMIT && answer<=UPPER_LIMIT){
				print("What is "+x+(operator?" + ":" - ")+y+" ? ");
				
				for(j=0;j<3;j++){
					/*Read the response from the student*/
					response=readInt("");
					if(response==answer){
						println(CongratulatoryMsg());
						score++;
						break;
					}
					if(j==2){
						println("You gave 3 times wrong answer! Correct answer is "+answer);
						break;
					}
					else{
						print("That's incorrect - try a different answer: ");
					}
				}
				i++;
			}
		}
		println("You gave "+score+" answers right out of "+NUM_QUESTIONS);
	}
	
	/*Method for printing congratulatory message if 
	 * the student gives the correct answer.
	 */
	private String CongratulatoryMsg(){
		int i;
		i=rgen.nextInt(0,4);
		switch(i){
		case 0:return "That's the answer!";
		case 1:return "Correct!";
		case 2:return "You got it!";
		case 3:return "Right answer!";
		case 4:return "Good job!";
		default: return "default";
		}	
	}
	
	/*private instance variable.*/
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
