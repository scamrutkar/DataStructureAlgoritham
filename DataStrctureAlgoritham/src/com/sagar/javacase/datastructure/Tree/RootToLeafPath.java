package com.sagar.javacase.datastructure.Tree;

public class RootToLeafPath {

	Node root;

	public void printRootToLeafPath() {
		int[] arr = new int[1000];
		int pathlen = 0;
		printRootToLeafPathUtil(root, arr, pathlen);
	}

	/*
	 * Using Recursion - check till root->left and root->right are not null if both
	 * are null then print path else recursively iterate
	 */
	private void printRootToLeafPathUtil(Node root, int[] arr, int pathlen) {
		if (root == null) {
			return;
		}
		arr[pathlen++] = root.val;
		if (root.right == null && root.left == null)
			printTreePath(arr, pathlen);
		else {
			printRootToLeafPathUtil(root.left, arr, pathlen);
			printRootToLeafPathUtil(root.right, arr, pathlen);
		}
	}

	private void printTreePath(int[] arr, int pathlen) {
		for (int i = 0; i < pathlen; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		RootToLeafPath tree = new RootToLeafPath();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.left.right.right = new Node(1);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.root.right.right.right = new Node(20);
		tree.printRootToLeafPath();
	}

}
