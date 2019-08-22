package com.sagar.javacase.datastructure.Tree;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class VerticalDistance {
	
	Node root;
	TreeMap<Integer,LinkedList<Integer>> map = new TreeMap<>();
	
	private void verticalDistance() {
		int hd = 0;
		verticalDistanceUtil(root, hd, map);
		printVerticalDistance(map);
	}
	
	private void printVerticalDistance(TreeMap<Integer, LinkedList<Integer>> map) {
		
		Set<Integer>  set = map.keySet();
		for(Integer data : set) {
			System.out.print(data +" ");
			System.out.print(map.get(data)+"\n");
		}
		
	}

	private void verticalDistanceUtil(Node root, int hd, TreeMap<Integer, LinkedList<Integer>> map) {
		
		if(map.get(hd) == null) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(root.val);
			map.put(hd, list);
		}else {
			LinkedList<Integer> list = map.get(hd);
			list.add(root.val);
			map.put(hd, list);
		}
		
		if(root.left != null) {
			verticalDistanceUtil(root.left, hd-1, map);
		}
		
		if(root.right!=null) {
			verticalDistanceUtil(root.right, hd+1, map);
		}
	}

	public static void main(String[] args) {
		VerticalDistance tree = new VerticalDistance();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.verticalDistance();
	}

	

}
