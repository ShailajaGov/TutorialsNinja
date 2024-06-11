package sampleseleniumtests;

import java.util.Scanner;

public class SquareRootOfNumber {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter number :");
		
		if(scanner.hasNext())
		{
			double inputNumber = scanner.nextDouble();
			
			double sqrt = inputNumber/2 ;
			
			boolean continueLoop = true;
			
			while(Math.abs(Math.pow(sqrt, 2) - inputNumber)>1)
			{
				
				System.out.println(sqrt);
				if(Math.pow(sqrt, 2) == inputNumber)
				{
					System.out.println(sqrt+"is square root of "+inputNumber);
					continueLoop= false;
					continue;
				}
				else if ((Math.pow(sqrt, 2) - inputNumber)>0)
				{
					sqrt = sqrt-2;
				}
				else if ((Math.pow(sqrt, 2) - inputNumber)<0)
				{
					sqrt = sqrt+1;
				}
				
			if(Math.abs(Math.pow(sqrt, 2) - inputNumber) <=1)
			{
				
			System.out.println(sqrt+"is square root of "+inputNumber);
				
			}
				
		}
		
		

	}

}
}
