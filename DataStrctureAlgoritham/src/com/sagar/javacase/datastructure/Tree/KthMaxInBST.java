package com.sagar.javacase.datastructure.Tree;

public class KthMaxInBST {

	Node root;

	private static class Count {
		int count = 0;
	}

	private void kthMaxBSTrecursiveUtil(Node node, int k, Count c) {

		if (node == null)
			return;

		kthMaxBSTrecursiveUtil(node.right, k, c);
		c.count++;
		if (k == c.count) {
			System.out.println(String.format("%s Max Element %s", k, node.val));
			return;
		}

		kthMaxBSTrecursiveUtil(node.left, k, c);

	}

	private void kthMaxBSTrecursive(int k) {
		Count c = new Count();
		kthMaxBSTrecursiveUtil(root, k, c);
	}
	
	private void kthMaxBST(int k) {

		Node pre;
		Node current = root;
		int count = 0;

		while (current != null) {
			if (current.right == null) {
				if(++count == k)
					System.out.print(current.val+" ");
				current = current.left;
			} else {
				pre = current.right;

				while (pre.left != null && pre.left != current)
					pre = pre.left;

				if (pre.left == null) {
					pre.left = current;
					current = current.right;
				} else {
					pre.left = null;
					if(++count == k)
						System.out.print(current.val+" ");
					current = current.left;
				}
			}
		}

	}

	public static void main(String[] args) {

		KthMaxInBST tree = new KthMaxInBST();
		tree.root = new Node(6);
		tree.root.right = new Node(10);
		tree.root.right.right = new Node(12);
		tree.root.right.left = new Node(8);
		tree.root.right.left.right = new Node(9);
		tree.root.right.right.right = new Node(14);

		tree.kthMaxBSTrecursive(3);
		tree.kthMaxBST(3);

	}

}
