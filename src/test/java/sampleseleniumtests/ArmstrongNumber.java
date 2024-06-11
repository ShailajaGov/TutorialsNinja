package sampleseleniumtests;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		
		//ArmstrongNumber : the sum of the cubes of its digits is equal to the number itself
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter valid integer number : ");
		
		while(scanner.hasNext())
		{
			int inputNumber = scanner.nextInt();
			int sum=0;
			int tempVar = inputNumber;
			
			for(int i=0;i<Integer.toString(inputNumber).length();i++)
			{
				sum =  sum+(int)Math.pow(tempVar%10,3);
				tempVar = tempVar/10;
				
				System.out.println("");
			}
			
			if(sum == inputNumber )
			{
				System.out.println(inputNumber+" is Armstrong number : "+inputNumber);
			}
			else
			{
				System.out.println(inputNumber+" is not Armstrong number : "+inputNumber);
			}
		}
		
		
		
	}

}
