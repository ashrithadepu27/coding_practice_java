package com.coding.practice.algo.basic.sort;

import com.coding.practice.timer.Timer;

import java.util.Random;

public class SortingAlgorithms {

	private static int[] arrayToSort = new Random().ints(100000).toArray();

	public static void main(String args[])	{

		Timer timer = new Timer();
		int i = 100;
		timer.setNoOfIteration(i);
		System.out.print("Input Array: ");		
		printArray(arrayToSort);
		System.out.println();


		// Sorting Algorithms Object
		BubbleSort bs = new BubbleSort();
		HeapSort hs = new HeapSort();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		SelectionSort ss = new SelectionSort();
		
		// Bubble Sort
		timer.start();
		int[] bubbleSortedArr = new int[arrayToSort.length];
		while(i > 0 ) {
			bubbleSortedArr = bs.sort(arrayToSort);
			i--;
		}
		timer.end();
		System.out.print("Bubble Sort: ");
		printArray(bubbleSortedArr);
		System.out.println(timer);
		System.out.println();
		
		// Heap Sort
		timer.start();
		int[] heapSortedArr = new int[arrayToSort.length];
		i = 100;
		while(i > 0) {
			heapSortedArr= hs.sort(arrayToSort);
			i--;
		}
		timer.end();
		System.out.print("Heap Sort: ");
		printArray(heapSortedArr);
		System.out.println(timer);
		System.out.println();

		// Insertion Sort
		timer.start();
		int[] insertionSortedArr = new int[arrayToSort.length];
		i = 100;
		while(i > 0) {
			insertionSortedArr= is.sort(arrayToSort);
			i--;
		}
		timer.end();
		System.out.print("Insertion Sort: ");
		printArray(insertionSortedArr);
		System.out.println(timer);
		System.out.println();

		// Merge Sort
		timer.start();
		int[] mergeSortedArr = new int[arrayToSort.length];
		i = 100;
		while(i > 0) {
			mergeSortedArr= ms.sort(arrayToSort);
			i--;
		}
		timer.end();
		System.out.print("Merge Sort: ");
		printArray(mergeSortedArr);
		System.out.println(timer);
		System.out.println();

		// Quick Sort
		timer.start();
		int[] quickSortedArr = new int[arrayToSort.length];
		i = 100;
		while(i > 0) {
			quickSortedArr= qs.sort(arrayToSort);
			i--;
		}
		timer.end();
		System.out.print("Quick Sort: ");
		printArray(quickSortedArr);
		System.out.println(timer);
		System.out.println();

		// Selection Sort
		timer.start();
		int[] selectionSortedArr = new int[arrayToSort.length];
		i = 100;
		while(i > 0) {
			selectionSortedArr= ss.sort(arrayToSort);
			i--;
		}
		timer.end();
		System.out.print("Selection Sort: ");
		printArray(selectionSortedArr);
		System.out.println(timer);
		System.out.println();
		
	}
	
	public static void printArray(int a[])	{
//		for(int i = 0; i < a.length; i++)	{
//			System.out.print(a[i] +"  ");
//		}
//		System.out.println();
	}
}
