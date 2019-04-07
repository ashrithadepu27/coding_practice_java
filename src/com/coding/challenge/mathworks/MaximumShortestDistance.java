package com.coding.challenge.mathworks;

import java.util.*;
import javafx.util.Pair;

class MaximumShortestDistance {

   /*
     * Question: https://stackoverflow.com/questions/52562585/maximal-value-among-shortest-distances-in-a-matrix
     * Complete the 'findMinDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER w
     *  2. INTEGER h
     *  3. INTEGER n
     */

    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static int findMinDistance(int w, int h, int n) {
        int[][] grid = new int[w][h];
        for(int i = 0; i < w; i++)
            Arrays.fill(grid[i], -1);
        return findMinDistanceUtil(n, w, h, 0, 0, grid);
    }

    private static int findMinDistanceUtil(int l, int w, int h, int row, int col, int[][] grid) {
        if(l == 0)
            return bfs(w, h, grid);

        int r = row, c = col;

        if(col >= h) {
            r+= col / h;
            c= col % h;
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i = r; i < w; i++) {
            for(int j = c; j < h; j++ ) {
                grid[i][j] = 0;
                int val = findMinDistanceUtil(l-1,w, h, i, j+1, grid);
                minDistance = Math.min(val, minDistance);
                grid[i][j] = -1;
            }
        }

        return minDistance;
    }

    private static int bfs(int w, int h, int[][] grid) {

        int[][] dist = new int[w][h];

        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                dist[i][j] = grid[i][j];
            }
        }

        int maxDistance = 0;
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();

        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(dist[i][j] == 0) {
                    que.add(new Pair<>(i, j));
                }
            }
        }

        while(!que.isEmpty()) {
            int x = que.peek().getKey();
            int y = que.peek().getValue();

            maxDistance = Math.max(maxDistance, dist[x][y]);
            que.poll();

            for(int d = 0; d < 4; d++) {
                int newX = x + dx[d], newY = y + dy[d];
                if(newX >= w || newY >= h || newX< 0 || newY < 0) {
                    continue;
                }
                if(dist[newX][newY] == -1) {
                    dist[newX][newY] = dist[x][y] + 1;
                    que.add(new Pair<>(newX, newY));
                }

            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int dist = findMinDistance(2, 3, 2);
        System.out.println(dist);
    }
}
