package com.graph.algo.adjency;

import java.util.HashMap;

/**
 * 
 * @author nitesh
 *
 *         Graph with HashMap
 */
public class Graph<K, W> {

	private int v = 0;
	private HashMap<K, HashMap<K, W>> H;

	public Graph() {
		H = new HashMap<K, HashMap<K, W>>();
	}

	public void addEdge(K s, K e, W w) {

		if (!H.containsKey(s)) {
			HashMap<K, W> t = new HashMap();
			t.put(e, w);
			H.put(s, t);
			v++;
		} else {
			H.get(s).put(e, w);
		}
	}

	public W getWeight(K s, K e) {

		if (H.containsKey(s) && H.get(s).containsKey(e)) {
			return H.get(s).get(e);
		}
		return null;
	}

	public static void main(String[] args) {
		Graph<Integer, Integer> G = new Graph<Integer, Integer>();

		G.addEdge(0, 1, 7);
		G.addEdge(0, 2, 5);
		G.addEdge(1, 3, 6);
		G.addEdge(2, 3, 8);
		G.addEdge(0, 3, 4);

		G.printGraph();
	}

	public void printGraph() {

		for (K k : H.keySet()) {
			for (K m : H.get(k).keySet()) {

				System.out.println(k + " : is connected to " + m + " :  weight=" + H.get(k).get(m));
			}
		}
	}

}
