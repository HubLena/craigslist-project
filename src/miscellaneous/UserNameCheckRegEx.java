package miscellaneous;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//^                    # Start of the line
//[a-z0-9_-]	     # Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
//           {3,15}  # Length at least 3 characters and maximum length of 15 
//$                    # End of the line
//"^[a-z0-9_-]{3,15}$"
public class UserNameCheckRegEx {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while(testCases>0){
	         String username = in.nextLine();
	         String pattern = ("^[A-Za-z][A-Za-z0-9_/]{8,30}$");
	        		 //("^[a-z0-9_-]{8,30}$")
	         Pattern r = Pattern.compile(pattern);
	         Matcher m = r.matcher(username);
	         
	         if (m.find( )) {
	            System.out.println("Valid");
	         } else {
	            System.out.println("Invalid");
	         }
	         testCases--;
	      }
	   }
}
