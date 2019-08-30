package com.sagar.javacase.datastructure.graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

class GraphNodeBfs {

	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public GraphNodeBfs(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(int v, int u) {
		adj[v].add(u);
	}

	public void BFS(int s) {

		boolean visited[] = new boolean[V];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(s);
		visited[s] = true;

		while (queue.size() != 0) {
			int n = queue.poll();
			System.out.print(n + " ");
			ListIterator<Integer> list = adj[n].listIterator();
			while (list.hasNext()) {
				int i = list.next();
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
}

public class BreadthFirstSearch {

	public static void main(String[] args) {
		GraphNodeBfs g = new GraphNodeBfs(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 5);

		System.out.println("Following is a BFS " + "sort of the given graph");
		g.BFS(0);

	}

}
