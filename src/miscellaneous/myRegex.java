package miscellaneous;

import java.util.regex.Pattern;

//IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
//Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.


// input					output
//000.12.12.034				true
//121.234.12.12				true
//23.45.12.56				true
//00.12.123.123123.123		false
//122.23					false
//Hello.IP					false

//	^		#start of the line
//	(		#  start of group #1
//	  [01]?\\d\\d? #    Can be one or two digits. If three digits appear, it must start either 0 or 1
//			#    e.g ([0-9], [0-9][0-9],[0-1][0-9][0-9])
//	   |		#    ...or
//	  2[0-4]\\d	#    start with 2, follow by 0-4 and end with any digit (2[0-4][0-9]) 
//	   |           #    ...or
//	  25[0-5]      #    start with 2, follow by 5 and ends with 0-5 (25[0-5]) 
//	)		#  end of group #2
//	 \.            #  follow by a dot "."
//	....            # repeat with 3 times (3x)
//	$		#end of the line

public class myRegex {

	 private Pattern pattern;
	 
	 static final String IPADDRESS_PATTERN = 
				"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	 public void IPAddressValidator(){
		  pattern = Pattern.compile(IPADDRESS_PATTERN);
	    }
}
