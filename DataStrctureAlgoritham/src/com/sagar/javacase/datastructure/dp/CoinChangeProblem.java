package com.sagar.javacase.datastructure.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeProblem {

    public static void main(String[] args) {
        long Coins[] = {1, 2, 5};

        System.out.println("The Coins Array:");
        System.out.println(Arrays.toString(Coins));

        System.out.println("Solution:");
        System.out.println(getNumberOfWays(8, Coins));
        printNumberOfWaysSolution(8, Coins);
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

    private static List<List<Integer>> printNumberOfWaysSolution(int total, long[] coins) {
        List<List<Integer>> list = new ArrayList<>();
        printNumberOfWaysSolutionUtil(list, new ArrayList<Integer>(), total, coins,0);
        return list;
    }

    private static void printNumberOfWaysSolutionUtil(List<List<Integer>> list, List<Integer> result, long total, long[] coins, int start) {
        if (total == 0) {
            System.out.println("Combination: "+result);
            list.add(new ArrayList<>(result));
            return;
        }

        if (total < 0)
            return;

        for ( int i = start; i < coins.length; i++) {
            if (coins[i] <= total) {
                result.add((int) coins[i]);
                printNumberOfWaysSolutionUtil(list, result, total - coins[i], coins, i);
                result.remove(result.size() - 1);
            }
        }
    }
}
