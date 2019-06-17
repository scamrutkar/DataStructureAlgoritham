package org.sagar.javacase.datastructure.Tree;

public class Node {
	
	Node left;
	Node right;
	int val;
	
	public Node(int val) {
		super();
		this.left = null;
		this.right = null;
		this.val = val;
	}
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	

}
