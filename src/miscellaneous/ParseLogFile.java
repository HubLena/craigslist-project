package miscellaneous;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLogFile {
	
	 public static void main(String[] args) {
	        Scanner scanner = null;
	        LinkedHashMap<String, Integer> tickets = new LinkedHashMap<String,Integer>();
	        
	        try {
	            //the input file will be provided through System.in, the scanner allows you to read it line by line
	            scanner = new Scanner(System.in);
	            // (?s) to search across multiple lines.
	            boolean findMatch = false;
	          String pattern = ("(ordered\\s'(.*?)'\\s\\w+)(.*venue\\s'(.*?)')");

	           
	    		Pattern r = Pattern.compile(pattern,Pattern.MULTILINE+Pattern.CASE_INSENSITIVE);
	    		int count = 0;
	    		//System.out.println("Before Find Match: " + findMatch);
	            while (!findMatch && scanner.hasNext()) {
	                String line = scanner.nextLine();
	                /* Enter your code here, Parse the file content and display the number of tickets for each venue */
	              
	    	    	Matcher m = r.matcher(line);
	    	
	    	    	findMatch = true;
	    	    	int numoftickets = 0;
	    	    	
	    	    	while (m.find()) {
	    				System.out.println("Found a " + m.group(1) + ".");
	    				System.out.println("Found a " + m.group(2) + ".");
	    				System.out.println("Found a " + m.group(3) + ".");
	    				System.out.println("Found a " + m.group(4) + ".");
	    				
	    				numoftickets = Integer.parseInt(m.group(2));
	    				
	    				if(tickets.get(m.group(4))==null)
	    					
	    				{
	    					tickets.put(m.group(4), numoftickets);
	    				}else{
	    					count = tickets.get(m.group(4));
	    					tickets.put(m.group(4), count+numoftickets);
	    				}
	    			
	    			}
	    	    	 if (!scanner.hasNextLine()) {
		            	   findMatch=false;
		            	   break;
		            	   }
		               System.out.println("Scanner.hasNextLine " + scanner.hasNextLine());
		               System.out.println("Find Match: " + findMatch);
	            }
	            scanner.close();
	            System.out.println("Scanner Closed");
	           
	        } finally{
	            scanner.close();
	            if (tickets.size()>0)
		        {
		        	printTickets(tickets);
		        }
	            System.out.println("Finally exit");
	        }
	        
	       
	    }

	private static void printTickets(LinkedHashMap<String, Integer> tickets) {
		// TODO Auto-generated method stub
		for(String ticket:tickets.keySet())
		{
			System.out.println(ticket + ": " + tickets.get(ticket));
		}
	}
	   
	    
	}
