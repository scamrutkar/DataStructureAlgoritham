package com.sagar.javacase.datastructure.dp;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        int n = 15;
        int[] result = new int[n + 1];
        result[0] = 0;
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i)
                offset *= 2;
            result[i] = result[i - offset] + 1;
        }
        System.out.println(Arrays.toString(result));
    }
}
