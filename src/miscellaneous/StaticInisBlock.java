package miscellaneous;

import java.util.Scanner;

public class StaticInisBlock {

	static boolean  flag;
	static int B,H;
	static int area=1;

//	Scanner sc = new Scanner(System.in);
//     B=sc.nextInt();
//     H=sc.nextInt();
     
	static {
	if(B>0 && H>0)
	    {
		try
		{
			 flag = true;
		}catch (Exception e)
		{
			 System.out.println("Breadth and height must be positive");
		}
	   
	    }else
	    {
	    	 System.out.println("java.lang.Exception: Breadth and height must be positive");
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class
