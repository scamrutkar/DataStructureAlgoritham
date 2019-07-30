package com.sagar.javacase.datastructure.Tree;

public class MorrisPostorderTraversal {

	Node root;

	private void morrisPostorderTraversal() {

		Node pre;
		Node current = root;
		while (current != null) {

			if (current.right == null) {
				System.out.println(current.val);
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
					System.out.println(current.val);
					current = current.left;
				}

			}

		}

	}

	public static void main(String[] args) {

		MorrisPostorderTraversal tree = new MorrisPostorderTraversal();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.morrisPostorderTraversal();

	}

}
