package com.graph.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphUtil {

	int P[] = null;

	public static void main(String[] args) {
		new GraphUtil();
	}

	public GraphUtil() {
		Graph G = new Graph(7);
		G.addEdge(0, 1);
		G.addEdge(0, 3);
		G.addEdge(1, 3);
		G.addEdge(1, 4);
		G.addEdge(2, 0);
		G.addEdge(2, 5);
		G.addEdge(3, 5);
		G.addEdge(3, 6);
		G.addEdge(4, 6);
		G.addEdge(6, 5);

		int D[] = shortestPath(G, 2);
		for (int i = 0; i < D.length; i++) {
			System.out.println(2 + " -> " + i + " :: " + D[i] + " " + printPath(2, i, P));
		}
		System.out.println();

		Graph G1 = new Graph(5);
		G1.addEdge(0, 1, 4);
		G1.addEdge(0, 2, 1);
		G1.addEdge(1, 4, 4);
		G1.addEdge(2, 1, 2);
		G1.addEdge(2, 3, 4);
		G1.addEdge(3, 4, 4);

		int[] D1 = dijkstra(G1, 0);
		for (int i = 0; i < D1.length; i++) {
			System.out.println(0 + " -> " + i + " :: " + D1[i]);
		}
		
		
		Graph G2 = new Graph(5);
		G2.addEdge(0, 1, -1);
		G2.addEdge(0, 2, 4);
		G2.addEdge(1, 2, 3);
		G2.addEdge(1, 4, 2);
		G2.addEdge(1, 3, 2);
		G2.addEdge(3, 1, 1);
		G2.addEdge(4, 3, -3);
		G2.addEdge(3, 2, 5);
		
		System.out.println("Bellman Ford---------------");
		int D2[] = bellmanford(G2, 0);
		for (int i = 0; i < D2.length; i++) {
			System.out.println(0 + " -> " + i + " :: " + D2[i]);
		}
	}

	public String printPath(int s, int e, int P[]) {
		StringBuilder path = new StringBuilder();
		path.append("->");
		path.append(e);

		int cur = P[e];
		while (cur != s) {

			path.insert(0, +cur);
			path.insert(0, "->");
			cur = P[cur];
		}
		path.insert(0, s);
		return path.toString();
	}

	public int[] shortestPath(Graph G, int s) {

		int P[] = new int[G.vertices];
		int D[] = new int[G.vertices];
		for (int i = 0; i < G.vertices; i++) {
			D[i] = -1;
		}
		D[s] = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(s);
		P[s] = s;
		while (!Q.isEmpty()) {
			int cur = Q.poll();

			List<Integer> neighbours = getUnvisitedNeighbour(G, cur, D);

			if (!neighbours.isEmpty()) {
				for (int n : neighbours) {
					D[n] = D[cur] + 1;
					Q.add(n);
					P[n] = cur;
				}
			}
		}
		this.P = P;
		return D;
	}

	private List<Integer> getUnvisitedNeighbour(Graph G, int s, int[] D) {

		ArrayList<Integer> R = new ArrayList<>();
		for (int i = 0; i < G.vertices; i++) {
			if (G.A[s][i] == 1 && D[i] == -1) {
				R.add(i);
			}
		}
		return R;
	}

	private List<Integer> getUnvisitedNeighbour2(Graph G, int s, int[] D) {

		ArrayList<Integer> R = new ArrayList<>();
		for (int i = 0; i < G.vertices; i++) {
			if (G.A[s][i] >= 1) {
				R.add(i);
			}
		}
		return R;
	}

	public int[] dijkstra(Graph G, int s) {

		int D[] = new int[G.vertices];
		PriorityQueue<Node> PQ = new PriorityQueue<>();

		Arrays.fill(D, -1);
		D[s] = 0;

		PQ.add(new Node(s, 0));

		while (!PQ.isEmpty()) {
			Node node = PQ.poll();

			List<Integer> neighbours = getUnvisitedNeighbour2(G, node.v, D);
			int cur = node.v;
			for (int n : neighbours) {

				System.out.println(cur + " " + n + " " + G.A[cur][n]);
				int d = D[cur] + G.A[cur][n];
				System.out.println(d);
				if (D[n] == -1) {
					D[n] = d;
					PQ.add(new Node(n, d));
				} else if (D[n] > d) {
					System.out.println("size: " + PQ.size());

					PQ.remove(new Node(n, d));
					D[n] = d;
					PQ.add(new Node(n, D[n]));

					System.out.println("size: " + PQ.size());
				}
			}
		}
		return D;
	}

	class Node implements Comparable<Node> {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;

		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public boolean equals(Object obj) {

			if (obj instanceof Node) {
				Node n = (Node) obj;
				if (n.v == this.v && n.w == this.w)
					return true;
			}
			return false;
		}

		@Override
		public int compareTo(Node o) {
			return new Integer(this.w).compareTo(o.w);
		}
	}

	// Bellman ford
	class Edge {
		int s;
		int d;
		int w;

		Edge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}

	public int[] bellmanford(Graph G, int s) {
		int D[] = new int[G.vertices];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[s]=0;
		int V = G.vertices;

		// prepare Edges
		ArrayList<Edge> E = getEdges(G);
		System.out.println(E.size());
		for (int i = 1; i < V; i++) {
			
			for (int j = 0; j < E.size(); j++) {
				int u = E.get(j).s;
				int v = E.get(j).d;
				int w = E.get(j).w;

				System.out.println(u+" -> "+v+" "+w);
				
				if (D[u] != Integer.MAX_VALUE && D[v] > D[u] + w) {
					System.out.println(D[u]);
					D[v] = D[u] + w;
				}
			}
		}
		return D;
	}

	private ArrayList<Edge> getEdges(Graph g) {
		ArrayList<Edge> E = new ArrayList<Edge>();

		for (int i = 0; i < g.vertices; i++) {
			for (int j = 0; j < g.vertices; j++) {
				if (g.A[i][j] != 0)
					E.add(new Edge(i, j, g.A[i][j]));
			}
		}
		return E;
	}
}
