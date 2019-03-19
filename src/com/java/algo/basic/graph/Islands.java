package com.java.algo.basic.graph;

public class Islands {

    private int[] rowManipulation;
    private int[] columnManipulation;
    private int noOfNeighbors;
    private int area;

    public Islands() {
        this.noOfNeighbors = 8;
        this.rowManipulation = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        this.columnManipulation = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    }

    public Islands(int noOfNeighbors) {
        this.noOfNeighbors = noOfNeighbors;
        if(this.noOfNeighbors == 4) {
            this.rowManipulation = new int[]{-1, 0, 0, 1};
            this.columnManipulation = new int[]{0, -1, 1, 0};
        } else {
            this.rowManipulation = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            this.columnManipulation = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        }
    }

    public int countIslands(int[][] island) {
        int noOfIslands = 0;
        int n = island.length, m = n == 0 ? 0 : island[0].length;
        int maxArea = 0;
        boolean[][] isVisited = new boolean[n][m];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(island[row][col] == 1 && !isVisited[row][col]) {
                    area = 0;
                    dfs(island, row, col, isVisited);
                    noOfIslands++;
                    maxArea = maxArea < area ? area : maxArea;
                }
            }
        }
        System.out.println("Maximun area: " + maxArea);
        return noOfIslands;
    }

    private void dfs(int[][] island, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;
        area++;
        for(int i = 0; i < rowManipulation.length; i++) {
            if(canVisit(island, row + rowManipulation[i], col +columnManipulation[i], isVisited)) {
                dfs(island, row + rowManipulation[i], col + columnManipulation[i], isVisited);
            }
        }
    }

    private boolean canVisit(int[][] island, int row, int col, boolean[][] isVisited) {
        int N = island.length;
        int M = island[0].length;

        if(row >= N || row < 0 || col < 0 || col >= M)
            return false;
        return !isVisited[row][col] && island[row][col] == 1;
    }
}
