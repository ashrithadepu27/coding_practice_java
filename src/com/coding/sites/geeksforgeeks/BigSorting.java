package com.coding.sites.geeksforgeeks;

import java.util.*;
import java.math.*;

@SuppressWarnings({"unused"})
public class BigSorting {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        String[] sorted = sort(unsorted);
        for(int sorted_i=0; sorted_i < n; sorted_i++){
            System.out.println(sorted[sorted_i]);
        }
        in.close();
    }
    
    public static String[] sort(String[] arr)  {
    	BigInteger key, val;
    	int j;
		for(int i = 1; i< arr.length; i++)	{
			
			key = new BigInteger(arr[i]);
			j = i - 1;
			val = new BigInteger(arr[j]);
			while(j>=0 && key.compareTo(val) < 0)	{				
				arr[j+1] = arr[j];
				j--;
				val = new BigInteger(arr[j]);
			}
			arr[j+1] = String.valueOf(key);
		}
		return arr;

    }
}
