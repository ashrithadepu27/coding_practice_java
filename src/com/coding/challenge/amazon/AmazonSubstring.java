package com.coding.challenge.amazon;

import java.util.*;

public class AmazonSubstring {

    public static List<String> subStringLessKDist(String inputString, int num) {
        Set<String> result = new HashSet<>();

        if(inputString == null || inputString.length() < num) {
            return new LinkedList<>();
        }

        Map<Character, Integer> wordCount = new HashMap<>();
        int start = 0;
        for(int i = 0; i < inputString.length(); i++) {
            wordCount.put(inputString.charAt(i), wordCount.getOrDefault(inputString.charAt(i), 0) + 1);
            if(i - start == num-1) {
                if(wordCount.size() == num - 1) {
                    result.add(inputString.substring(start, i+1));
                }
                int temp = wordCount.get(inputString.charAt(start));
                if(temp == 1) {
                    wordCount.remove(inputString.charAt(start));
                } else {
                    wordCount.put(inputString.charAt(start), temp-1);
                }
                start++;
            }
        }
        return new LinkedList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(subStringLessKDist("awaglkk", 4));
    }
}
