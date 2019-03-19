package com.java.algo.basic.graph;

public class GraphProblemFactory {

    public static void printGrid(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][]=  new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        int grid2[][] = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int[][] grid3 = new int[][]{
                {}
        };

        int grid4[][] = new int[][] {
                {WallAndGates.INF, -1, 0, WallAndGates.INF},
                {WallAndGates.INF, WallAndGates.INF, WallAndGates.INF, -1},
                {WallAndGates.INF, -1, WallAndGates.INF, -1},
                {0, -1, WallAndGates.INF, WallAndGates.INF}
        };

        Islands t = new Islands(4);
        Islands t2 = new Islands();
        DistinctIslands d1 = new DistinctIslands(4);
        DistinctIslands d2 = new DistinctIslands();

        printGrid(grid2);
        System.out.println("Number of islands is (4 neighbors): "+ t.countIslands(grid2));
        System.out.println("Number of islands is (8 neighbors): "+ t.countIslands(grid2));
//        System.out.println("Number of distinct islands is (4 neighbors): "+ d1.getNoOfDistinctIslands(grid2));
        System.out.println("Number of distinct islands is (8 neighbors): "+ d2.getNoOfDistinctIslands(grid1));
        System.out.println();


//        printGrid(grid4);
//        WallAndGates wg = new WallAndGates();
//        System.out.println("After adding distance:");
//        printGrid(wg.updateDistanceToGate(grid4));
    }

}
