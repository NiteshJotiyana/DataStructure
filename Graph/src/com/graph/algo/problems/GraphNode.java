package com.graph.algo.problems;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	int val;
	List<GraphNode> neighbours;

	public GraphNode(int val) {
		this.val = val;
		neighbours = new ArrayList<GraphNode>();
	}

	public GraphNode(int val, List<GraphNode> neighbours) {
		super();
		this.val = val;
		this.neighbours = neighbours;
	}

	@Override
	public int hashCode() {
		return new Integer(this.val) + neighbours.size();

	}

	@Override
	public boolean equals(Object obj) {

		return new Integer(this.val).equals(((GraphNode) obj).val);
	}

}
