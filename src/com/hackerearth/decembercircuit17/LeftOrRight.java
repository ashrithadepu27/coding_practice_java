package com.hackerearth.decembercircuit17;

import java.util.Scanner;
import java.util.ArrayList;

public class LeftOrRight {

    private static ArrayList<Integer> A = new ArrayList<>();
    private static int ALength;

    public static void main(String args[])  {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Q = s.nextInt();
        int steps;
        for(int i = 0; i < N; i++)  {
            A.add(s.nextInt());
        }
        ALength = A.size();
        for(int i = 0; i < Q; i++)  {

            steps = -1;
            int startingCity = s.nextInt();
            int targetCityType = s.nextInt();
            String direction = s.next();
            steps =noOfStep(startingCity, targetCityType, direction, steps);
            System.out.println(steps);
        }
        s.close();
    }

    public static int noOfStep(int startingCity, int targetCityType, String direction, int steps)    {
        if(!A.contains(targetCityType))    {
            //System.out.println("doesn't exists");
            return steps;
        }
        else if(A.get(startingCity) == targetCityType)   {
            return steps+1;
        }
        else if(direction.equals("L"))   {
            steps++;
            steps = noOfStep((startingCity - 1 + ALength) % ALength, targetCityType, direction, steps);
            return steps++;
        }
        else    {
            steps++;
            steps = noOfStep((startingCity + 1 + ALength) % ALength, targetCityType, direction, steps);
            return steps++;
        }
    }
}
