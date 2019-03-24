package com.coding.practice.misc;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstring {
    public static void main(String[] args) {
        String s = "fghjkmgfdxgf";
        System.out.println(largestSubstring(s));
    }

    private static String largestSubstring(String str) {
        if(str == null || str.trim().length() <1) return null;
        char[] charArr = str.toCharArray();
        int maxLength = 0, start = 0, index;
        char c;
        String sb = null;
        Map<Character, Integer> charIndex = new HashMap<>();
        for(int i =0; i < charArr.length; i++) {
            c = charArr[i];
            index = charIndex.getOrDefault(c, -1);
            if(index != -1) {
                start = index+1;
            }
            charIndex.put(c, i);
            if(maxLength < (i-start)) {
                maxLength = i - start;
                sb = str.substring(start+1, i+1);
            }
        }

        return sb;
    }

}
