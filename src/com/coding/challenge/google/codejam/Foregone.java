package com.coding.challenge.google.codejam;

import java.util.*;

class Foregone {


    private int[] replace4s(int n) {
        int ans[] = new int[2];
        char[] number = String.valueOf(n).toCharArray();

        int i = number.length-1;
        for(char c : number) {
            if(c == '4') {
                ans[1] += Math.pow(10, i);
            }
            i--;
        }
        ans[0] = n - ans[1];
        return ans;
    }

    public static void main(String[] args) {

        Foregone f = new Foregone();
        Scanner in = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        int noOfTestCases = in.nextInt(), n, i = 1;
        int ans[];
        while(i <= noOfTestCases) {
            n = in.nextInt();
            ans = f.replace4s(n);
            result.add("Case #" + i + ": " + ans[0] + (ans[1] != 0 ? " " + ans[1] : "" + "  " + ans[0] + ans[1]));
            i++;
        }
        in.close();
        for(String s : result) {
            System.out.println(s);
        }
    }
}