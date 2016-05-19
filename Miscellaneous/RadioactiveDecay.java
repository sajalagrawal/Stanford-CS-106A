/*
 * File: RadioactiveDecay.java
 * ---------------------------------
 * This program simulates the decay of a radioactive atom
 * until all the atoms are decayed.
 */

import acm.program.*;
import acm.util.*;

public class RadioactiveDecay extends ConsoleProgram{
	
	/*Initial number of atoms. */
	private static final int INI_ATOMS=10000;
	
	public void run(){
		int count=0,atoms,decayed,i;
		atoms=INI_ATOMS;
		println("There are "+INI_ATOMS+" atoms initially.");
		while(true){
			decayed=0;
			for(i=0;i<atoms;i++){
				boolean ifdecay=rgen.nextBoolean();
				if(ifdecay==true)
					decayed++;
			}
			count++;
			atoms=atoms-decayed;
			println("There are "+atoms+" atoms at the end of year "+count);
			if(atoms==0){
				break;
			}
		}
	}
	
	/*private instance variable. */
	private RandomGenerator rgen=RandomGenerator.getInstance();
}
