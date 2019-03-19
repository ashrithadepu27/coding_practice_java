package com.java.algo.basic.graph;

public class WallAndGates {

    private static int[] rowManipulation = new int[]{-1, 0, 0, 1};
    private static int[] columnManipulation = new int[]{0, -1, 1, 0};
    public static final int INF = Integer.MAX_VALUE;

    public int[][] updateDistanceToGate(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    boolean[][] isVisited = new boolean[grid.length][grid[0].length];
                    dfs(grid, i, j, 0, isVisited);
                }
            }
        }
        return grid;
    }

    public void dfs(int[][] grid, int r, int c, int dist, boolean[][] isVisted) {

        int r1, c1;
        isVisted[r][c] = true;
        if(grid[r][c] > 0 && dist < grid[r][c]) {
            grid[r][c] = dist;
        }
        dist++;

        for(int k = 0; k < rowManipulation.length; k++) {
            r1 = r + rowManipulation[k];
            c1 = c + columnManipulation[k];
            if(inGrid(r1, c1, grid.length, grid[0].length) && grid[r1][c1] > 0 && !isVisted[r1][c1]) {
                dfs(grid, r1, c1, dist, isVisted);
            }
        }
    }

    private boolean inGrid(int r, int c, int row, int col) {
        return  (r >= 0 && r < row && c >= 0 && c < col);
    }
}
