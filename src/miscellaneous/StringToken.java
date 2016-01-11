package miscellaneous;

import java.util.Scanner;

public class StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String delim = "[ .,?!'@#]+%^&*()<>/=-_";
		//String delim = "[_\@ !,?.']+";
		s.trim();
		if (s.length() == 0) {
			System.out.println(s.length());
		} else if (s.length() < 400000) {
			String[] arr = s.split(delim);
			System.out.println(arr.length);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}

	}

}
