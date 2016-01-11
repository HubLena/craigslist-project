package miscellaneous;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLogFile2 {
	static LinkedHashMap<String,Integer> tickets;
	
	 public static void main(String[] args) {
		Scanner scanner = null;
		Boolean active = true;

		tickets = new LinkedHashMap<String, Integer>();

		// 2015-03-03 15:54:14,027 - [INFO] -Batch order of 2 tickets for venue
		// "Casa de la musica"
		try {
			// the input file will be provided through System.in, the scanner
			// allows you to read it line by line
			scanner = new Scanner(System.in);

			String[] pattern = { "(ordered\\s'(.*?)'\\s\\w+)(.*venue\\s'(.*?)')",
					"(order\\s\\w+\\s(\\d+))(.*venue\\s\"(.*?)\")", "(Refund\\s\\w+\\s(\\d+))(.*venue\\s\"?(.*?)\")" };

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				/*
				 * Enter your code here, Parse the file content and display the
				 * number of tickets for each venue
				 */
				boolean findPatt = false;

				for (String patt : pattern) {
					findPatt = populateTickets(line.trim(), patt);
					if (findPatt){break;}
				}
				// System.out.println(m);
				if (tickets.size()>0)
				{
					printTickets(tickets);
				}
				System.out.println("The end of line");
			}
			scanner.close();

		} finally {
			scanner.close();

			printTickets(tickets);

			active = false;
			System.out.println("I am done");
		}

	}

	private static void printTickets(LinkedHashMap<String, Integer> tickets) {
		// TODO Auto-generated method stub
		for(String ticket:tickets.keySet())
		{
			System.out.println(ticket + ": " + tickets.get(ticket));
		}
	}
	private static boolean populateTickets(String line, String pattern)
 {
		boolean foundMatch = false;
		try{
			//Pattern r = Pattern.compile(pattern, Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);
			Pattern r = Pattern.compile(pattern,  Pattern.CASE_INSENSITIVE);

			Matcher m = r.matcher(line.trim());
			int numoftickets = 0;

			while (m.find()) {
				System.out.println("Found a " + m.group(1) + ".");
				System.out.println("Found a " + m.group(2) + ".");
				System.out.println("Found a " + m.group(3) + ".");
				System.out.println("Found a " + m.group(4) + ".");
	
				
				numoftickets = Integer.parseInt(m.group(2));
	
				Boolean refund = false;
				int count = 0;
				foundMatch = true;
				if (m.group(1).toLowerCase().contains("refund")) {
					refund = true;
				}

				System.out.println("Refund: " + refund);

				if (tickets.get(m.group(4).trim()) == null && (refund)) {
					tickets.put(m.group(4).trim(), count - numoftickets);
				} else if (tickets.get(m.group(4).trim()) == null && (!refund)) {
					tickets.put(m.group(4).trim(), numoftickets);
				} else {
					count = tickets.get(m.group(4));
					if (refund) {
						tickets.put(m.group(4).trim(), count - numoftickets);
					} else {
						tickets.put(m.group(4).trim(), count + numoftickets);
					}
				}
			}
		}catch (NumberFormatException ex){
		//	System.out.println(ex.printStackTrace());
			return foundMatch;
		}finally{
			return foundMatch;
		}
		
	}

}
