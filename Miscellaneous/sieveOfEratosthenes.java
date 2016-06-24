/*
 * File:sieveOfEratosthenes.java
 * -----------------------------
 * This program uses sieve of Eratosthenes Algorithm to find out prime numbers.
 */
import acm.program.*;

public class sieveOfEratosthenes extends ConsoleProgram{
	private static final int UPPER_LIMIT=1000;
	
	public void run(){
		int ar[]=new int[UPPER_LIMIT];
		ar[0]=0;
		for(int i=1;i<ar.length;i++){
			ar[i]=i+1;
		}
		for(int i=1;i<ar.length;i++){
			for(int j=i+1;j<ar.length;j++){
				if(ar[i]!=0){
					if(ar[j]%ar[i]==0){
						ar[j]=0;
					}
				}
			}
		}
		for(int i=1;i<ar.length;i++){
			if(ar[i]!=0){
				println(ar[i]);
			}
		}
	}
}
