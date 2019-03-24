package com.coding.sites.leetcode;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int i=0, j=0, t=0, k =0;
        for(char a : s3.toCharArray()) {
            if(i < s1.length() && s1.charAt(i) == a ) {
                System.out.println(i +"  " + j +"  " + k + "  " + a);
                if(s1.charAt(i) == a && j < s2.length() && s2.charAt(j) == a) {
                    i++;j++;t++;
                } else if(s1.charAt(i) == a){
                    i++;
                    j -= t;
                    t = 0;
                }
            } else if(j < s2.length() && s2.charAt(j) == a) {
                j++;
                i -= t;
                t = 0;
            } else {
                return false;
            }
            k++;
        }
        System.out.println(i +"  " + j +"  " + k);
        return (i+j == k);
    }

    public static void main(String[] args) {

        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave("aa", "ab", "aaba"));
    }
}
