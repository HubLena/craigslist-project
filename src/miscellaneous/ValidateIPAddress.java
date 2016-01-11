package miscellaneous;

import java.util.Scanner;

//IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
//Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

public class ValidateIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        while(in.hasNext())
	        {
	            String IP = in.next();
	            System.out.println(IP.matches(new myRegex().IPADDRESS_PATTERN ));
	        
	    }

	}

}
