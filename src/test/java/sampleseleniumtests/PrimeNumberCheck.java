package sampleseleniumtests;

import java.util.Scanner;

public class PrimeNumberCheck {

	public static void main(String[] argss) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number:");
		int inputNumber;
		
		while (scanner.hasNext()) {
			inputNumber = Integer.parseInt(scanner.next());
			
			boolean isPrime = true;

			for (int i = 2; i < Math.sqrt(inputNumber) + 1; i++) {
				if (i != inputNumber) {

					if (inputNumber % i == 0) {

						isPrime = false;
						break;
					}

				}

			}

			if (isPrime) {
				System.out.println("Given number is prime number : " + inputNumber);
			} else {
				System.out.println("Given number is not a prime number :" + inputNumber);
			}
			System.out.print("Enter number :");
		}

	}

}
