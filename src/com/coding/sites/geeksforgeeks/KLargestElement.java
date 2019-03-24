package com.coding.sites.geeksforgeeks;

import java.util.PriorityQueue;

public class KLargestElement {

    public static int klargestNumber(int[] num, int k) {

        if(k > num.length) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i : num ) {
            pq.offer(i);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] in = new int[6];
        in[0] = 1;
        in[1] = 4;
        in[2] = 3;
        in[3] = 4;
        in[4] = 2;
        in[5] = 5;
        System.out.println(klargestNumber(in, 3));
    }
}
