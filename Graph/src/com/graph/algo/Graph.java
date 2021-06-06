package com.graph.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	int A[][];
	int vertices;
	int edges;

	public Graph(int vertices) {
		this.vertices = vertices;
		A = new int[vertices][vertices];
	}

	public void addEdge(int s, int e) {
		A[s][e] = 1;
		// A[e][s] = 1;
	}

	public void addEdge(int s, int e, int w) {
		A[s][e] = w;
		// A[e][s] = 1;
	}

	public void removeEdge(int s, int e) {
		A[s][e] = 0;
		// A[e][s] = 0;
	}

	public static void main(String[] args) {
		Graph g = new Graph(8);
		/*
		 * g.addEdge(0, 1); g.addEdge(1, 2); g.addEdge(1, 3); g.addEdge(2, 4);
		 * g.addEdge(3, 4); g.addEdge(3, 6); g.addEdge(4, 5); g.addEdge(4, 7);
		 * 
		 * g.bfs(0); System.out.println(); g.dfs(0);
		 */
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(6, 1);
		g.addEdge(7, 5);
		g.addEdge(7, 4);

		g.topologicalSort();

	}

	public void bfs(int s) {

		Queue<Integer> Q = new LinkedList<>();
		boolean visited[] = new boolean[this.vertices];
		Arrays.fill(visited, false);
		Q.add(s);
		visited[s] = true;
		while (!Q.isEmpty()) {

			Integer cur = Q.poll();
			System.out.print(cur + " ");
			if (cur != null) {
				List<Integer> neighbours = getUnvisitedNeighbours(cur, visited);
				Q.addAll(neighbours);
			}
		}

	}

	private List<Integer> getUnvisitedNeighbours(int s, boolean visited[]) {
		ArrayList<Integer> r = new ArrayList<>();

		for (int i = s; i < this.vertices; i++) {
			// System.out.println(s+" "+i+" "+A[s][i]);
			if (A[s][i] == 1 && visited[i] == false) {
				r.add(i);
				visited[i] = true;
			}
		}
		return r;
	}

	public void dfs(int s) {
		// push cur in Stack
		// mark visited true
		// print cur
		// getNextUnvisitedNeighbour
		// add into the stack

		Stack<Integer> S = new Stack();
		boolean visited[] = new boolean[this.vertices];

		S.push(s);
		visited[s] = true;
		

		while (!S.isEmpty()) {

			int cur = S.peek();
			System.out.print(s + " ");
			Integer next = getUnvistedNeighbour(cur, visited);
			if (next != null) {
				S.push(next);
				visited[next] = true;
				//System.out.print(next + " ");
			} else {
				S.pop();
			}
		}

	}

	private Integer getUnvistedNeighbour(int cur, boolean visited[]) {

		for (int i = 0; i < this.vertices; i++) {
			if (A[cur][i] == 1 && visited[i] == false) {
				return i;
			}
		}
		return null;
	}

	public void topologicalSort() {

		// Stack
		Stack<Integer> S = new Stack<>();
		boolean V[] = new boolean[this.vertices];

		for (int i = 0; i < this.vertices; i++) {
			if (!V[i]) {
				topologicalSortUtil(i, S, V);
			}
		}

		while (!S.isEmpty()) {
			System.out.print(S.pop() + " ");
		}

	}

	private void topologicalSortUtil(int cur, Stack<Integer> S, boolean[] V) {

		while (true) {
			Integer next = getUnvisitedNeighbour(cur, V);
			if (next == null) {
				S.push(cur);
				V[cur] = true;
				return;
			}
			topologicalSortUtil(next, S, V);
		}
	}

	private Integer getUnvisitedNeighbour(int cur, boolean[] V) {

		for (int i = 0; i < this.vertices; i++) {
			if (A[cur][i] == 1 && !V[i]) {
				return i;
			}
		}
		return null;
	}
}
