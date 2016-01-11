package miscellaneous;

import java.util.Scanner;

//you are given an array of n integers. A sub-array is "Negative" 
//if sum of all the integers in that sub-array is negative.
//Count the number of "Negative sub-arrays" in the input array.

//Note: Subarrays are contiguous chunks of the main array.
//For example if the array is {1,2,3,5} then some of the subarrays are
//{1}, {1,2,3}, {2,3,5}, {1,2,3,5} etc. But {1,2,5} is not an subarray as it is not contiguous.
//input

//5
//1 -2 4 -5 1

//output
//9
//
//[0:1]
//[0:3]
//[0:4]
//[1:1]
//[1:3]
//[1:4]
//[2:3]
//[3:3]
//[3:4]

public class JavaArray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    int count = 0;

		    for (int i = 0; i < n; i++) {
		        if (sc.hasNextInt()) { arr[i] = sc.nextInt(); }
		        int sum = 0;
		        for (int j = i; j < n; j++) {
		            if (sc.hasNextInt()) {
		            arr[j + 1] = sc.nextInt();
		            }
		            sum += arr[j];
		            if (sum < 0) { count++; }
		        }
		    }

		    System.out.println(count);
		    }
		}
