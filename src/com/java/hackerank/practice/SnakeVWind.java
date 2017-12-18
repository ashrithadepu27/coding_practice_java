package com.java.hackerank.practice;

import java.util.Scanner;

@SuppressWarnings("unused")
public class SnakeVWind {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] area = new int[n][n];
        int path = 1, iteratorY = 1, iteratorX = 1;
        if(x == n-1)
        	iteratorX = -1;
        if(y == n -1)
        	iteratorY = -1;
        while(path <= n*n)	{
        	area[x][y] = path;
        	path++;       
        	System.out.println(x + "  " + iteratorX + "  " + y + "  " + iteratorY);
        	if( d == 'n')	{
        		if(x-1 >= 0 && area[x-1][y] == 0)
        			x = x-1;
        		else 	{
        			y = y + iteratorY;
        			if(y == -1)	{
        				y = 0;
        				iteratorY *= -1;
        				x = x + iteratorX;
        			}
        			else if(y == n)	{
        				y = n-1;
        				iteratorY *= -1;
        				x = x + iteratorX;
        			}
        		}
					
        	}
        	else if(d =='e')	{
        		
        	}
        	else if(d == 'w')	{
        		
        	}
        	else	{
        		
        	}
            printArea(area, n);
        }
        printArea(area, n);
        in.close();
    }
	
	private static void printArea(int[][] area, int n)	{
		int max = 0;
		for(int i=0; i<n; i++)	{
			for(int j=0; j<n; j++)	{
				System.out.print(area[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
