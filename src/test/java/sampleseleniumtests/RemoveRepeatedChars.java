package sampleseleniumtests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveRepeatedChars {
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter String :");
		
		if(scanner.hasNext())
		{
			String inputString = scanner.next();
			
			//char[] chars = inputString.toCharArray();
			
			Set<Character>	chars= new HashSet<>();	
			for(int i=0;i<inputString.length()-1;i++)
			{
				boolean isRepeated = false;
				for(int j=i+1;j<inputString.length();j++)
				{
					if(inputString.charAt(i)==inputString.charAt(j))
					{
						isRepeated =true;
						break;
					}
				}
				if(isRepeated)
				{
					chars.add(inputString.charAt(i));
				}
				
			}
			String outputString="";
			for(int i = 0;i<inputString.length();i++)
			{
				if(!chars.contains(inputString.charAt(i)) )
				{
					outputString = outputString +inputString.charAt(i);
				}
			}
			
			System.out.println(outputString);
			
			//System.out.println(charSet);
		}
	}
	
	

}
