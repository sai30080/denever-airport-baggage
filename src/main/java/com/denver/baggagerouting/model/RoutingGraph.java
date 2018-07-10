package com.denver.baggagerouting.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.denver.baggagerouting.RoutingException;

public class RoutingGraph {

	private final Map<String, Node> graphMap;

	public RoutingGraph(List<Edge> edges) {

		graphMap = new HashMap<>(edges.size());

		// Populated all the Nodes from the edges
		for (Edge e : edges) {
			// System.out.println(e);
			if (!graphMap.containsKey(e.getSource().getName())) {
				String sourceName = e.getSource().getName();
				graphMap.put(sourceName, new Node(sourceName));
			}
			if (!graphMap.containsKey(e.getDestination().getName())) {

				String destinationName = e.getDestination().getName();
				graphMap.put(destinationName, new Node(destinationName));
			}
			// System.out.println(graphMap);
		}

		// Set all the neighbours
		for (Edge e : edges) {
			graphMap.get(e.getSource().getName()).getNeighbours().put(graphMap.get(e.getDestination().getName()),
					e.getTime());
		}
	}

	public void routing(String startName) {
		if (!graphMap.containsKey(startName)) {
			throw new RoutingException("This RoutingGraphMap does not contain the starting Vertex named:" + startName);
		}
		final Node source = graphMap.get(startName);
		NavigableSet<Node> queue = new TreeSet<>();

		for (Node v : graphMap.values()) {
			v.setPrevNode(v == source ? source : null);
			v.setTime(v == source ? 0 : Integer.MAX_VALUE);
			queue.add(v);
		}
		// System.out.println("queue=" + queue);

		routing(queue);
	}

	public List<Node> getShortestPath(String endName) {
		if (!graphMap.containsKey(endName)) {
			throw new RoutingException("Graph doesn't contain end vertex : " + endName);
		}

		return graphMap.get(endName).getShortestPathTo();
	}

	//
	private void routing(final NavigableSet<Node> que) {
		Node source, neighbour;
		while (!que.isEmpty()) {
			source = que.pollFirst();
			// look at distances to each neighbour
			for (Map.Entry<Node, Integer> a : source.getNeighbours().entrySet()) {
				neighbour = a.getKey();
				final int alternateTime = source.getTime() + a.getValue();
				if (alternateTime < neighbour.getTime()) { 
					que.remove(neighbour);
					neighbour.setTime(alternateTime);
					neighbour.setPrevNode(source);
					que.add(neighbour);
				}
			}
		}
	}
}
