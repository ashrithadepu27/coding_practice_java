package com.coding.sites.leetcode;

public class SmallestIntegerDivisibleByK {

    public int smallestRepunitDivByK(int K) {

        if(K % 2 == 0) return -1;
        if(K == 1) return 1;
        long maxValue = Long.MAX_VALUE;
        int ans = -1, j = 2;
        long n = 11;
        while(n < maxValue/10) {
            System.out.println(n);
            if(n % (long) K == 0) return j;
            n *= 10; n++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestIntegerDivisibleByK().smallestRepunitDivByK(5));
    }
}
