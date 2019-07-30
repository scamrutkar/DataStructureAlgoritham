package com.sagar.javacase.datastructure.Tree;

public class MorrisPreorderTraversal {

	Node root;

	private void morrisPreorderTraversal() {
		
		Node pre;
		Node current = root;
		
		while(current != null) {
			if(current.left == null) {
				System.out.println(current.val);
				current = current.right;
			}else {
				pre = current.left;
				
				while(pre.right != null && pre.right != current)
					pre = pre.right;
				
				if(pre.right == null) {
					pre.right = current;
					System.out.println(current.val);
					current = current.left;
				}else {
					pre.right = null;
					current = current.right;
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		MorrisPreorderTraversal tree = new MorrisPreorderTraversal();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.morrisPreorderTraversal();

	}

}
