package com.sagar.javacase.datastructure.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "ACACG";
        String str2 = "AATCC";

        int m = str1.length();
        int n = str2.length();
        int lcs[][] = new int[m + 1][n + 1];

        int lcsLength = findLCSLenght(str1, str2, lcs, str1.length(), str2.length());

        List<String> lcsStrings = findLCS(str1, str2, lcs, str1.length(), str2.length());
        System.out.println("LCS Length : " + lcsLength);
        System.out.println("LCS Length : " + lcsStrings);

    }

    private static List<String> findLCS(String str1, String str2, int[][] lcs, int m, int n) {

        if (m == 0 || n == 0)
            return new ArrayList<>(Collections.nCopies(1, ""));

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            List<String> lcsStrings = findLCS(str1, str2, lcs, m - 1, n - 1);
            for (int i = 0; i < lcsStrings.size(); i++) {
                lcsStrings.set(i, lcsStrings.get(i) + (str1.charAt(m - 1)));
            }
            return lcsStrings;
        }

        if (lcs[m - 1][n] > lcs[m][n - 1])
            return findLCS(str1, str2, lcs, m - 1, n);
        if (lcs[m - 1][n] < lcs[m][n - 1])
            return findLCS(str1, str2, lcs, m, n - 1);

        List<String> top = findLCS(str1, str2, lcs, m - 1, n);
        List<String> left = findLCS(str1, str2, lcs, m, n - 1);

        top.addAll(left);
        return top;

    }

    private static int findLCSLenght(String str1, String str2, int[][] lcs, int m, int n) {

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                else
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
            }
        }
        return lcs[m][n];
    }
}
