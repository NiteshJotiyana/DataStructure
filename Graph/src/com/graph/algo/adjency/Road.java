package com.graph.algo.adjency;

public class Road {

	String name;
	int distance;

	public Road(String name, int distance) {
		super();
		this.name = name;
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" - "+distance;
	}

}
