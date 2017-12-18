package com.java.hackerank.practice;

import java.io.*;
import java.util.*;

public class BinaryNumber {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numDec = scan.nextInt();
        scan.close();
        int count = 0, a, max = 0;
        while(numDec > 0)   {
            a = numDec % 2;
            if(a == 1)	{
            	count++;
            	if(count > max)
            		max = count;
            }
            else	{
            	if(count > max)
            		max = count;
            	count = 0;
            }
            numDec = numDec / 2;
        }
        System.out.println(max);
    }
}