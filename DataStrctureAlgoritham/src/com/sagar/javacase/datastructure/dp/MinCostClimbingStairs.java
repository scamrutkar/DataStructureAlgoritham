package com.sagar.javacase.datastructure.dp;

public class MinCostClimbingStairs {

    static int[] dp;

    public static void main(String[] args){
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost,cost.length));
        System.out.println(minCostClimbingStairsDp(cost,cost.length));
        System.out.println(minCostClimbingStairsDpConstantSpace(cost,cost.length));
    }

    public static int minCostClimbingStairs(int[] cost, int n) {
        if(n==0) return 0;
        dp = new int[n];
        return Math.min(minCost(cost,n-1),minCost(cost,n-2));
    }

    public static int minCostClimbingStairsDp(int[] cost, int n) {
        int[] table = new int[n+1];
        table[0] = cost[0];
        table[1] = cost[1];
        for(int i=2;i<n;i++){
            table[i] = Math.min(table[i-1],table[i-2]) + cost[i];
        }
        return table[n-1];
    }

    public static int minCostClimbingStairsDpConstantSpace(int[] cost, int n) {
        int first = 0;
        int second = 0;
        for(int i=0;i<n;i++){
            int current = Math.min(first,second) + cost[i];
            second = first;
            first = current;
        }
        return Math.min(first,second);
    }

    private static int minCost(int[] cost, int n) {
        if(n < 0) return 0;
        if(n==0 || n==1) return cost[n];
        if(dp[n] != 0)
            return dp[n];
        dp[n] = cost[n] + Math.min(minCost(cost,n-1),minCost(cost,n-2));
        return dp[n];
    }
}
