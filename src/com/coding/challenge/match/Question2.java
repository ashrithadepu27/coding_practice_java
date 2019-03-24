package com.coding.challenge.match;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Question2 extends  Question1{


    static String electionWinner(String[] votes) {
        // Contains count of vote for respective candidates
        Map<String, Integer> candidate = new TreeMap();
        int c;

        for(String cand : votes) {
            if(candidate.containsKey(cand)) {
                candidate.put(cand, candidate.get(cand)+1);
            } else {
                candidate.put(cand, 1);
            }
        }

        int max = -1;
        String winner = "";
         for(String cand : candidate.keySet()) {
             if(max <= candidate.get(cand) && (winner == null || cand.compareTo(winner) > 0)) {
                 System.out.println(cand + "  " + winner + "  " + cand.compareTo(winner));
                 max = candidate.get(cand);
                 winner = cand;
             }
         }

        System.out.println(max);
        return winner;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        String[] v = "Alex Michael Harry Dave Michael Victor Harry Alex Mary Mary".split(" ");
        System.out.println("ASdASDasd " + electionWinner(v));
    }
}