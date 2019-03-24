package com.coding.practice.datastructure.advance;

import java.util.LinkedList;

public class Graph {

    private int V;
    LinkedList<Integer> adjListArray[];

    Graph(int noOfNodes)  {
        V = noOfNodes;
        adjListArray = new LinkedList[noOfNodes];
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        src--; dest--;
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }

    void printGraph()  {
        for(int v = 0; v < V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    int getNoOfNodes()  {
        return V;
    }
}
