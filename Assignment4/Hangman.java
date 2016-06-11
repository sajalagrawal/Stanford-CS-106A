/*
 * File: Hangman.java
 * ------------------
 * Author- SAJAL AGRAWAL
 * @sajal.agrawal1997@gmail.com
 * ---------------------------------
 * This program will eventually play the Hangman game.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {

	/*Private instance variables.*/
	private HangmanCanvas canvas;
	private HangmanLexicon hangmanWords;
	private RandomGenerator rgen=RandomGenerator.getInstance();
	
	/** Tracks the number of guesses the player has */
	private int guessCounter=8;
	
	//This is the word being guessed
	private String hiddenWord;
	    
    //This is the secret word
	private String word = pickRandomWord();
		
	//This is the latest character entered by the user
	private char ch;
	
	//This string keeps track of all the incorrect guessed letters
	private String incorrectLetters = "";
	
    public void run() {
		setupGame();
		playGame();
	}
    
    /*Set up the game by displaying the welcome message, 
     *how many letters there are in the word, 
     *and how many guesses the user has
     */
    private void setupGame(){
    	canvas.reset();
    	hiddenWord=showDashes();
    	canvas.displayWord(hiddenWord);
    	println("Welcome to HANGMAN!");
    	println("Your word now looks like this: "+hiddenWord);
    	println("You have "+guessCounter+" guesses left.");
    }
    
    /**Shows how many letters there are in the word as part of game setup*/
    private String showDashes(){
    	String res="";
    	for(int i=0;i<word.length();i++){
    		res+="-";
    	}
    	return res;
    }
    
    /**Generates a random word selected from the HangmanLexicon.*/
    private String pickRandomWord(){
    	hangmanWords=new HangmanLexicon();
    	return(hangmanWords.getWord(rgen.nextInt(0,hangmanWords.getWordCount()-1)));
    }
    
    private void playGame(){
    	while(guessCounter>0){
    		String guess=readLine("Your guess: ");
        	while(true){
        		if(guess.length()>1){
            		guess=readLine("You can guess only one letter at a time! Try again: ");
            	}
        		if(guess.length()==1){
        			break;
        		}
        	}
        	ch=guess.charAt(0);
        	ch=Character.toUpperCase(ch);
        	letterCheck();
        	if(hiddenWord.equals(word)){
        		println("You guessed the word: "+word);
        		println("YOU WIN!");
        		break;
        	}
        	println("The word now looks like this: "+hiddenWord);
        	println("You have "+guessCounter+" guesses left.");
    	}
    	if(guessCounter==0){
    		println("You're completely hung.");
    		println("The word was: "+word);
    		println("YOU LOSE!");
    	}
    }
    
    /**Updates the hiddenWord if the character entered is correct.*/
    private void letterCheck(){
    	if(word.indexOf(ch)==-1){
    		println("There are no "+ch+"'s in the word.");
    		guessCounter--;
    		incorrectLetters+=ch;
    		canvas.noteIncorrectGuess(incorrectLetters);
    	}
    	if(word.indexOf(ch)!=-1){
    		println("That guess is correct.");
    		for(int i=0;i<word.length();i++){
    			if(ch==word.charAt(i)){
    				if(i==0){
    					hiddenWord=ch+hiddenWord.substring(1);
    				}
    				if(i>0){
    					hiddenWord=hiddenWord.substring(0,i)+ch+hiddenWord.substring(i+1);
    				}
    			}
    		}
    		canvas.displayWord(hiddenWord);
    	}
    	
    }
    
    public void init(){
    	canvas = new HangmanCanvas();
    	add(canvas);
    }

}
