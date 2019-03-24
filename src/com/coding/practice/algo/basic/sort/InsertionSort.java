package com.coding.practice.algo.basic.sort;

public class InsertionSort {

	public int[] sort(int[] arr) {
		
		int key, j;
		for(int i = 1; i< arr.length; i++)	{			
			key = arr[i];
			j = i - 1;
			while(j>=0 && arr[j] > key)	{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
	}
}
