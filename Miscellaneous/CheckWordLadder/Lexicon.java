/*
 * File:Lexicon.java
 * -----------------
 * This class contains method which takes a word(String) and returns true if
 * that word is present in the lexcion file.
 * Dictionary file-"english.txt"
 * All words in lexicon file are in uppercase.
 */

import acm.util.*;
import java.io.*;

public class Lexicon {
	public Lexicon(String filename){
		file=filename;
	}
	
	public boolean isEnglishWord(String str) throws FileNotFoundException{
		rd=new BufferedReader(new FileReader(file));
		try{
			while(true){
				String word=rd.readLine();
				if(word==null) break;
				if(word.equals(str)){
					return true;
				}
			}
			rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);
		}
		return false;
	}
	
	private String file;
	private BufferedReader rd;
}

