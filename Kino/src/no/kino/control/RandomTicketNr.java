
package no.kino.control;

import java.util.Random;

public class RandomTicketNr {

	  String randomTicket = getLetters(4) + getNumebers(2);
	  public String getLetters(int len) {
	    char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
	        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
	        'Y', 'Z'};
	    char[] c=new char[len];
	    Random random=new Random();
	    for (int i = 0; i < len; i++) {
	      c[i]=ch[random.nextInt(ch.length)];
	    }
	    
	    return new String(c);
	  }
	  
	  public String getNumebers(int len) {
		    char [] nu = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		    char[] n=new char[len];
		    Random random=new Random();
		    for (int i = 0; i < len; i++) {
		      n[i]=nu[random.nextInt(nu.length)];
		    }
		    
		    return new String(n);
		  }
	  
	}
