package com.sagar.javacase.datastructure.dp;

public class MaxContigousSumSubArray {

    public static void main(String[] args) {
        //int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] a = {-1,-2};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] a) {
        int maxGlobal = 0;
        int maxCurrent = 0;
        int bestStart = 0, bestEnd = 0;
        int currentStart = 0;
        for (int i = 0; i < a.length; i++) {
            if(maxCurrent <= 0){
                maxCurrent = a[i];
                currentStart = i;
            }else{
                maxCurrent += a[i];
            }

            if(maxCurrent > maxGlobal){
                maxGlobal = maxCurrent;
                bestStart = currentStart;
                bestEnd = i + 1;
            }
        }
        System.out.println("BeginI: "+bestStart+", EndI: "+bestEnd);
        return maxGlobal;
    }
}
