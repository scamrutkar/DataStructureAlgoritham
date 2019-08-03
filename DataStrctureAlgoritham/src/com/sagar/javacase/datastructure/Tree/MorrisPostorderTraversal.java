package com.sagar.javacase.datastructure.Tree;

public class MorrisPostorderTraversal {

	Node root;

	void reverse(Node from, Node to) // reverse the tree nodes 'from' 'to'.
	{
		if (from == to)
			return;
		Node x = from, y = from.right, z;
		while (true) {
			z = y.right;
			y.right = x;
			x = y;
			y = z;
			if (x == to)
				break;
		}
	}

	void printReverse(Node from, Node to) // print the reversed tree nodes 'from' -> 'to'.
	{
		reverse(from, to);

		Node p = to;
		while (true) {
			System.out.print(p.val+" ");
			if (p == from)
				break;
			p = p.right;
		}

		reverse(to, from);
	}

	void morrisPostorderTraversal() {
		
		Node dump = new Node(100);
		dump.left = root;
		Node current = dump, prev;
		
		while (current != null) {
			if (current.left == null) {
				current = current.right;
			} else {
				prev = current.left;
				while (prev.right != null && prev.right != current)
					prev = prev.right;

				if (prev.right == null) {
					prev.right = current;
					current = current.left;
				} else {
					printReverse(current.left, prev); // call print
					prev.right = null;
					current = current.right;
				}
			}
		}
		
	}


	public static void main(String[] args) {

		MorrisPostorderTraversal tree = new MorrisPostorderTraversal();
		
		
		tree.root = new Node(1);
		tree.root.right= new Node(2);
		tree.root.right.right = new Node(5);
		tree.root.right.left = new Node(3);
		tree.root.right.left.right = new Node(4);
		tree.root.right.right.right = new Node(6);
		tree.morrisPostorderTraversal();

	}

}
