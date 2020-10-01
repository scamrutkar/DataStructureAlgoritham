package com.sagar.javacase.datastructure.dp;

public class MaxContigousSumSubArray {

    public static void main(String[] args) {
        int[] a = {-1};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] a) {
        int maxGlobal = a[0];
        int maxCurrent = 0;
        for (int i = 0; i < a.length; i++) {
            maxCurrent = Math.max(maxCurrent + a[i], a[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }
}
