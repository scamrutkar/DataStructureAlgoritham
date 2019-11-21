package com.sagar.javacase.datastructure.Tree;

public class KthMinInBST {

	Node root;

	private static class Count {
		int count = 0;
	}

	private void kthMinBSTrecursive(int k) {
		Count c = new Count();
		KthMinBSTrecursiveUtil(root, k, c);
	}

	private void KthMinBSTrecursiveUtil(Node node, int k, Count c) {

		if (node == null)
			return;

		KthMinBSTrecursiveUtil(node.left, k, c);
		c.count++;
		if (c.count == k)
			System.out.println(node.val);
		KthMinBSTrecursiveUtil(node.right, k, c);
	}

	public static void main(String[] args) {

		KthMinInBST tree = new KthMinInBST();
		tree.root = new Node(6);
		tree.root.right = new Node(10);
		tree.root.right.right = new Node(12);
		tree.root.right.left = new Node(8);
		tree.root.right.left.right = new Node(9);
		tree.root.right.right.right = new Node(14);

		tree.kthMinBSTrecursive(3);

	}

}
