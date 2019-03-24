package com.coding.practice.datastructure.advance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BreadthFirstSearch {

    public class Node   {

        int value;
        String color;
        int startTime;
        int finishTime;
        int predecessor;
        int distance;

        Node(int i)  {
            value = i;
            color = "WHITE";
            startTime = 0;
            finishTime = 0;
            distance = Integer.MAX_VALUE;
            predecessor = -1;
        }
    }

    int time = 0;

    public static void main(String[] args)  throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int noOfQuery = Integer.parseInt(line.trim());
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        for(int i = 0; i < noOfQuery; i++) {

            line = br.readLine();
            int noOfNodes = Integer.parseInt(line.split(" ")[0]);
            int noOfEdges = Integer.parseInt(line.split(" ")[1]);

            Graph graph = new Graph(noOfNodes);

            for (int j = 0; j < noOfEdges; j++) {
                line = br.readLine();
                graph.addEdge(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]));
            }
            line = br.readLine().trim();
            int source = Integer.parseInt(line);
            bfs.BFS(graph, source);
        }
        br.close();
    }

    public void BFS(Graph graph, int source)   {

        source--;
        LinkedList<Node> node = new LinkedList<Node>();
        Queue<Integer> nodeTracker = new LinkedList<Integer>();

        for(int i = 0; i < graph.getNoOfNodes(); i++)   {
            Node newNode = new Node(i+1);
            node.add(newNode);
        }

        nodeTracker.add(source);
        node.get(source).color = "GRAY";
        node.get(source).distance = 0;

        while(!nodeTracker.isEmpty())   {
            time = time + 1;
            source = nodeTracker.poll();
            node.get(source).startTime = time;
            for(int dest : graph.adjListArray[source])  {
                if(node.get(dest).color .equals("WHITE"))  {

                    //time = time + 1;
                    node.get(dest).startTime = time;
                    node.get(dest).predecessor = node.get(source).value;
                    node.get(dest).distance = node.get(source).distance + 1;
                    node.get(dest).color = "BLACK";
                    nodeTracker.add(dest);
                }
            }
            time = time + 1;
            node.get(source).color = "BLACK";
            node.get(source).finishTime = time;
        }

        System.out.println("BFS");
        System.out.println("Node# Distance Predecessor");
        for(Node n : node)  {
            System.out.println(n.value + "  " + n.distance + "  " + n.predecessor);
        }

    }
}
