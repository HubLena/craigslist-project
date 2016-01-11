package miscellaneous;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// input

//4
//<h1>Nayeem loves counseling</h1>
//<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>
//<Amee>safat codes like a ninja</amee>
//<SA premium>Imtiaz has a secret crush</SA premium>

//output

//Nayeem loves counseling
//Sanjay has no watch
//So wait for a while
//None
//Imtiaz has a secret crush

public class TagXMLExtractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		//String[] patt = { "<h1>(.*?)</h1>", "<par>(.*?)<par>", "<amee>(.*?)</amee>",
		//		"<SA premium>(.*?)</Sa premium>" };
		
		String[] patt = { "<h1>(.*?)</h1>", "<par>(.*)","<SA premium>(.*?)</SA premium>" };

		while (testCases > 0) {
			String line = in.nextLine();
			// Matcher m =
			// Pattern.compile("(.*)<client>(.*)</client>(.*)").matcher("<client>12345abcde</client>");
			// m.matches();
			// "<tag class=\"(.*?)\">(.*)</tag>"
			// Write your code here
			// String pattern = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*"; - remove
			// duplicates
			for (String pattern : patt) {
				Pattern p = Pattern.compile(pattern, Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(line);
				String output="";
				while (m.find()) {
					if (m.group(1).contains("<h1>"))
					{
						output = m.group(1).replaceFirst("<h1>", "");
					}else if (m.group(1).contains("<par>")){
						output ="None";
					}
					else{
						output = m.group(1).trim();
					}
					
					System.out.println(output);
				}
			}
			testCases--;
		}
	}

}
