package com.sagar.javacase.datastructure.Tree;

import java.util.Stack;

public class IterativePostorder {

	Node root;

	public void iterativePostorder() {
		iterativePostorder(root);
	}

	private void iterativePostorder(Node root) {

		Stack<Node> stack = new Stack<>();
		
		while(true) {
			while(root != null) {
				stack.push(root);
				stack.push(root);
				root = root.left;
			}
			
			if(stack.isEmpty()) return;
			root = stack.pop();
			
			if(!stack.isEmpty() && (stack.peek() == root))
				root = root.right;
			else {
				System.out.print(root.val+" ");
				root = null;
			}
		}
		
	}

	public static void main(String[] args) {
		IterativePostorder tree = new IterativePostorder();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.iterativePostorder();
	}

}



