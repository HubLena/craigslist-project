package miscellaneous;

import java.util.Scanner;

//Given an input integer, you must determine which primitive
//data types are capable of properly storing that input.
//sample input

//5
//-150
//150000
//1500000000
//213333333333333333333333333333333333
//-100000000000000

//
//sample output
//-150 can be fitted in:
//* short
//* int
//* long
//150000 can be fitted in:
//* int
//* long
//1500000000 can be fitted in:
//* int
//* long
//213333333333333333333333333333333333 can't be fitted anywhere.
//-100000000000000 can be fitted in:
//* long


public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
	    int t=sc.nextInt();

	    for(int i=0;i<t;i++)
	    {

	        try
	        {
	            long x=sc.nextLong();
	            System.out.println(x+" can be fitted in:");
	            if(x>=-128 && x<=127)System.out.println("* byte");
	            //Complete the code
	            if(x >= -Math.pow(2, 15) && x <= Math.pow(2, 15) - 1)
	                System.out.println("* short");
	            if(x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1)
	                System.out.println("* int");
	            if(x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1)
	                System.out.println("* long");
	        }
	        catch(Exception e)
	        {
	            System.out.println(sc.next()+" can't be fitted anywhere.");
	        }

	    }
	}

}