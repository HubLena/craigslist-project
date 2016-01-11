package testing_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Strings {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String A = "hello";
		String B = "java";
		int lenght = (int) (A.length() + B.length());
		System.out.println("The length is: " + lenght);
		
		if ((int) A.charAt(0)> (int) B.charAt(0))
		{
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		System.out.println("The second try: " + ((A.compareTo(B)>0) ? "Yes" : "No"));
		System.out.print(A.toUpperCase().charAt(0) + A.substring(1) + " " + B.toUpperCase().charAt(0) + B.substring(1));
		
	}
	
	
}