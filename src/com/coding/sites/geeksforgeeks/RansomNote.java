package com.coding.sites.geeksforgeeks;

import java.util.Map;
import java.util.Hashtable;
import java.util.Scanner;

public class RansomNote {

    private static Map<String, Integer> dictionary = new Hashtable<>();

    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        boolean flag = false;
        String temp;
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            if(!dictionary.containsKey(magazine[magazine_i]))   {
                dictionary.put(magazine[magazine_i], 1);
            }
            else    {
                dictionary.put(magazine[magazine_i], dictionary.get(magazine[magazine_i])+1);
            }
        }
        for(int i=0; i < n; i++){
            temp = in.next();
            if(!dictionary.containsKey(temp))  {
                flag = false;
                System.out.println("No");
                break;
            }
            else    {
                if(dictionary.get(temp) < 1)    {
                    flag = false;
                    System.out.println("No");
                    break;
                }
                else    {
                    flag = true;
                    dictionary.put(temp, dictionary.get(temp)-1);
                }

            }
        }
        if(flag)    {
            System.out.println("Yes");
        }
    }
}
