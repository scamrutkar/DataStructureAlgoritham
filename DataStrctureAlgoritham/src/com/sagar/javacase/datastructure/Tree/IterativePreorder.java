package com.sagar.javacase.datastructure.Tree;

import java.util.Stack;

public class IterativePreorder {

	Node root;

	public void iterativePreorder() {
		iterativePreorder(root);
	}

	private void iterativePreorder(Node root) {

		Stack<Node> stack = new Stack<>();
		Node current = root;
		stack.push(root);

		while (current != null && stack.size() > 0) {

			current = stack.pop();
			System.out.print(current.val + " ");

			if (current.right != null)
				stack.push(current.right);
			if (current.left != null)
				stack.push(current.left);

		}

	}

	public static void main(String[] args) {
		IterativePreorder tree = new IterativePreorder();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.iterativePreorder();
	}

}
