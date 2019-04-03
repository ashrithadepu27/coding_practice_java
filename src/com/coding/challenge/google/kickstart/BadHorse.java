package com.coding.challenge.google.kickstart;

import java.io.*;
import java.util.*;

public class BadHorse {

    private static final char UNASSIGNED = 'U';
    private static final char WHITE = 'W';
    private static final char BLACK = 'B';

    private Map<String, Node> teamMapping = new HashMap<>();

    class Node {

        private String teamName;
        private char color;
        private Set<Node> edges;

        public Node(String teamName) {
            this.teamName = teamName;
            edges = new HashSet<>();
            color = UNASSIGNED;
        }

        public void setColor(char color) {
            this.color = color;
        }

        public char getColor() {
            return this.color;
        }

        public void addEdge(Node team) {
            this.edges.add(team);
        }

        public Set<Node> getEdge() {
            return this.edges;
        }
    }

    private boolean twoColor() {
        return true;
    }

    public static void main(String[] args) {

        try {
            Scanner in;
            PrintWriter out = null;
            boolean outputFile = false;
            String[] teams = new String[2];
            if(args.length > 0)	{
                File file = new File(args[0]);
                in = new Scanner(file);
            }
            else
                in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            if(args.length == 2)	{
                out = new PrintWriter(args[1]);
                outputFile = true;
            }
            int noOfTestCases = in.nextInt(), noOfGroups;
            for(int i = 1; i <= noOfTestCases; i++) {
                noOfGroups = in.nextInt();
                BadHorse bh = new BadHorse();
                for(int j = 0; j <= noOfGroups; j++) {
                    teams[0] = in.next();
                    teams[1] = in.next();
                    Node team1 = bh.teamMapping.getOrDefault(teams[0].trim(), bh.new Node(teams[0].trim()));
                    Node team2 = bh.teamMapping.getOrDefault(teams[1].trim(), bh.new Node(teams[1].trim()));
                    team1.addEdge(team2);
                    team2.addEdge(team1);
                }

                boolean isSuccess = bh.twoColor();
                System.out.println("Case #" + i + (isSuccess ? ": YES" : ": NO"));
            }
            in.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
