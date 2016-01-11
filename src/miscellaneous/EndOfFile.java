package miscellaneous;

import java.util.Scanner;

public class EndOfFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int a = 1;
		
		  while(sc.hasNext()){
		        String b = sc.nextLine();
		        System.out.println(a + " " + b);
		        a++;

		    }
	}

}
