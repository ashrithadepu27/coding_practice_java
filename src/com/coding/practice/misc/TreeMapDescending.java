package com.coding.practice.misc;

import java.util.*;

public class TreeMapDescending {


    private static Map<Integer, Integer> sortedMap;


    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        matrix.add(a);
        a.clear();
        a.add(4);
        a.add(5);
        a.add(6);
        matrix.add(a);
        a.clear();
        a.add(7);
        a.add(8);
        a.add(9);
        matrix.add(a);
        System.out.println("ans: " + MinSliceWeight(matrix));
    }



    // Complete the MinSliceWeight function below.
    static int MinSliceWeight(List<List<Integer>> Matrix) {

        int  n = Matrix.size();
        // Base Case
        if(n == 0 ) return n;

        // Defining cost function
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            cost[0][i] = Matrix.get(0).get(i);
        }
        int i = 1, j = 0;
        while(i < n) {
            while(j < n) {
                if(j == 0) {
                    cost[i][j] = Matrix.get(i).get(j) + (cost[i-1][j+1] < cost[i-1][j] ? cost[i-1][j+1] : cost[i-1][j]);
                } else if (j == n-1) {
                    cost[i][j] = Matrix.get(i).get(j) + (cost[i-1][j-1] < cost[i-1][j] ? cost[i-1][j-1] : cost[i-1][j]);
                } else {
                    cost[i][j] = Matrix.get(i).get(j) + minValue(cost[i-1][j-1], cost[i-1][j], cost[i-1][j+1]);
                }
                j++;
            }
            j = 0;
            i++;
        }
        int minValue = Integer.MAX_VALUE;

        for(int t = 0;t < n; t++) {
            if(minValue > cost[n-1][t])
                minValue = cost[n-1][t];
        }
        return minValue;
    }

    // Calculate min value out of 3 number
    static int minValue(int num1, int num2, int num3) {
        int min = num1;
        if(min > num2)
            min = num2;
        if(min > num3)
            min = num3;
        return min;
    }

    // Complete the differentTeams function below.
    static int differentTeams(String skills) {

        int[] studentPerSkill = new int[5];

        // Updating strength of student Per skill
        for(char c : skills.toCharArray()) {
            switch(c) {
                case 'p':
                    studentPerSkill[0] += 1;
                    break;
                case 'c':
                    studentPerSkill[1] += 1;
                    break;
                case 'm':
                    studentPerSkill[2] += 1;
                    break;
                case 'b':
                    studentPerSkill[3] += 1;
                    break;
                case 'z':
                    studentPerSkill[4] += 1;
                    break;
            }
        }

        int min = Integer.MAX_VALUE;

        // Calculating minimum # of student with a skill
        for(Integer temp : studentPerSkill) {
            if(temp < min) {
                min = temp;
            }
        }
        return min;

    }

}
