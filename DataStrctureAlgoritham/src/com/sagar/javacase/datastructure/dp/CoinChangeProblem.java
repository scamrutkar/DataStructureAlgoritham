package com.sagar.javacase.datastructure.dp;

import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {
        long Coins[] = {1, 2, 5};

        System.out.println("The Coins Array:");
        System.out.println(Arrays.toString(Coins));

        System.out.println("Solution:");
        System.out.println(getNumberOfWays(8, Coins));
    }

    private static int getNumberOfWays(int n, long[] coins) {
        int[] table = new int[n + 1];
        table[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (coins[i] <= j) {
                    table[j] = table[j] + table[(int) (j - coins[i])];
                }
            }
        }
        return table[n];
    }
}
