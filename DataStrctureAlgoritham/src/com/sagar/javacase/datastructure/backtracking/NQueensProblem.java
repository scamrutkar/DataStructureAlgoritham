package com.sagar.javacase.datastructure.backtracking;

public class NQueensProblem {

	private static int N = 8;
	private static int k = 1;

	public static void main(String[] args) {
		solveNQ(N);
	}

	private static void solveNQ(int N) {
		int board[][] = new int[N][N];
		if (solveNQUtil(board, 0) == false)
			System.out.println("Path doesn't exists");
		return;
	}

	private static boolean solveNQUtil(int[][] board, int col) {

		if (col == N) {
			printSolution(board);
			return true;
		}

		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col) == true) {
				board[i][col] = 1;
				solveNQUtil(board, col + 1);
				board[i][col] = 0;
			}
		}

		return true;
	}

	private static boolean isSafe(int[][] board, int row, int col) {

		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (int i = row, j = col; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	static void printSolution(int board[][]) {
		System.out.printf("%d-\n", k++);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.printf(" %d ", board[i][j]);
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}

}
