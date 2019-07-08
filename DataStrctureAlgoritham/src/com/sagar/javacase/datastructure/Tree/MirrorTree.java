package com.sagar.javacase.datastructure.Tree;

public class MirrorTree {
	
	public Node mirror(Node root) {
		
		if(root == null)
			return root;
		
		if(root.left != null)
			root.left = mirror(root.right);
		if(root.right != null)
			root.right = mirror(root.left);
		
		return root;
		
		
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
		
		MirrorTree mt = new MirrorTree();
		
		Node root = mt.mirror(op.root);
		
		op.inorder(root);
		
	}

}
