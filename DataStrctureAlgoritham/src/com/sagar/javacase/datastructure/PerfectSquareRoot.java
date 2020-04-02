package com.sagar.javacase.datastructure;

public class PerfectSquareRoot {

	public static void main(String[] args) {

		int number = 2400;
		boolean isSquareRoot = isNumberPerfectSquareRoot(number);
		if (isSquareRoot)
			System.out.println("Given number " + number + " is perfect square root");
		else
			System.out.println("Given number " + number + " is not perfect square root");

	}

	private static boolean isNumberPerfectSquareRoot(int number) {

		if (number == 0 || number == 1)
			return true;

		int start = 1, end = number;
		int itr = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (mid * mid == number) {
				System.out.println("Iteration " + itr);
				return true;
			}

			if (mid * mid < number)
				start = mid + 1;
			else
				end = mid - 1;

			itr++;
		}
		System.out.println("Iteration " + itr);
		return false;
	}

}
