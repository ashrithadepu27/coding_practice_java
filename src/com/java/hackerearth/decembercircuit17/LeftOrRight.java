package com.java.hackerearth.decembercircuit17;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class LeftOrRight {
    private static ArrayList<Integer> A = new ArrayList<>();
    private static int ALength;

    public static void main(String args[])  {

        FastReader s = new FastReader();
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

    static class FastReader   {

        BufferedReader br;
        StringTokenizer st;

        public FastReader()   {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()  {
            while (st == null || !st.hasMoreElements())  {
                try  {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)  {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()  {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble()  {
            return Double.parseDouble(next());
        }

        String nextLine()  {
            String str = "";
            try   {
                str = br.readLine();
            }
            catch (IOException e)  {
                e.printStackTrace();
            }
            return str;
        }
    }
}
