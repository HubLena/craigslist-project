package testing_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSubstring {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	    String main=scan.next();
	    int subLength=scan.nextInt();
	    
			List<String> myWords = new ArrayList<String>();
			//myWords = Arrays.asList(wordArray);
			for (int i=0; i<main.length()-subLength+1; i++)
			{
				myWords.add(main.substring(i,i+subLength));
			}
			Collections.sort(myWords);
			//Collection.sort(myWords);
			
			System.out.println("The smallest is: " + myWords.get(0));
			System.out.println("The largest is: " + myWords.get(myWords.size()-1));
			
	}

		public static String[] SplitWord(String text, int length) {
			
			String [] myWords = new String[text.length()-2];
			
			for (int i=0; i<text.length()-2; i++)
			{
				myWords[i]= text.substring(i,i+3);
				System.out.println( "Substrings are: " + text.substring(i,i+3));
			}
			System.out.println( "The Number of array is: " + myWords.length);
			return myWords;
	}
	}


