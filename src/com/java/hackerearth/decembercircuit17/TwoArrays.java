package com.java.hackerearth.decembercircuit17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoArrays {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] l = line.split(" ");
        int N = Integer.parseInt(l[0]);
        int M = Integer.parseInt(l[1]);
        int K = Integer.parseInt(l[2]);
        List<String> A = Arrays.asList(br.readLine().split(" "));
        List<String> B = Arrays.asList(br.readLine().split(" "));
        printArray(A); printArray(B);
        int commonElement = A.size();
        A.removeAll(B);
        commonElement -= A.size();
        System.out.println("common elem: " + commonElement);
    }

    public static void printArray(List<String> A)   {
        for(String s : A)   {
            System.out.print(s + " ");
        }
    }
}