package com.coding.sites.leetcode;

import java.util.*;

public class MostCommonWord {

    public List<String> mostCommonWord(String str, List<String> block_words) {

        String[] words = str.toLowerCase().split("[^a-z]");
        int maxCount = 0, count = 0;
        Set<String> blockedWordSet = new HashSet<>();
        Map<String, Integer> wordCount = new HashMap<>();
        for(String s : block_words) {
            blockedWordSet.add(s.toLowerCase());
        }


        for(String s : words) {
            if(s.length() > 0 && !blockedWordSet.contains(s)) {
                if(wordCount.containsKey(s)) {
                    count = wordCount.get(s) + 1;
                    wordCount.put(s, count);

                } else {
                    count = 1;
                    wordCount.put(s, count);
                }
                maxCount = count > maxCount ? count : maxCount;
            }
        }

        List<String> result = new LinkedList<>();
        for(String s : wordCount.keySet()) {
            if(wordCount.get(s) == maxCount) {
                result.add(s);
            }
        }

        return result;
    }

    public  void splitWord(String s) {

        char[] chars = s.toLowerCase().toCharArray();
        List<String> st = new LinkedList<>();

        int start = 0, end = 0;
//        for(char c : chars) {
//            if(c >= 'a' && c <= 'z') {
//                end++;
//            } else {
//                if(start <= end) {
//                    st.add(s.substring(start, end));
//                    start = end+1;
//                    end = start;
//                }
//            }
//        }
        for(String t : st) System.out.println(t);
        while(start < chars.length && end <chars.length ) {
            char c = chars[end];
            //System.out.println(c + "  " + start + "  " + end);
            if(c >= '0' && c <= '9') {
                end++;
                if(end == chars.length){
                    st.add(s.substring(start, end));
                }
            } else if(start <= end) {
                String temp = s.substring(start, end);
                if(!temp.equals(""))    st.add(temp);
                start = end+1;
                }
            else {
                end++;
            }
        }
        for(String t : st) System.out.println(t);

    }

    public static void main(String[] args) {
        MostCommonWord mcw = new MostCommonWord();
        List<String> banned =  new ArrayList<>();
        banned.add("is");
        banned.add("are");
        banned.add("a");
//        System.out.println(mcw.mostCommonWord("Rose is a flower red rose are flower", banned));
        mcw.splitWord("Rose,,,123 is a flower's 908red rose are008 flower.");
    }
}
