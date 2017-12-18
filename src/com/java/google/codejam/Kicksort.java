package com.java.google.codejam;

import java.util.ArrayList;
import java.util.Scanner;

public class Kicksort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        
        ArrayList<ArrayList<Integer>> listArray = new ArrayList<ArrayList<Integer>>();
        for(int t = 1 ; t <= noOfTestCases; t++)	{
        	int noOfElement = in. nextInt();
	        ArrayList<Integer> array = new ArrayList<Integer>();
	        for(int i=0; i < noOfElement; i++){
	            array.add(in.nextInt());
	        }
	        listArray.add(array);
        }
        for(int t = 0; t < listArray.size(); t++)	{
			boolean flag = allWorstCase(listArray.get(t), 1, listArray.get(t).size());
	        if(flag)	{
	        	System.out.println("Case #" + Integer.valueOf(t+1) + ": YES");
	        }
	        else	{
	        	System.out.println("Case #" + Integer.valueOf(t+1) + ": NO");
	        }        	
        }
        in.close();
	}

	public static boolean allWorstCase(ArrayList<Integer> arr, int min, int max)	{
		try	{
			int mid = (arr.size()-1)/2;
			boolean flag;
			if(arr.size() == 2)
				return true;
			else	{
				if(arr.get(mid) == min)	{
					arr.remove(mid);
					min += 1;
					flag = allWorstCase(arr, min, max);		
					return flag;
				}
				else if(arr.get(mid) == max)	{
					arr.remove(mid);
					max = max - 1;
					flag = allWorstCase(arr, min, max);		
					return flag;
				}
				else {
					return false;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
