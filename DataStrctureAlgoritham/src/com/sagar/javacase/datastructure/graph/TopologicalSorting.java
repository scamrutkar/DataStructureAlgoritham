package com.sagar.javacase.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph {

	int v;
	List<Integer> adjacentList[];

	public Graph(int v) {
		this.v = v;
		for (int i = 0; i < v; i++) {
			adjacentList[i] = new ArrayList<>();
		}
	}
	
	public void add(int v, int u) {
		adjacentList[v].add(u);
	}
	
	public void topologicalSorting() {
		
		boolean visited[] = new boolean[v];
		
		
	}
	
	private void topologicalSortingUtil(int v, boolean visited[], Stack<Integer> stack) {
		
	}

}

public class TopologicalSorting {

	public static void main(String[] args) {
		
		

	}

}
