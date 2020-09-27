package com.sagar.javacase.datastructure.dp;

import java.util.Arrays;
import java.util.LinkedList;

public class RodCuttingProblem {

    public static void main(String[] args) {

        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        rodCut(arr, 5);
    }

    public static void rodCut(int[] price, int n) {
        int[] temp = new int[n + 1];
        int[] address = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Integer maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int tempVal = price[j] + temp[i - j - 1];
                if (tempVal > temp[i]) {
                    temp[i] = tempVal;
                    address[i] = j+1;
                }
            }
            System.out.println("i=" + i + " " + Arrays.toString(address));
        }
        System.out.println("Maximum Obtainable Value is :" + temp[n]);
        LinkedList<Integer> list = new LinkedList<>();
        while (n > 0) {
            list.add(address[n]);
            n = n - address[n];
        }
        System.out.println(list);
    }
}
