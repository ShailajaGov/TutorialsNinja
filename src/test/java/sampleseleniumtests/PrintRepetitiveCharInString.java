package sampleseleniumtests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintRepetitiveCharInString {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter String:");
		Set<Character>  repeatedSet= new HashSet<Character>();
		
		if(scanner.hasNext())
		{
			String inputString = scanner.next();
			
			for(int i=0;i<inputString.length()-1;i++)
			{
				boolean isRepeated = false;
				Character character = inputString.charAt(i);
				for(int j=i+1;j<inputString.length();j++)
				{
					if(character == inputString.charAt(j) )
					{
						isRepeated = true;
						//System.out.println(""+inputString.charAt(i));
						repeatedSet.add(character);
						
						break;
					}
				}
			}
			
			System.out.println(repeatedSet);
		}
		
		

	}

}
