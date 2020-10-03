package com.sagar.javacase.datastructure.dp;

import java.util.Arrays;

public class MinimumCostPath {

    public static void main(String args[]) {

        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.print(minCostDP(cost, 3, 3));
    }

    private static int minCost(int[][] cost, int i, int j) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return cost[0][0];
        cost[i][j] = cost[i][j] + Math.min(minCost(cost, i - 1, j),
                minCost(cost, i, j - 1));
        return cost[i][j];
    }

    private static int minCostDP(int[][] grid, int m, int n) {
        int[][] cost = new int[m][n];
        cost = grid;
        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < n; j++)
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        int p = 2, q = 2;
        while (p >= 0 && q >= 0) {
            System.out.print(cost[p][q] + "->");
            int nP = -1, nQ = -1;
            int min = Integer.MAX_VALUE;
            if (p - 1 >= 0 && grid[p - 1][q] < min) {
                min = grid[p - 1][q];
                nP = p - 1;
                nQ = q;
            }

            if (q - 1 >= 0 && grid[p][q - 1] < min) {
                min = grid[p][q - 1];
                nP = p;
                nQ = q - 1;
            }
            p = nP;
            q = nQ;
        }
        System.out.println("");
        return grid[m - 1][n - 1];
    }
}
