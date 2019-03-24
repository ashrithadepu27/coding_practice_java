package com.coding.challenge.visa;

import java.util.*;

public class Question2 {

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {

        int totalHour = 0;
        int spaceCount = 0;
        for(int i=0; i<pattern.length(); i++) {
            if(pattern.charAt(i) != '?') {
                System.out.println((int)(pattern.charAt(i))-48);
                totalHour += (int)(pattern.charAt(i))-48;
            } else {
                spaceCount++;
            }
        }
        int[] res = new int[spaceCount];
        int remainHours = workHours - totalHour;
        List<List<Integer>> finalRes = new LinkedList<>();
//        findCombination(res, dayHours, remainHours, spaceCount, 0, finalRes );
        calculateAllPossibilities(finalRes, dayHours, remainHours, spaceCount, res, 0);
        List<String> outRes = new LinkedList<>();
        for(List<Integer> re : finalRes) {
            int pos = 0;
            char[] temp = pattern.toCharArray();
            for(int i=0; i<temp.length; i++) {
                if(temp[i] == '?') {
                    int digit = re.get(pos);
                    temp[i] = (char)(digit+48);
                    pos++;
                }
            }
            outRes.add(new String(temp));
        }
        return outRes;

    }

//    public static void findCombination(int[] res, int num, int reducenum, int spaceCount, int index, List<List<Integer>> finalRes) {
//
//        if(reducenum<0) {
//            return;
//        }
//        if(reducenum == 0) {
//            List<Integer> lst = new LinkedList<>();
//            for(int i: res) {
//                lst.add(i);
//            }
//            finalRes.add(lst);
//            return;
//        }
//        if(index == spaceCount) {
//            return;
//        }
//        for(int i=0; i<num+1; i++) {
//            res[index] = i;
//            findCombination(res, num, reducenum-i, spaceCount, index+1, finalRes);
//            res[index] = 0;
//        }
//
//        return ;
//    }

    private static void calculateAllPossibilities(List<List<Integer>> allPossibility, int dayHours, int remainingHours, int dayAvailable, int[] p, int index) {

        if(remainingHours < 0) return;

        if(remainingHours == 0) {
            List<Integer> pos = new LinkedList<>();
            for(int i : p) pos.add(i);

            allPossibility.add(pos);
            return;
        }
        if(index == dayAvailable) return;

        for(int i = 0; i <= dayHours; i++) {
            p[index] = i;
            calculateAllPossibilities(allPossibility, dayHours, remainingHours-i, dayAvailable, p, index+1);
            p[index] = 0;
        }
        return;
    }

    public static void main(String[] args) {
//        List<String> out = findSchedules(32, 6, "??87???");
        List<String> out = findSchedules(3, 2, "??2??00");

        for(String s : out) {
            System.out.println(s);
        }
    }
}
