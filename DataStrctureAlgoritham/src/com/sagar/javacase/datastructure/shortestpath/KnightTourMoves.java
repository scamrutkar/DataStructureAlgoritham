package com.sagar.javacase.datastructure.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class KnightNode {

	public int x;
	public int y;
	public int dist;

	public KnightNode(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public KnightNode(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dist, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof KnightNode)) {
			return false;
		}
		KnightNode node = (KnightNode) obj;
		return dist == node.dist && x == node.x && y == node.y;
	}

}

public class KnightTourMoves {

	static int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
	static int col[] = { 1, -1, 1, -1, 2, -2, 2, -2 };

	public static int BFS(KnightNode src, KnightNode dest, int N) {

		Queue<KnightNode> queue = new LinkedList<>();
		queue.add(src);
		List<KnightNode> visited = new ArrayList<>();

		while (!queue.isEmpty()) {
			
			KnightNode node = queue.poll();
			
			int x = node.x;
			int y = node.y;
			int dist = node.dist;

			if (x == dest.x && y == dest.y)
				return dist;

			if (!visited.contains(node)) {
				visited.add(node);
				for (int i = 0; i < N; i++) {
					int x1 = x + row[i];
					int y1 = y + col[i];
					if (isValid(x1, y1, N))
						queue.add(new KnightNode(x1, y1, dist + 1));
				}
			}

		}

		return Integer.MAX_VALUE;

	}

	private static boolean isValid(int x1, int y1, int N) {
		if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < N)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int N = 8;
		KnightNode src = new KnightNode(7, 1);
		KnightNode dest = new KnightNode(0, 7);
		System.out.println("Minimum number of moves required to reach source to destination - " + BFS(src, dest, N));
	}

}
