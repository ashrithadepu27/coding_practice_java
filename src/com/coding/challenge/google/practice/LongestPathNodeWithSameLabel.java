package com.coding.challenge.google.practice;

import java.util.*;

public class LongestPathNodeWithSameLabel {

    public Map<Integer, Set<Integer>> adjancyList(int[] A, int[] E)    {

        Map<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();

        for(int i = 0; i < E.length; i+= 2)  {
            if(A[E[i]-1] == A[E[i+1]-1]) {
                if (adjList.containsKey(E[i])) {
                    Set connectedNode1 = adjList.get(E[i]);
                    Set connectedNode2 = adjList.get(E[i+1]);
                    if(connectedNode1 == null)
                        connectedNode1 = new HashSet<Integer>();
                    if(connectedNode2 == null)
                        connectedNode2 = new HashSet<Integer>();
                    connectedNode1.add(E[i+1]);
                    connectedNode2.add(E[i]);
                    adjList.put(E[i], connectedNode1);
                    adjList.put(E[i+1], connectedNode2);

                } else {
                    Set connectedNode1 = new HashSet<Integer>();
                    connectedNode1.add(E[i+1]);
                    Set connectedNode2 = new HashSet<Integer>();
                    connectedNode2.add(E[i]);
                    adjList.put(E[i], connectedNode1);
                    adjList.put(E[i+1], connectedNode2);
                }
            }
        }
        return adjList;
    }

    private int longestPathLength(int[] A, int[] E)   {
        int maxCount = 0;
        Map<Integer, Set<Integer>> adjList = adjancyList(A, E);

        for(int parentNode : adjList.keySet())   {
            int count = 0;

            if(count > maxCount)
                maxCount = count;
        }
        return maxCount;
    }

    public static void main(String[] args)  {

        int[] A = new int[5];
        A[0] = 1;
        A[1] = 1;
        A[2] = 1;
        A[3] = 2;
        A[4] = 2;

        int[] E = new int[8];
        E[0] = 1;
        E[1] = 2;
        E[2] = 1;
        E[3] = 3;
        E[4] = 2;
        E[5] = 4;
        E[6] = 2;
        E[7] = 5;

        System.out.println(new LongestPathNodeWithSameLabel().longestPathLength(A, E));
    }
}
