package com.sagar.javacase.datastructure.Tree;

public class Operations {
	
	Node root;
	
	Operations(){
		root = null;
	}
	
	public void add(int val) {
		
		Node current = root;
		Node parent  = null;
		
		Node newNode = new Node(val);
		
		if(current == null) {
			root = newNode;
			return;
		}
		
		while(current!= null) {
			parent = current;
			if(current.val > val)
				current = current.left;
			else if (current.val < val)
				current = current.right;
		}
		if(parent.val > val )
			parent.left = newNode;
		else
			parent.right = newNode;
			
	}
	
	public void inorder (Node root) {
		if(root == null)
			return;
		
		System.out.println(root.val);
		inorder(root.left);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		
		Operations op = new Operations();
		
		op.add(10);
		op.add(8);
		op.add(12);
		op.add(9);
		op.add(7);
		op.add(11);
		op.add(13);
		
		op.inorder(op.root);
		
	}

}
