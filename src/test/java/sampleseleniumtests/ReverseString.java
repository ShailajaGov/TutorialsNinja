package sampleseleniumtests;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Please enter String : ");
		
		if(scanner.hasNext())
		{
			String inputString=scanner.next();
			String reverseString="";
			
			char[] chars= inputString.toCharArray();
			for(int i=chars.length-1;i>=0;i--)
			{
				reverseString = reverseString+chars[i];
			}
			
			System.out.println("Given String : "+inputString);
			System.out.println("Reverse String :"+reverseString );
		}
		

	}

}
