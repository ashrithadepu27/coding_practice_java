package com.coding.practice.misc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GeneralizeGCD {

    public static int findGeneralizeGCD(int[] nums) {

        int min = nums[0];
        for(int n : nums) {
            if(min > n)
                min = n;
        }
        List<Integer> factors = getFactors(min);
        boolean divideAll = true;
        for(int f : factors) {
            for(int n : nums) {
                if(n % f != 0)
                    divideAll = false;
            }
            if(divideAll)
                return f;
        }
        return 1;
    }

    public static List<Integer> getFactors(int num) {
        List<Integer> factors = new LinkedList<>();
        int sqrt = (int) Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++) {
            if(num % i == 0) {
                factors.add(i);
                if(i != num/i) {
                    factors.add(num/i);
                }
            }
        }
        Collections.reverse(factors);
        return factors;
    }

    public static void main(String[] args) {
        int[] nums = {6, 81, 243, 27};

        System.out.println("Generalize GCD: " + findGeneralizeGCD(nums));
    }
}
