package com.sagar.javacase.datastructure.Tree;

import java.util.Stack;

//A binary tree node 
class InorderNode {

	int data;
	InorderNode left, right;

	InorderNode(int item) {
		data = item;
		left = right = null;
	}
}

public class IterativeInorder {

	InorderNode root;

	void iterativeInorder() {
		iterativeInorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	void iterativeInorder(InorderNode node) {

		// Base Case
		if (node == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<InorderNode> stack = new Stack<InorderNode>();

		InorderNode curr = node;
		while (curr != null || stack.size() > 0) {

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			System.out.print(curr.data + " ");

			curr = curr.right;

		}

	}

	// driver program to test above functions
	public static void main(String args[]) {
		IterativeInorder tree = new IterativeInorder();
		tree.root = new InorderNode(8);
		tree.root.left = new InorderNode(4);
		tree.root.right = new InorderNode(14);
		tree.root.left.left = new InorderNode(2);
		tree.root.left.right = new InorderNode(6);
		tree.root.right.left = new InorderNode(12);
		tree.root.right.right = new InorderNode(16);
		tree.iterativeInorder();

	}
}
