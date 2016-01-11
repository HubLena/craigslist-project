package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.math.*;

//sample input
//9
//-100
//50
//0
//56.6
//90
//0.12
//.12
//02.34
//000.000

//output

//90
//56.6
//50
//02.34
//0.12
//.12
//0
//000.000
//-100
public class BigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.next();
        }

        //Write your code here
        ArrayList<String> s2=new ArrayList<String>(n);
        for(int i=0;i<n;i++)
        {
            s2.add(s[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
//                BigDecimal bd1=new BigDecimal(s[i]);
//                BigDecimal bd2=new BigDecimal(s[j]);
//
//                if(bd2.compareTo(bd1)<0){
//                    String temp=s[j];
//                    s[j]=s[i];
//                    s[i]=temp;
//                }
//
//                if(bd1.compareTo(bd2)==0 && s2.indexOf(s[i])<s2.indexOf(s[j]))
//                {
//                    String temp=s[j];
//                    s[j]=s[i];
//                    s[i]=temp;
//                }
            }
        }


        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }

    }


}