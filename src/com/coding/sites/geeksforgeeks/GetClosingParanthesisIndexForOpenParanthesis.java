package com.coding.sites.geeksforgeeks;

import java.util.Stack;

public class GetClosingParanthesisIndexForOpenParanthesis {

    public static int indexOfClosingParanthesis(String pattern, int index) {

        Stack<Character> paran = new Stack<Character>();

        // Base case
        if(pattern.length() < 2) return -1;
        if(index < 0) return -1;
        if(pattern.charAt(index) != '(') return -1;

        for(int i = index; i < pattern.length(); i++) {
            if(pattern.charAt(i) == '(') {
                paran.push('(');
            } else if(pattern.charAt(i) == ')') {
                if(paran.size() == 1) {
                    return i;
                } else {
                    paran.pop();
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOfClosingParanthesis("((())())", 0));
    }

}
