/**
 * BasicPatternSearch: Pattern Searching
 */
package com.java.string.pattern;

import java.util.LinkedList;
import java.util.List;

public class BasicPatternSearch implements PatternSearching{

    @Override
    public List<Integer> strStr(String haystack, String needle) {

        int j;
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        if(needleCharArray.length == 0) {
            return null;
        }
        List<Integer> res = new LinkedList<>();

        for(int i = 0; i <= haystackCharArray.length - needleCharArray.length; i++)   {

            if(haystackCharArray[i] == needleCharArray[0])  {

                j = 1;
                while(j < needleCharArray.length && haystackCharArray[i+j] == needleCharArray[j])   {
                    j++;
                }
                if(j == needleCharArray.length) {
                    res.add(i);
                }
            }
        }

        return res;
    }
}
