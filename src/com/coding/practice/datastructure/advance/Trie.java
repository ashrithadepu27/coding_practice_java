package com.coding.practice.datastructure.advance;

import java.util.HashMap;

public class Trie {

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

    public Trie()   {
        root = new TrieNode();
    }

    public void insert(String word)    {
        TrieNode current = root;
        current.noOfWords++;
        for(Character c : word.toCharArray())   {
            TrieNode node = current.children.get(c);
            if(node == null)   {
                node = new TrieNode();
                current.children.put(c, node);
            }
            node.noOfWords++;
            current = node;
        }
        current.endOfWord = true;
    }

    public void delete(String word)    {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index)    {

        if(index == word.length())  {
            if(!current.endOfWord)
                return false;
            current.endOfWord = false;
            current.noOfWords--;
            return  current.noOfWords == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index+1);

        //System.out.println(current.noOfWords + " " + ch + "  " + shouldDeleteCurrentNode);
        current.noOfWords--;
        if(shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.noOfWords == 0;
        }
        return false;
    }

    public TrieNode search(String word, boolean partialSearch)    {
        TrieNode current = root;
        for(Character c : word.toCharArray())   {
            TrieNode node = current.children.get(c);
            if(node == null)    {
                return null;
            }
            current = node;
        }
        if(current.endOfWord || partialSearch)
            return current;
        else
            return null;
    }

    public static void main(String[] args)  {
        Trie t = new Trie();
        t.insert("earth");
        t.insert("ear");
        t.insert("earthling");
        t.insert("east");
        t.insert("world");
        t.insert("war");
        t.insert("mars");
        TrieNode n = t.search("ea", true);
        System.out.println("ea " + n.noOfWords);
        n = t.search("ear", true);
        System.out.println("ear " + n.noOfWords);
        t.delete("earthling");
        n = t.search("ear", true);
        System.out.println("ear " + n.noOfWords);
    }
}
