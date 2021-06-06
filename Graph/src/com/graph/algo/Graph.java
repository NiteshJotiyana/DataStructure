package com.graph.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph {

	int V = 0;
	int A[][];

	public static void main(String[] args) {
		new Graph();
	}

	public Graph() {

	}

	public Graph(int size) {
		this.V = size;
		A = new int[this.V][this.V];
	}

	public void addEdge(int v, int w) {
		A[v][w] = 1;
		A[w][v] = 1;
	}

	public void removeEdge(int v, int w) {
		A[v][w] = 0;
		A[w][v] = 0;
	}

	public void dijkstra(int s) {
		PriorityQueue<Integer> PQ = new PriorityQueue<>();

		int D[] = new int[this.V];
		int P[] = new int[this.V];

		PQ.add(s);
		
		while(!PQ.isEmpty())
		{
			int v = PQ.re
		}
	}

	class DistanceComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return 0;
		}

	}
}
