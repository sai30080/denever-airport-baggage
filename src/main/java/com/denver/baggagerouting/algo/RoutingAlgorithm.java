package com.denver.baggagerouting.algo;

import java.util.List;

import com.denver.baggagerouting.model.Edge;
import com.denver.baggagerouting.model.Node;
import com.denver.baggagerouting.model.RoutingGraph;

public class RoutingAlgorithm {


	public String findShortestPath(String entryGate, String destGate, List<Edge> edges) {
       //Form a graph 
		RoutingGraph routingGraph = new RoutingGraph(edges);

		//Pick from where to start reading
		routingGraph.routing(entryGate);
		List<Node> shortestPath = routingGraph.getShortestPath(destGate);
		return generatePath(shortestPath);
	}

	private String generatePath(List<Node> path) {
		StringBuilder line = new StringBuilder();

		for (Node vertex : path) {
			line.append(vertex.getName()).append(" ");
		}
		line.append(": ").append(path.get(path.size() - 1).getTime());
		return line.toString();
	}

}
