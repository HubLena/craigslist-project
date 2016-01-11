package miscellaneous;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan=new Scanner(System.in);
		 String A=scan.next();
		System.out.println( A.equals( new StringBuilder(A).reverse().toString()) 
			    ? "Yes" : "No" );
	}

}
