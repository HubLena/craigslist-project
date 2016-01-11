package miscellaneous;

import java.util.Scanner;

public class ReadInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc=new Scanner(System.in);

	        //loops while there are int inputs
	        while(sc.hasNextInt()){
	            int a=sc.nextInt();
	            System.out.println(a);
	        }
	    }

}
