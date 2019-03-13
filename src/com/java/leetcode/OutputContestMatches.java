/**
 * Question #544
 * -------------
 * During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank nth team, which is a good strategy to make the contest
 * more interesting. Now, you're given n teams, you need to output their final contest matches in the form of a string.
 *
 * The n teams are given in the form of positive integers from 1 to n, which represents their initial rank.
 * (Rank 1 is the strongest team and Rank n is the weakest team.) We'll use parentheses('(', ')') and commas(',') to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',')
 * for partition. During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 *
 *
 * Input: 8
 * Output: (((1,8),(4,5)),((2,7),(3,6)))
 * Explanation:
 * First round: (1,8),(2,7),(3,6),(4,5)
 * Second round: ((1,8),(4,5)),((2,7),(3,6))
 * Third round: (((1,8),(4,5)),((2,7),(3,6)))
 * Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).
  */


package com.java.leetcode;

public class OutputContestMatches {

    public static void main(String[] args) {
        System.out.println(outputMatches(16));
    }

    private static String outputMatches(int n) {
        String[] team = new String[n];
        for (int i = 1; i <= n; ++i)
            team[i-1] = "" + i;

        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; ++i)
                team[i] = "(" + team[i] + "," + team[n-1-i] + ")";

        return team[0];
    }
}