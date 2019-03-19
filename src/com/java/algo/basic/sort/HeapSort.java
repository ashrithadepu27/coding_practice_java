package com.java.algo.basic.sort;

public class HeapSort {

	private static int heap_size;
	
	public int[] sort(int[] arr) {
		int temp;
		arr = build_max_heap(arr);
		for(int i = arr.length-1; i > 0; i--)	{
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heap_size = heap_size - 1;
			arr = max_heapify(arr, 0);
		}
		return arr;
	}
	
	
	public int[] build_max_heap(int[] arr)	{
		heap_size = arr.length-1;
		for(int i = arr.length / 2 -1; i >= 0; i--)	{
			max_heapify(arr, i);
		}
		return arr;
	}
	
	public int[] max_heapify(int[] arr, int i)	{
		int l = 2*i-1 != -1 ? 2*i-1 : 0;
		int r = 2*i != 0 ? 2*i : 1 ;
		int largest, temp;
		if(l <= heap_size && arr[l] > arr[i])	
			largest = l;
		else
			largest = i;
		
		if(r <= heap_size && arr[r] > arr[largest])	
			largest = r;
		
		if(largest != i)	{
			temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			max_heapify(arr, largest);
		}
		return arr;
	}
	
	public static void printArray(int a[])	{
		for(int i : a)	{
			System.out.print(i + "  ");
		}
		System.out.println();
	}
}
