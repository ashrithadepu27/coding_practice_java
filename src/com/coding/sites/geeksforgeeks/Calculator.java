package com.coding.sites.geeksforgeeks;

import java.util.*;

public class Calculator {

    static int solve(String opr) {
        int x = Character.getNumericValue(opr.charAt(0));
        int y = Character.getNumericValue(opr.charAt(2));
        
        if(opr.charAt(1) == '+')
            return x+y;
        else
            return x-y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opr = in.next();
        int result = solve(opr);
        System.out.println(result);
        in.close();
    }
}
