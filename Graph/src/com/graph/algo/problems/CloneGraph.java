package com.graph.algo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
	public static void main(String[] args) {
		new CloneGraph();
	}

	public CloneGraph() {
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		ArrayList<GraphNode> l1 = new ArrayList<GraphNode>();
		l1.add(g2);
		l1.add(g3);
		l1.add(g4);

		ArrayList<GraphNode> l2 = new ArrayList<GraphNode>();
		l2.add(g1);
		l2.add(g4);

		ArrayList<GraphNode> l3 = new ArrayList<GraphNode>();
		l3.add(g1);
		l3.add(g4);

		ArrayList<GraphNode> l4 = new ArrayList<GraphNode>();
		l4.add(g2);
		l4.add(g3);
		l4.add(g1);

		GraphNode r = clone(g1);

		System.out.println(r.val);
	}

	/*
	 * no weight all ; connected component; cycle directed
	 * 
	 */
	public GraphNode clone(GraphNode G) {

		if (G == null)
			return null;

		HashMap<GraphNode, GraphNode> H = new HashMap<GraphNode, GraphNode>();

		Queue<GraphNode> Q = new LinkedList<GraphNode>();
		Q.add(G);

		while (!Q.isEmpty()) {
			GraphNode cur = Q.remove();

			// check if cur node is already present in HashMAP - mapping not present
			if (!H.containsKey(cur)) {
				System.out.println("HashMap : "+cur.val);
				GraphNode m = new GraphNode(cur.val);
				H.put(cur, m);
				ArrayList<GraphNode> l = new ArrayList<GraphNode>();
				
				for (GraphNode n : cur.neighbours) {
					GraphNode p = new GraphNode(cur.val);
					Q.add(n);
				}

			}

		}

		return H.get(G);

	}

}
