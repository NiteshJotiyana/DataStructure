package com.graph.algo.adjency;

public class City {

	String name;
	long longtitude;
	long latitude;

	public City(String name, long longtitude, long latitude) {
		super();
		this.name = name;
		this.longtitude = longtitude;
		this.latitude = latitude;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return this.name.equals(((City) obj).name);
	}

}
