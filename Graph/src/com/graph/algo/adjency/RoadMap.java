package com.graph.algo.adjency;

public class RoadMap {

	Graph<City, Road> gMap;

	public static void main(String[] args) {
		new RoadMap();
	}
	public RoadMap() {
		gMap = new Graph<City, Road>();

		City ajmer = new City("Ajmer", 1, 1);
		City jaipur = new City("Jaipur", 2, 2);
		City delhi = new City("Delhi", 3, 3);
		City beawar = new City("Beawar", 4, 4);

		gMap.addEdge(ajmer, delhi, new Road("NH1", 400));
		gMap.addEdge(ajmer, beawar, new Road("NH4", 50));
		gMap.addEdge(ajmer, jaipur, new Road("NH4", 125));
		gMap.addEdge(jaipur, delhi, new Road("NH1", 300));
		gMap.addEdge(beawar, delhi, new Road("NH1-NH4", 500));

		System.out.println(getDistance("Ajmer", "Delhi"));
	}

	public Road getDistance(String cityName1, String cityName2) {

		return gMap.getWeight(new City(cityName1, 1, 1), new City(cityName2, 1, 1));

	}

}
