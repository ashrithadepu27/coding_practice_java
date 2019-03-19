package com.java.datastructure.stack;

import java.util.Stack;

public class StringPatternGenerator {

    private static String stringGeneratedForSequence(String sequence) {
        Stack<String> stack = new Stack<>();
        int temp = 0;
        char[] chars = sequence.toCharArray();
        for(char c : chars) {
            if(c == '[') {
                if(temp != 0) {
                    stack.push(String.valueOf(temp));
                }
                temp = 0;
                stack.push(String.valueOf(c));
            }
            else if('a' <= c && 'z' >= c) {
                if(temp != 0) {
                    stack.push(String.valueOf(temp));
                }
                temp = 0;
                stack.push(String.valueOf(c));
            } else if(c == ']') {
                if(temp != 0) {
                    stack.push(String.valueOf(temp));
                }
                temp = 0;
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder sb2 = new StringBuilder();
                int n = Integer.parseInt(stack.pop());
                for (int i = 0; i < n; i++)
                    sb2.append(sb);
                stack.push(sb2.toString());
            } else {
                temp = temp * 10 + Character.getNumericValue(c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String sequence = "4[2[a]3[b]]";
        System.out.println(stringGeneratedForSequence(sequence));
    }
}
