package miscellaneous;

import java.lang.reflect.Method;

public class Printer <T> {
//Write your code here
	    public static <T> void printArray(T[] array){
	    for (T element : array)
	    {
	        System.out.println(element);
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Printer myPrinter=new Printer();
	        Integer[] intArray = { 1, 2, 3 };
	        String[] stringArray = {"Hello","World"};
	        myPrinter.printArray( intArray  );
	        myPrinter.printArray( stringArray );
	        int count=0;
	      for (Method method : Printer.class.getDeclaredMethods()) {
	            String name = method.getName();
	            if(name.equals("printArray"))
	              count++;
	        }
	        
	        if(count>1)System.out.println("Method overloading is not allowed!");
	        assert count==1;

	    } 
	}
