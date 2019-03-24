package com.coding.sites.geeksforgeeks;

import java.util.*;

public class BalancedBrackets {

    private static Stack<Character> bracks = new Stack<>();

    public static boolean isBalanced(String expression) {

        bracks.clear();
        char[] exp = expression.toCharArray();
        for(char c : exp) {
            if(c == '[' || c == '{' || c == '(')    {
                bracks.push(c);
            }
            else    {
                if(bracks.empty())
                    return false;
                char t = bracks.peek();
                if((int) c - (int) t  < 3)  {
                    bracks.pop();
                }
                else
                    return false;
            }
        }
        if(bracks.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
