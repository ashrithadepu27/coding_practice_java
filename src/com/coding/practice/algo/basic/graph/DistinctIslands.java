package com.coding.practice.algo.basic.graph;

import javafx.util.Pair;

import java.util.*;

public class DistinctIslands {

    private static int[] rowManipulation;
    private static int[] columnManipulation;
    private int noOfNeighbors;
    private int ROW, COL;
    private Map<Integer, List<Stack>> islands = new HashMap<>();

    public DistinctIslands() {
        this.noOfNeighbors = 8;
        this.rowManipulation = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        this.columnManipulation = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    }

    public DistinctIslands(int noOfNeighbors) {
        this.noOfNeighbors = noOfNeighbors;
        if(this.noOfNeighbors == 4) {
            this.rowManipulation = new int[]{-1, 0, 0, 1};
            this.columnManipulation = new int[]{0, -1, 1, 0};
        } else {
            this.rowManipulation = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            this.columnManipulation = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        }
    }

    public int getNoOfDistinctIslands(int[][] grid) {
        ROW = grid.length;
        COL = ROW == 0 ? 0 : grid[0].length;
        int distinctIslands = 0;
        boolean[][] isVisited = new boolean[ROW][COL];

        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                if(grid[i][j] == 1 && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited);
                    distinctIslands++;
                }
            }
        }
        return distinctIslands;
    }

    public void dfs(int[][] grid, int r, int c, boolean[][] isVisited) {
        Stack<Pair> stack = new Stack<>();
        dfsUtils(grid, r, c, isVisited, stack);
        List<Stack> i = islands.getOrDefault(stack.size(), new LinkedList<>());
        i.add(stack);
        islands.put(stack.size(), i);
    }

    public void dfsUtils(int[][] grid, int r, int c, boolean[][] isVisited, Stack stack) {
        isVisited[r][c] = true;
        stack.push(new Pair<Integer, Integer>(r, c));
        for(int i = 0; i < noOfNeighbors; i++) {
            int r1 = r + rowManipulation[i], c1 = c + columnManipulation[i];
            if(canVisit(grid, r1, c1) && !isVisited[r1][c1]) {
                dfsUtils(grid, r1, c1, isVisited, stack);
            }
        }
    }

    public boolean canVisit(int[][] grid, int r, int c) {
        return (r >= 0 && r < ROW && c >= 0 && c < COL && grid[r][c] == 1);
    }
}
