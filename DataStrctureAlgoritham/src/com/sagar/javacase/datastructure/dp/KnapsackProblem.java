package com.sagar.javacase.datastructure.dp;

import java.util.Arrays;

public class KnapsackProblem {

    public static void main(String[] args) {

        int[] v = {20, 5, 10, 40, 15, 25};
        int[] w = {1, 2, 3, 8, 7, 4};
        int W = 10;
        System.out.println("Knapsack value is " +
                knapSack(v, w, v.length, W));
    }

    public static int knapSack(int[] val, int[] wt, int n, int W) {
        //int wl = wt.length;
        int[][] lookup = new int[n + 1][W + 1];
        int[][] keep = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    lookup[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    if (val[i - 1] + lookup[i - 1][w - wt[i - 1]] > lookup[i - 1][w]) {
                        lookup[i][w] = val[i - 1] + lookup[i - 1][w - wt[i - 1]];
                        keep[i][w] = 1;
                    } else {
                        lookup[i][w] = lookup[i - 1][w];
                        keep[i][w] = 0;
                    }
                    //lookup[i][w] = Math.max(val[i-1] + lookup[i-1][w - wt[i-1]], lookup[i-1][w]);
                } else {
                    lookup[i][w] = lookup[i - 1][w];
                    keep[i][w] = 0;
                }
            }
            System.out.println("i:" + i + " " + Arrays.toString(lookup[i]));
        }
        int res = lookup[n][W];
        for (int i = n; i >= 1; i--) {
            if (lookup[i-1][W] == res) {
                continue;
            }else{
                System.out.print(wt[i-1]+" ");
                res = res - val[i-1];
                W = W - wt[i-1];
            }
        }
        return lookup[n][W];
    }
}
