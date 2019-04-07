package com.coding.practice.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxFruitCollected {

    private static int maxFruitCollected(int[] fruits) {
        if(fruits.length < 2) return fruits.length;
        int maxCount = 0, start = 0, end = 0;
        Map<Integer, Integer> bucket = new HashMap<>();

        while(end < fruits.length) {
            if(bucket.size() == 2 && !bucket.containsKey(fruits[end])) {
                while(bucket.size() == 2) {
                    int n = bucket.get(fruits[start]);
                    if(n == 1) bucket.remove(fruits[start]);
                    else bucket.put(fruits[start], n-1);
                    start++;
                }
            }
            bucket.put(fruits[end], bucket.getOrDefault(fruits[end], 0)+1);
            if(end-start > maxCount)
                maxCount = end - start;
            end++;
        }
        return maxCount+1;
    }

    public static void main(String[] args) {
        int[] fruits = {4,1,1,1,3,1,7,5};
        System.out.println(maxFruitCollected(fruits));
    }
}

