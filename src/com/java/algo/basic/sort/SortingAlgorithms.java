package com.java.algo.basic.sort;

public class SortingAlgorithms {

	public static void main(String args[])	{
		
		System.out.print("Input Array: ");		
		printArray(inputArray());
		System.out.println();
		long startTime, timeDuration;
		
		// Sorting Algorithms Object
		BubbleSort bs = new BubbleSort();
		HeapSort hs = new HeapSort();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		SelectionSort ss = new SelectionSort();
		
		// Bubble Sort
		startTime = System.currentTimeMillis();
		int[] bubbleSortedArr = bs.sort(inputArray());	
		timeDuration = (System.currentTimeMillis() - startTime); 
		System.out.print("Bubble Sort: ");
		printArray(bubbleSortedArr);
		System.out.println("Time taken to sort(ms): " + timeDuration);
		System.out.println();
		
		// Heap Sort
		startTime = System.currentTimeMillis();
		int[] heapSortedArr = hs.sort(inputArray());	
		timeDuration = (System.currentTimeMillis() - startTime); 
		System.out.print("Heap Sort: ");
		printArray(heapSortedArr);
		System.out.println("Time taken to sort(ms): " + timeDuration);
		System.out.println();
		
		// Insertion Sort
		startTime = System.currentTimeMillis();
		int[] insertionSortedArr = is.sort(inputArray());	
		timeDuration = (System.currentTimeMillis() - startTime); 
		System.out.print("Insertion Sort: ");
		printArray(insertionSortedArr);
		System.out.println("Time taken to sort(ms): " + timeDuration);
		System.out.println();
		
		// Merge Sort
		startTime = System.currentTimeMillis();
		int[] mergeSortedArr = ms.sort(inputArray());	
		timeDuration = (System.currentTimeMillis() - startTime); 
		System.out.print("Merge Sort: ");
		printArray(mergeSortedArr);
		System.out.println("Time taken to sort(ms): " + timeDuration);
		System.out.println();
		
		// Quick Sort
		startTime = System.currentTimeMillis();
		int[] quickSortedArr = qs.sort(inputArray());	
		timeDuration = (System.currentTimeMillis() - startTime); 
		System.out.print("Quick Sort: ");
		printArray(quickSortedArr);
		System.out.println("Time taken to sort(ms): " + timeDuration);
		System.out.println();
		
		// Selection Sort
		startTime = System.currentTimeMillis();
		int[] selectionSortedArr = ss.sort(inputArray());	
		timeDuration = (System.currentTimeMillis() - startTime); 
		System.out.print("Selection Sort: ");
		printArray(selectionSortedArr);
		System.out.println("Time taken to sort(ms): " + timeDuration);
		System.out.println();
		
	}
	
	public static void printArray(int a[])	{
		for(int i = 0; i < a.length; i++)	{
			System.out.print(a[i] +"  ");
		}
		System.out.println();
	}
	
	public static int[] inputArray()	{
		int[] arr = {35, 12, 36, 13, 51, 
				 23, 75, 3, 45, 21, 
				 16, 95, 40, 54, 27, 
				 84, 1, 43, 92, 66,
				 69, 10, 14, 8 ,7};
		return arr;
	}
}
