package com.coding.sites.geeksforgeeks;

import java.util.*;

@SuppressWarnings("unused")
public class EruptingVolcanoes {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] studyArea = new int[n][n];
        ArrayList<Integer> volcanoX = new ArrayList<Integer>();
        ArrayList<Integer> volcanoY = new ArrayList<Integer>();
        ArrayList<Integer> volcanoW = new ArrayList<Integer>();
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();         
            volcanoX.add(x);
            volcanoY.add(y);
            volcanoW.add(w);
        }
        for(int i=0; i< m; i++)
        	studyArea = volcanicEruptionDamage(studyArea, n, volcanoX.get(i), volcanoY.get(i), volcanoW.get(i));
        printStudyArea(studyArea, n);
        in.close();
    }

	private static int[][] volcanicEruptionDamage(int[][] studyArea, int n, int x, int y, int w) {
		int i=1, minX=0, minY, maxX, maxY;
		
		studyArea[x][y] = w;
		w--;
		while(w>0)	{
			minX = ((x - i) > 0) ? x-i : 0;
			maxX = ((x + i) < n) ? x+i : n-1;
			minY = ((y - i) > 0) ? y-i : 0;
			maxY = ((y + i) < n) ? y+i : n-1;
			for(int j = minY; j <= maxY; j++)	{
				if(minX <= x-i)
					studyArea[x-i][j] += w;
				if(maxX >= x+i)
					studyArea[x+i][j] += w;
			}	
			for(int j = minX+1; j < maxX; j++)	{
				if(minY <= y-i)
					studyArea[j][y-i] += w;
				if(maxY >= y+i)
					studyArea[j][y+i] += w;
					
			}
			i++; w--;
		}
		return studyArea;
	}
	
	private static void printStudyArea(int[][] studyArea, int n)	{
		//System.out.println("Printing the current state of Study Area:");
		int max = 0;
		for(int i=0; i<n; i++)	{
			for(int j=0; j<n; j++)	{
				//System.out.print(studyArea[i][j]+ " ");
				if(max < studyArea[i][j])
					max = studyArea[i][j];
			}
			//System.out.println();
		}
		System.out.println(max);
	}
}