package com.coding.sites.geeksforgeeks;

import java.util.*;

public class NoPrefixSet {

    private class TrieNode  {
        boolean endOfWord;
        int noOfWords;
        HashMap<Character, TrieNode> children;

        TrieNode()  {
            endOfWord = false;
            noOfWords = 0;
            children = new HashMap<>();
        }
    }

    private final TrieNode root;

    public NoPrefixSet()   {
        root = new TrieNode();
    }

    public boolean insert(String word)    {
        TrieNode current = root;
        current.noOfWords++;
        for(Character c : word.toCharArray())   {
            TrieNode node = current.children.get(c);
            if(node == null)   {
                node = new TrieNode();
                current.children.put(c, node);
            }
            else    {
                if(node.endOfWord)
                    return false;
            }
            node.noOfWords++;
            current = node;
        }
        if(current.noOfWords > 1)
            return false;
        current.endOfWord = true;
        return true;
    }

    public static void main(String[] args) {
        NoPrefixSet noPrefixSet = new NoPrefixSet();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String temp ;
        boolean  flag =false;
        for(int i =0; i < n; i++)   {
            temp = in.next();
            if(!noPrefixSet.insert(temp))   {
                System.out.println("BAD SET");
                System.out.println(temp);
                flag = true;
                i = n;
            }
        }
        if(!flag)
            System.out.println("GOOD SET");

        in.close();
    }
}
