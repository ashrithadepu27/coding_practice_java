package com.coding.practice.string;

import java.util.*;

public class WordBreak {

    private Map<String, Boolean> seenWords = new HashMap<>();
    private Set<String> dict = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return wordBreakUtil(s);
    }

    private boolean wordBreakUtil(String s) {

        if(s.equals("")) return true;
        if(seenWords.containsKey(s)) return seenWords.get(s);

        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(dict.contains(temp)) {
                if(wordBreakUtil(s.substring(i))) {
                    seenWords.put(temp, true);
                    return true;
                }
            }
        }
        seenWords.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println((new WordBreak()).wordBreak(s, wordDict));

    }
}
