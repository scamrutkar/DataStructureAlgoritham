package com.sagar.javacase.datastructure.dp;

public class HouseRobberProblem {

    public static void main(String[] args) {
        int[] nums = {1,4,3,7};
        System.out.println("Maximum robbery value: " + robDp(nums, nums.length));
    }

    private static int rob(int[] nums, int n) {
        if (n == 0) return 0;
        return maxRob(nums, n - 1);
    }

    private static int maxRob(int[] nums, int n) {
        if (n < 0) return 0;
        return Math.max(maxRob(nums, n - 1), maxRob(nums, n - 2) + nums[n]);
    }

    private static int robDp(int[] nums, int n) {
        int[] table = new int[n+1];
        table[0] = nums[0];
        table[1] = nums[1];
        for(int i =2 ;i<n;i++){
            table[i] = Math.max(table[i-2]+nums[i],table[i-1]);
        }
        return table[n-1];
    }

}
