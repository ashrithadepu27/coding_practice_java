/**
 * The Challenge *
 Given a string S and a set of words D, find the longest word in D that is a subsequence of S.

 Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.

 Note: D can appear in any format (list, hash table, prefix tree, etc.

 For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"

 The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
 The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
 The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
 */


package com.java.google.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWordInDictionary {

    public boolean isSubsequence(String sequence, String word)  {
        char[] w = word.toCharArray();
        char[] s = sequence.toCharArray();

        int i = 0, j = 0;
        while(i < w.length && j < s.length) {
            if(w[i] == s[j])    {
                i++; j++;
            }
            else    {
                j++;
            }
        }
        if(i == w.length)
            return true;
        else
            return false;
    }

    public int search(List<Integer> val, Integer s) {

        for(int i = 0; i < val.size(); i++) {
            if(s < val.get(i))
                return i;
        }
        return -1;
    }

    public boolean isSubsequenceOptimized(Map<String, List> wordSequence, String word)  {
        char[] w = word.toCharArray();
        int i = 0;
        int j = -1;
        while(i < w.length) {
            if(wordSequence.containsKey(String.valueOf(w[i])))  {
                List<Integer> v = wordSequence.get(String.valueOf(w[i]));
                if(j < v.get(0)) {
                    j = v.get(0);
                }
                else if(j >= v.get(v.size()-1))   {
                    return false;
                }
                else    {
                    j = search(v, j);
                }
                i++;
            }
            else
                return false;
        }
        if(i==w.length)
            return true;
        return false;
    }

    public String longestWordInString(String word, List<String> letters)    {

        if(letters == null || letters.size() == 0 || word == null)  {
            return null;
        }

        int maxLength = -1;
        String maxLengthWord = new String();
        for(String s : letters) {
            if(s.length() == word.length()) {
                if(s.equals(word))
                    return s;
            }
            else if(s.length() < word.length()) {
                if(isSubsequence(word, s))  {
                    if(maxLength < s.length())  {
                        maxLength = s.length();
                        maxLengthWord = s;
                    }
                }
            }
        }
        return maxLengthWord;
    }

    public Map preProcess(String sequence)  {
       Map<String, List> wordMapping = new HashMap<>();

       char[] s = sequence.toCharArray();
       for(int i = 0; i < s.length; i++)    {
           if(wordMapping.containsKey(String.valueOf(s[i])))   {
               List val = wordMapping.get(String.valueOf(s[i]));
               val.add(i);
               wordMapping.put(String.valueOf(s[i]), val);
           }
           else {
               List val = new ArrayList<Integer>();
               val.add(i);
               wordMapping.put(String.valueOf(s[i]), val);
           }
       }
       return wordMapping;
    }

    public String longestWordInStringOptimized(String word, List<String> letters)    {
        if(letters == null || letters.size() == 0 || word == null)  {
            return null;
        }

        int maxLength = -1;
        String maxLengthWord = new String();
        Map<String, List> wordMapping = preProcess(word);

        for(String s : letters) {
            if(s.length() == word.length()) {
                if(s.equals(word))
                    return s;
            }
            else if(s.length() < word.length()) {
                if(isSubsequenceOptimized(wordMapping, s))  {
                    if(maxLength < s.length())  {
                        maxLength = s.length();
                        maxLengthWord = s;
                    }
                }
            }
        }

        return maxLengthWord;
    }

    public static void main(String args[])  {

        LongestWordInDictionary lwd = new LongestWordInDictionary();
        String sequence = "abppplee";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("able");
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("bale");
        dictionary.add("kangaroo");

//        System.out.println(lwd.longestWordInStringOptimized(sequence, dictionary));
        System.out.println(lwd.sumNumbers("abc123xyz"));
    }


    public int sumNumbers(String str) {
        int sum = 0, t = -1;
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i)))  {
                if(t==-1)
                    t = i;
            }
            else {
                if(t != -1) {
                    sum += Integer.parseInt(str.substring(t, i ));
                    t = -1;
                }
            }
        }
        if(t != -1)
            sum += Integer.parseInt(str.substring(t, str.length() ));
        return sum;
    }

}
