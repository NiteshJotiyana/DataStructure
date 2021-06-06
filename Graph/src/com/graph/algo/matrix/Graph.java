package com.graph.algo.matrix;

public class Graph {

	private int A[][];
	private int v;

	public Graph(int v) {
		this.v = v;

		A = new int[v][v];
		// initialize
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				A[i][j] = 0;
			}
		}
	}

	// O(1) - O(1)
	public void addEdge(int s, int e) throws Exception {

		if (s < 0 || s >= v)
			throw new Exception("Invalid start vertex");

		if (e < 0 || e >= v)
			throw new Exception("Invalid end vertex");

		A[s][e] = 1;
		A[e][s] = 1;

	}

	// O(v+n)^2 - O(v+n)^2
	public void addVertex(int n) throws Exception {

		if (Integer.MAX_VALUE - v < n) {
			throw new Exception("Max limit of Integer. Can not be added " + n + " vertex.");
		}

		int u = v + n;
		int T[][] = new int[u][u];

		for (int i = 0; i < u; i++) {
			for (int j = 0; j < u; j++) {
				T[i][j] = A[i][j];
			}
		}

		A = T;
		this.v = u;
	}

	public void removeEdge(int s, int e) throws Exception {

		if (s < 0 || s >= v)
			throw new Exception("Invalid start vertex");

		if (e < 0 || e >= v)
			throw new Exception("Invalid end vertex");

		if (A[s][e] == 1) {
			A[s][e] = 0;
			A[e][s] = 0;
		} else {
			throw new Exception("Invalid edge:  No edge present : " + s + "->" + e);
		}

	}

	// remove vertex number n
	public void removeVertex(int s) throws Exception {

		if (s < 0 || s >= v) {
			throw new Exception("Invalid vertex number");
		}

		int u = v - 1;
		int T[][] = new int[u][u];

		int x = 0;
		int y = 0;
		for (int i = 0; i < v; i++) {

			if (i == s)
				System.out.println(i + "==" + s);

			if (i != s) {

				y = 0;
				for (int j = 0; j < v; j++) {

					if (j == s)
						System.out.println(j + "==" + s);
					if (j != s) {
						T[x][y] = A[i][j];
						y++;
					}
				}
				x++;
			}
		}

		A = T;
		this.v = u;
	}

	public static void main(String[] args) {

		Graph G = new Graph(5);
		try {
			G.addEdge(0, 1);
			G.addEdge(0, 4);
			G.addEdge(1, 2);
			G.addEdge(1, 3);
			G.addEdge(2, 3);

			G.removeEdge(0, 4);

			G.removeVertex(1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
