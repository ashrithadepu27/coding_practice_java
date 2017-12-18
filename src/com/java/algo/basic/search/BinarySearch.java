package com.java.algo.basic.search;

public class BinarySearch {

	public int search(int arr[], int x)	{
		return binarySearch(arr, 0, arr.length-1, x);
	}
	
	public int binarySearch(int arr[], int l, int r, int x)   {
        if (r>=l)	{
            int mid = l + (r - l)/2;
            
            if (arr[mid] == x)
               return mid;
            
            else if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }

}
