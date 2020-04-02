package com.sagar.javacase.datastructure.dp;

public class CountWaysToReachStairs {

	public static int countWaysUtil(int n, int m) {
		int res[] = new int[n];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			for (int j = 1; j <= m && j <= i; j++) {
				res[i] += res[i - j];
			}
		}
		return res[n - 1];
	}

	public static int countWays(int s, int m) {
		return countWaysUtil(s + 1, m);
	}

	public static void main(String[] args) {
		int s = 4, m = 3;
		System.out.println("No of Ways: " + countWays(s, m));
		convetIntToBinary(9);
	}

	public static void convetIntToBinary(int n) {
		int count = 0, a;
		StringBuilder builder = new StringBuilder();
		while (n > 0) {
			a = n % 2;
			if (a == 1) 
				count++;
			builder.insert(0, a);
			n = n / 2;
		}
		System.out.println("Binary number:" + builder.toString());
		System.out.println("No. of 1s:" + count);
	}

}
