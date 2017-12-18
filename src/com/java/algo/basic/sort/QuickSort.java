package com.java.algo.basic.sort;

public class QuickSort{

	public int[] sort(int[] arr) {
		
		return quicksort(arr, 0, arr.length-1);
	}
	
	private int[] quicksort(int[] arr, int p, int r)	{
		int q;
		if(p < r)	{
			q = partition(arr, p, r);
			quicksort(arr, p, q-1);
			quicksort(arr, q+1, r);
		}
		return arr;
	}

	private int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1, temp;
		for(int j = p; j <= r-1; j++)	{
			if(arr[j] <= x)	{
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		return i+1;
	}

}
