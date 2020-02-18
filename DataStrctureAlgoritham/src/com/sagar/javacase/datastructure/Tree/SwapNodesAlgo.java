package com.sagar.javacase.datastructure.Tree;

import java.io.*;
import java.util.*;

public class SwapNodesAlgo {

	/*
	 * Complete the swapNodes function below.
	 */

	static class Node {
		int index;
		int depth;
		Node left;
		Node right;

		public Node(int index, int depth, Node left, Node right) {
			this.index = index;
			this.depth = depth;
			this.left = left;
			this.right = right;
		}

	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {

		int numberOfNodes = indexes.length;
		int numberOfQuries = queries.length;

		Node root = new Node(1, 1, null, null);
		Node curr = root;

		Queue<Node> nodes = new LinkedList<Node>();
		nodes.offer(curr);

		int N = 0;
		while (N < numberOfNodes) {
			curr = nodes.poll();
			int leftData = indexes[N][0];
			int rightData = indexes[N][1];

			curr.left = (leftData == -1) ? null : new Node(leftData, curr.depth + 1, null, null);
			curr.right = (rightData == -1) ? null : new Node(rightData, curr.depth + 1, null, null);

			if (curr.left != null && curr.left.index != -1)
				nodes.offer(curr.left);
			if (curr.right != null && curr.right.index != -1)
				nodes.offer(curr.right);
			N++;
		}

		int[][] result = new int[numberOfQuries][numberOfNodes];

		for (int i = 0; i < numberOfQuries; i++) {
			swapInOrder(root, 1, queries[i]);
			List<Integer> res = new ArrayList<>();
			printInOrder(root, res);
			result[i] = res.stream().mapToInt(r -> r).toArray();
		}

		return result;

	}

	private static void printInOrder(Node curr, List<Integer> res) {
		if (curr == null)
			return;

		printInOrder(curr.left, res);
		res.add(curr.index);
		printInOrder(curr.right, res);
	}

	private static void swapInOrder(Node curr, int depth, int k) {
		if (curr == null)
			return;

		swapInOrder(curr.left, depth + 1, k);
		swapInOrder(curr.right, depth + 1, k);

		if (depth >= k && depth % k == 0) {
			Node tmp = curr.left;
			curr.left = curr.right;
			curr.right = tmp;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int n = Integer.parseInt(scanner.nextLine().trim());
		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");
			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());
		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
				bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
				if (resultColumnItr != result[resultRowItr].length - 1) {
					bufferedWriter.write(" ");
				}
			}
			if (resultRowItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();
		bufferedWriter.close();
	}
}
