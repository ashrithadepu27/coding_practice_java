/**
 * KnuthMorrisPratt: Pattern Matching
 * reference: https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 */
package com.coding.practice.pattern;

import java.util.LinkedList;
import java.util.List;

public class KnuthMorrisPratt implements PatternSearching{


    @Override
    public List<Integer> strStr(String haystack, String needle) {
        if(haystack.equals(needle)) return null;
        int[] lpsTable = createLPSTable(needle);
        List<Integer> res = new LinkedList<>();
        int i = 0, j = 0;
        while(i < haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else if(j != 0) {
                j = lpsTable[j];
            } else {
                i++;
                j = 0;
            }
            if(j == needle.length()) {
                res.add(i-j);
                j = 0;
                i++;
            }
        }
        return res;
    }

    private int[] createLPSTable(String needle) {
        int[] lpsTable = new int[needle.length()+1];
        int i = 1, stringLength = needle.length(), j = 0;
        while(i < stringLength) {
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                lpsTable[i] = j;
            } else {
                if(j==0) {
                    i++;
                    lpsTable[i] = j;
                } else {
                    j = lpsTable[j];
                }
            }
        }
        return lpsTable;
    }
}
