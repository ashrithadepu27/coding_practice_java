package com.java.google.practice;

public class MaxRepeSubString {


    public static int solution(String A, String B) {
        // write your code in Java SE 8
        if(A == null || A.length() == 0 || B == null || B.length() == 0)
            return -1;

        if(A.indexOf(B) != -1)
            return 1;

//        if(B.indexOf(A) == -1)
//            return -1;

        for(char c : B.toCharArray())   {
            if(A.indexOf(String.valueOf(c))== -1) {
                System.out.println(String.valueOf(c));
                return -1;
            }
        }

        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        while(true) {
            sb.append(A);
            count++;
            if(sb.indexOf(B) != -1)
                return count;
        }
    }

    public static void main(String[] args)  {
        System.out.println(solution("as", "sa"));
    }
}
