package com.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class StockPrice {


    public static int worstPerformingStock(List<List<Integer>> stocks) {

        int len = stocks.size();
        if(len == 0){
            return 0;
        }
        double min = Double.MAX_VALUE;
        int stockId = 0;
        for(int i=0; i<len; i++) {
            int id = stocks.get(i).get(0);
            int open = stocks.get(i).get(1);
            int close = stocks.get(i).get(2);
            double rate = ((double)close - open)/(double)open;
            if(rate < min){
                min = rate;
                stockId = id;
            }
        }
        return stockId;
    }

    public static void main(String[] args) {

        List<List<Integer>> stock = new ArrayList<List<Integer>>();

        List<Integer> s = new ArrayList<>();
        s.add(1200);
        s.add(100);
        s.add(105);
        stock.add(s);
        List<Integer> s1 = new ArrayList<>();
        s1.add(1400);
        s1.add(50);
        s1.add(55);
        stock.add(s1);

        System.out.println(worstPerformingStock(stock));
    }
}
