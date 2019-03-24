package com.coding.challenge.match;

public class Question3 extends Question2{

    private static double MOD_VAL = (Math.pow(10, 9) + 7);

    public static int drawingEdge(int n) {
        // Write your code here
        double numberOfEdge = n*(n-1)/2;
        double numberOfGraph = Math.pow(2, numberOfEdge);
        return (int) Math.round(numberOfGraph % MOD_VAL);
    }

    public static void main(String[] args) {
        int c = drawingEdge(5);
        System.out.println(c);
    }
}
