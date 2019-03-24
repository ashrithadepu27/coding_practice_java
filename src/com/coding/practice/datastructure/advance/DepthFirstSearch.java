package com.coding.practice.datastructure.advance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DepthFirstSearch {

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
            distance = 0;
            predecessor = -1;
        }
    }

    int time = 0;

    public static void main(String[] args)  throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int noOfQuery = Integer.parseInt(line.trim());
        DepthFirstSearch dfs = new DepthFirstSearch();
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
            dfs.DFS(graph, source);
            bfs.BFS(graph, source);
        }
        br.close();
    }

    public void DFS(Graph graph, int source)   {

        source--;
        LinkedList<Node> node = new LinkedList<Node>();

        for(int i = 0; i < graph.getNoOfNodes(); i++)   {
            Node newNode = new Node(i+1);
            node.add(newNode);
        }

        node.get(source).distance = 0;
        DFS_Visit(graph, node, source);

        System.out.println("DFS");
        System.out.println("Node#  StartTime  FinishTime  Predecessor");
        for(Node n : node)  {
            System.out.println(n.value + "  " + n.startTime + "  " + n.finishTime + "  " + n.predecessor);
        }
    }


    public void DFS_Visit(Graph graph, LinkedList<Node> node, int source) {

        time = time+1;
        node.get(source).startTime = time;
        node.get(source).color = "GRAY";

        for(int i : graph.adjListArray[source]) {
            if(node.get(i).color.equals("WHITE"))   {
                node.get(i).predecessor = node.get(source).value;
                DFS_Visit(graph, node, i);
            }
        }
        node.get(source).color = "BLACK";
        time = time + 1;
        node.get(source).finishTime = time;
    }

    /*
    Test Case:
    1
    6 6
    1 2
    1 3
    1 6
    2 3
    2 4
    4 5
    1
     */
}
