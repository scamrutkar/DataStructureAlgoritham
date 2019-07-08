package com.sagar.javacase.datastructure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

class Graph {

	int v;
	List<Integer> adjacentList[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		adjacentList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjacentList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int u) {
		adjacentList[v].add(u);
	}

	public void topologicalSort() {

		boolean visited[] = new boolean[v];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < v; i++) {
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");

	}

	private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {

		visited[v] = true;

		ListIterator<Integer> list = adjacentList[v].listIterator();

		while (list.hasNext()) {
			int n = list.next();
			if (!visited[n]) {
				topologicalSortUtil(n, visited, stack);
			}
		}

		stack.push(v);

	}

}

public class TopologicalSorting {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}

}
