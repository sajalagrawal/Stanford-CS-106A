/*
* File: CaesarCipher.java
* -----------------------
* This program translates a line of text into its Caesar cipher
* form.
*/

import acm.program.*;

public class CaeserCipher extends ConsoleProgram {
	public void run(){
		println("This program uses a Caesar Cipher for encryption.");
		int key=readInt("Enter encryption key:");
		String plaintext=readLine("Plaintext:");
		String ciphertext=encryptCaesar(plaintext,key);
		println("Ciphertext:"+ciphertext);
		String newplain=encryptCaesar(ciphertext,-key);
		println("Newplain:"+newplain);
	}

	/*
	* Encrypts a string by adding the value of key to each character.
	*/
	private String encryptCaesar(String str, int key){
		String res="";
		int i;
		for(i=0;i<str.length();i++){
			char ch=str.charAt(i);
			res+=encryptchar(ch,key);
		}
		return res;
	}
	
	/*
	* Encrypts a single character using the key given.
	* The first line makes sure that key is always positive by
	* converting negative keys to the equivalent positive shift.
	* Characters other than alphabets remains unchanged.
	*/
	private char encryptchar(char ch,int key){
		if(key<0){
			key=26+key%26;
		}
		if(Character.isUpperCase(ch)){
			return ((char)('A'+(ch-'A'+key)%26));
		}
		else if(Character.isLowerCase(ch)){
			return ((char)('a'+(ch-'a'+key)%26));
		}
		return ch;
	}
}
