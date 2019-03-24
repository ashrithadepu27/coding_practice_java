package com.coding.challenge.facebook;

import java.util.*;

public class RebuildList {

    private Deque<Integer> deque;

    public RebuildList() {
        deque = new LinkedList<>();
    }

    private int get() {
//        switch ()
        return deque.removeLast();
    }

    public List<Integer> rebuildArray(Deque<Integer> nums) {

        int[] rebuildList = new int[nums.size()];
        Arrays.fill(rebuildList, -1);
        int topTail = -1, bottomHead = nums.size();
        while(!nums.isEmpty()) {
            int n = get();
            if(topTail == -1) {
                topTail++;
                rebuildList[topTail] = n;
            } else if(n < rebuildList[topTail]) {
                bottomHead--;
                rebuildList[bottomHead] = rebuildList[topTail];
                rebuildList[topTail] = n;
            } else {
                topTail++;
                rebuildList[topTail] = n;
            }
        }
        List<Integer> res = new LinkedList<>();
        for(int n : rebuildList) {
            res.add(n);
        }
        return res;
    }

    public static void main(String[] args) {
        RebuildList rl = new RebuildList();
        for(int i = 1; i <= 10; i++) {
            rl.deque.add(i);
        }

        List<Integer> rL = rl.rebuildArray(rl.deque);

        System.out.println("Array Rebuild:");
        for(Object n : rL) {
            System.out.print(n + " ");
        }
    }
}
