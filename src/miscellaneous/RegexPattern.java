package miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2015-03-03 15:52:15,021 - [INFO] - User id '12323' ordered '1' tickets for event 'Leonore Jazz Quartet' at venue 'SF Jazz'";
		//2015-03-03 15:54:14,027 - [INFO] -Batch order of 2 tickets for venue "Casa de la Musica"
		//2015-03-03 15:54:14,027 - [INFO] -Refund of 1 tickets for venue "Casa de la Musica"
		//2015-03-03 15:54:14,027 - [INFO] -Refund of 1 tickets for venue "Casa de la Musica"
		//String input = "2015-03-03 15:54:14,027 - [INFO] -Batch order of 2 tickets for venue 'Casa de la musica'";
		//Pattern p = Pattern.compile("(clientId=)(\\d+)");
		//Pattern p = Pattern.compile("(venue\\s'(.*?)')");
				//"\\[(\\w+),\\*(\\+\\d{11})\\*].*?Called\":\"(\\+\\d{11}).*?\"Duration\":\"(\\d+)"
		Pattern p = Pattern.compile("(ordered\\s'(.*?)'\\s\\w+)(.*venue\\s'(.*?)')"); //working
		//Pattern p = Pattern.compile("(order.+'(.*?)'\\s\\w+)(.*venue\\s'(.*?)')");
		//Pattern p2 = Pattern.compile("(venue\\s'(.*?)')");
		
		//Pattern p = Pattern.compile("(order*\\w+\\d+)(.*venue\\s'(.*?)')");
	      // String pattern = ("(ordered\\s'(.*?)'\\s\\w+)(.*venue\\s'(.*?)')");

        // String pattern = ("(order\\s\\w+\\s(\\d+))(.*venue\\s\"(.*?)\")");
       // String pattern = ("(Refund\\s\\w+\\s(\\d+))(.*venue\\s\"(.*?)\")");
		
		Matcher m = p.matcher(input);

		TreeMap<String,Integer> tickets = new TreeMap<String,Integer>();
		int count = 0;
		
		while (m.find()) {
			System.out.println("Found a " + m.group(1) + ".");
			System.out.println("Found a " + m.group(2) + ".");
			System.out.println("Found a " + m.group(3) + ".");
			System.out.println("Found a " + m.group(4) + ".");
			
			count = tickets.get(m.group(4));
		
			tickets.put(m.group(4), count+1);
			
			//System.out.println("Found a " + m.group(3) + ".");
			//animals.add(m.group(0));
			//animals.add(m.group(1));
		}
		System.out.println("Match was not found");
	}

}
