package com.java;

public class sample {

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int len = (int) Math.log10(x);
        char[] d = String.valueOf(x).toCharArray();
        for(int i = 0; i <= len/2; i++)    {
            if(d[i] != d[len-i])
                return false;
        }
        return true;
    }

    public static void main(String args[])  {
//        System.out.println(new sample().isPalindrome(1474741));
//        System.out.println(new sample().isPalindrome(1));
//        System.out.println(new sample().isPalindrome(121));
        System.out.println(Math.random());
    }
}
