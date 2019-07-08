package com.sagar.javacase.datastructure.graph;

import java.util.LinkedList;
import java.util.ListIterator;

class GraphNode {

	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public GraphNode(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(int v, int u) {
		adj[v].add(u);
	}

	public void DFS(int v) {

		boolean[] visited = new boolean[V];
		DFSUtil(v, visited);

	}

	public void DFSUtil(int v, boolean visited[]) {

		visited[v] = true;
		System.out.print(v + " ");
		ListIterator<Integer> list = adj[v].listIterator();
		while (list.hasNext()) {
			int n = list.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}

	}
}

public class DepthFirstSearch {

	public static void main(String[] args) {
		GraphNode g = new GraphNode(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);

	}

}
