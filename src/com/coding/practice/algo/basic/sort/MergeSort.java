package com.coding.practice.algo.basic.sort;

public class MergeSort{

	public int[] sort(int[] arr) {		
		
		return mergeSort(arr, 0, arr.length-1);
	}
	
	public int[] mergeSort(int[] arr, int startIndex, int lastIndex)	{
		
		if(startIndex < lastIndex)	{
			int midIndex = (startIndex + lastIndex) / 2;
			mergeSort(arr, startIndex, midIndex);
			mergeSort(arr, midIndex+1, lastIndex);
			merge(arr, startIndex, midIndex, lastIndex);
		}
		return arr;
	}

	// To Merge 2 sorted arrays
	public void merge(int[] arr, int startIndex, int midIndex, int lastIndex)	{
		
		int n1 = midIndex - startIndex + 1;
		int n2 = lastIndex - midIndex;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		for(int i = 0; i < n1; i++)	{
			arr1[i] = arr[startIndex + i];
		}
		for(int i = 0; i < n2; i++)	{
			arr2[i] = arr[midIndex + 1 + i];
		}
		int i = 0;
		int j = 0;
		int k = startIndex;
		while( i < n1 && j < n2)	{
			if(arr1[i] <= arr2[j])	{
				arr[k] = arr1[i];
				i++;
			}
			else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2)  {
            arr[k] = arr2[j];
            j++;
            k++;
        }
	}
}
