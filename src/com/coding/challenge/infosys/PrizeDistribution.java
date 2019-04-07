package com.coding.challenge.infosys;

import java.util.*;

public class PrizeDistribution {


    private static int noOfStudentReceivingPrize(int k, List<Integer> marks) {

        Set<Integer> topKStudents = new TreeSet<>(Collections.reverseOrder() );
        topKStudents.addAll(marks);
        int ma = 0;
        for(int m : topKStudents) {
            ma = m;
            k--;
            if(k==0)
                break;
        }
        System.out.println(ma);
        int count = 0;
        for(int m : marks) {
            if(m >= ma)
                count++;
        }
       return count;
    }

    public static void main(String[] args) {

        List<Integer> marks = new ArrayList<>();
        marks.add(99);
        marks.add(100);
        marks.add(96);
        marks.add(99);
        marks.add(100);
        marks.add(98);
        marks.add(93);
        marks.add(92);
        marks.add(90);
        int n = noOfStudentReceivingPrize(4, marks);
        System.out.println(n);
    }
}
