package sampleseleniumtests;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter number :");
		
		while(scanner.hasNext())
		{
			int inputNumber = scanner.nextInt();
			int factorial = inputNumber;
			
			for(int i=inputNumber-1;i>1;i--)
			{
				factorial = factorial*i;
			}
			
			System.out.println("Factorial of number "+inputNumber+" is "+factorial);
			System.out.print("Enter another number :");
		}

	}

}
