package com.coding.sites.geeksforgeeks;

import java.util.*;

public class MakingAnagram {

    private static Map<Character, Integer> alpha = new HashMap<Character, Integer>();

    public static int numberNeeded(String first, String second) {
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int count = 0;
        for(char c : a)   {
            if(alpha.containsKey(c))    {
                alpha.put(c, alpha.get(c) + 1);
            }
            else    {
                alpha.put(c, 1);
            }
        }
        for(char c : b) {
            if(alpha.containsKey(c))    {
                alpha.put(c, alpha.get(c) - 1);
            }
            else    {
                alpha.put(c, -1);
            }
        }
        for (Map.Entry<Character, Integer> entry : alpha.entrySet())
        {
            count += Math.abs(entry.getValue());
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
