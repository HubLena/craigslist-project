package miscellaneous;

import java.util.Scanner;

public class If_Else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner sc=new Scanner(System.in);
		    int n=sc.nextInt();            
		    String ans;
		    if(n%2==1 || ((n>5) && (n<21)))
		    {
		    	ans = "Weird";
		    }else
		    {
		        ans = "Not Weird";                
		    }
		    System.out.println(ans);

		}

}
