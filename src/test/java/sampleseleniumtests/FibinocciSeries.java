package sampleseleniumtests;

public class FibinocciSeries {

	public static void main(String[] args) {
		
		int prevOne = 1;
		int prevTwo = 0;
		int currentNumber;
		
		System.out.print(prevTwo +","+prevOne+",");
		for(int i=0;i<10;i++)
		{
			currentNumber = prevOne +prevTwo;
			
			System.out.print(currentNumber+",");
			
			prevTwo = prevOne;
			prevOne = currentNumber;
		}
		
		
		
	}
}
