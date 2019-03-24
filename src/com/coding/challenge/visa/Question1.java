package com.coding.challenge.visa;

import java.util.*;

public class Question1 {

    private static final Map<String, Integer> month;
    static {
        month = new HashMap<>();
        month.put("Jan", 1);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
        month.put("May", 5);
        month.put("Jun", 6);
        month.put("Jul", 7);
        month.put("Aug", 8);
        month.put("Sep", 9);
        month.put("Oct", 10);
        month.put("Nov", 11);
        month.put("Dec", 12);
    }

    public static List<String> sortDates(List<String> dates) {


        List<String> resDate = new ArrayList<>();
        // Base Cases
        if(dates.size() == 0) return resDate;
        if(dates.size() == 1) {
            resDate.add(dates.get(0));
            return resDate;
        }

        Map<String, Integer> sortedDate = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] datePart1 = o1.split(" ");
                String[] datePart2 = o2.split(" ");
                int comp = Integer.valueOf(datePart1[2]).compareTo(Integer.valueOf(datePart2[2]));
                if(comp == 0) {
                    int comp2  = month.get(datePart1[1]).compareTo(month.get(datePart2[1]));
                    if(comp2 == 0) {
                        return Integer.valueOf(datePart1[0]).compareTo(Integer.valueOf(datePart2[0]));
                    } else {
                        return comp2;
                    }
                } else {
                    return comp;
                }
            }
        });
        int t;
        for(String d : dates) {
            if(sortedDate.containsKey(d)) {
                sortedDate.put(d, sortedDate.get(d) + 1);
            } else {
                sortedDate.put(d, 1);
            }
        }

        for(String date : sortedDate.keySet()) {
            for(int i = 0 ; i < sortedDate.get(date); i++) {
                resDate.add(date);
            }
        }
        return resDate;
    }


    public static void main(String[] args) {

        List<String> d = new ArrayList<String>();
        d.add("20 Oct 2052");
        d.add("06 Jun 1933");
        d.add("26 May 1960");
        d.add("20 Sep 1958");

        List<String> res = sortDates(d);

        System.out.println("res output");
        for(String s : res) {
            System.out.println(s);
        }
    }
}
