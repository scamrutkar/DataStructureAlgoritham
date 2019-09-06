package com.sagar.javacase.datastructure.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DistanceNode {

	Node root;

	private List<Integer> distanceNode(Node startNode, int distance) {
		return distanceNodeUtil(root, 0, startNode, distance);
	}

	private List<Integer> distanceNodeUtil(Node rootNode, int count, Node startNode, int distance) {

		Map<Node, Node> nodeToParentNodeMap = new HashMap<>();
		getNodeToParentNodeMap(nodeToParentNodeMap, root, null);

		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode);

		Set<Node> seenSet = new HashSet<>();
		seenSet.add(startNode);

		int currentLevel = 0;
		while (!queue.isEmpty()) {

			if (currentLevel == distance) {
				return extractLayerFromQueue(queue);
			}

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node currentNode = queue.poll();

				if (currentNode.left != null && !seenSet.contains(currentNode.left)) {
					seenSet.add(currentNode.left);
					queue.offer(currentNode.left);
				}

				if (currentNode.right != null && !seenSet.contains(currentNode.right)) {
					seenSet.add(currentNode.right);
					queue.offer(currentNode.right);
				}

				Node parentNode = nodeToParentNodeMap.get(currentNode);
				if (parentNode != null && !seenSet.contains(parentNode)) {
					seenSet.add(parentNode);
					queue.offer(parentNode);
				}
				
			}

			currentLevel++;

		}

		return new ArrayList<Integer>();
	}

	private List<Integer> extractLayerFromQueue(Queue<Node> queue) {
		List<Integer> list = new ArrayList<>();
		for (Node node : queue) {
			list.add(node.val);
		}
		return list;
	}

	private void getNodeToParentNodeMap(Map<Node, Node> nodeToParentNodeMap, Node node, Node parent) {

		if (node == null)
			return;

		nodeToParentNodeMap.put(node, parent);
		getNodeToParentNodeMap(nodeToParentNodeMap, node.left, node);
		getNodeToParentNodeMap(nodeToParentNodeMap, node.right, node);
	}

	public static void main(String args[]) {
		DistanceNode tree = new DistanceNode();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.left.right.right = new Node(1);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(16);
		tree.root.right.right.right = new Node(20);
		List<Integer> list = tree.distanceNode(tree.root.left, 1);
		System.out.println(list);
	}

}
