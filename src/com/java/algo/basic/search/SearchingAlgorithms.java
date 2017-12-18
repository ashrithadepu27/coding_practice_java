package com.java.algo.basic.search;

public class SearchingAlgorithms {

	public static void main(String args[])   {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int x = 10;
        int result = ob.search(arr, x);
        
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);
    }
}
