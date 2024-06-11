package sampleseleniumtests;

import java.util.Scanner;

public class BinarySearchOfSortedArray {

	public static int[] actualArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		

		System.out.println(actualArray);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select number to search :");

		if (scanner.hasNext()) {
			int elementToSearch = scanner.nextInt();
			
			int midIndex = actualArray.length / 2;
			int startIndex = 0;
			int endIndex= actualArray.length -1;
			
			binarySearch(actualArray, elementToSearch,startIndex,endIndex,midIndex);
		}

	}

	private static void binarySearch(int[] sortedArray, int elementToSearch) 
	{
		int midIndex = sortedArray.length / 2;
		int startIndex = 0;
		int endIndex= sortedArray.length -1;
		
		if(sortedArray[midIndex] == elementToSearch )
		{
			for (int i = 0; i < actualArray.length; i++) {
			    if (actualArray[i] == sortedArray[midIndex]) {
			        // Found the target integer at index i
			        System.out.println("Element found at index: " + i);
			        break;
			    }
			
			//System.out.println("Element found at index : "+midIndex);
			}
			return;
		}
		else if(elementToSearch < sortedArray[midIndex])
		{
			int[] newSortedArray = new int[midIndex]; // Initialize with appropriate length
			for (int i = 0; i < midIndex; i++) {
			    newSortedArray[i] = sortedArray[i];
			}
					 
			binarySearch(newSortedArray,elementToSearch);
		}
		else if(elementToSearch > sortedArray[midIndex])
		{
			
			int arrayLength = sortedArray.length - (midIndex+1);
			int[] newSortedArray = new int[arrayLength];
			
			for (int i =0 ; i < arrayLength; i++) {
			    newSortedArray[i] = sortedArray[i+midIndex+1];
			}
			
			
			binarySearch(newSortedArray,elementToSearch);
		}
		
		return;
		
	}
	
	private static void binarySearch(int[] sortedArray, int elementToSearch,int startIndex,int endIndex,int midIndex) 
	{
//		int midIndex = sortedArray.length / 2;
//		int startIndex = 0;
//		int endIndex= sortedArray.length -1;
		
		if(sortedArray[midIndex] == elementToSearch )
		{
			
			System.out.println("Element found at index : "+midIndex);
		
			return;
		}
		else if(elementToSearch < sortedArray[midIndex])
		{
			
			endIndex = midIndex;
			midIndex = (endIndex +  startIndex)/2;
					 
			binarySearch(sortedArray,elementToSearch,startIndex,endIndex,midIndex);
		}
		else if(elementToSearch > sortedArray[midIndex])
		{			
			
			startIndex = midIndex+1;
			midIndex = (midIndex + 1 + endIndex)/2;
			
		binarySearch(sortedArray,elementToSearch,startIndex,endIndex,midIndex);
			
		}
		
		return;
		
	}

}
