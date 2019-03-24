package com.coding.sites.geeksforgeeks;

import java.util.*;

public class RunningMedian {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        double[] medians = getMedians(a);
        for(double d : medians)  {
            System.out.println(d);
        }
    }

    public static double[] getMedians(int[] arr)  {
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        double[] medians = new double[arr.length];
        for(int i =0; i < arr.length; i++)  {
            int num = arr[i];
            addNumber(num, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if(lowers.size() == 0 || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }

    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() - smallerHeap.size() > 1)  {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() == smallerHeap.size())
            return Double.valueOf(biggerHeap.peek() + smallerHeap.peek())/2;
        else    {
            return Double.valueOf(biggerHeap.peek());
        }
    }
}
