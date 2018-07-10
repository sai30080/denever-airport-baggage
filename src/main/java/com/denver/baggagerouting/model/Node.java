package com.denver.baggagerouting.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements Comparable<Node> {
	//Make the key as final
	private final String name;
	private Node prevNode = null;
	private final Map<Node, Integer> neighbours = new HashMap<>();
	private int time ;//= Integer.MAX_VALUE;
	
	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Map<Node, Integer> getNeighbours() {
		return neighbours;
	}

	/***
	 * Arrangae the nodes in time order . If time is same order them by Name
	 */
	public int compareTo(Node other) {
		if (time == other.time)
			return name.compareTo(other.name);

		return Integer.compare(time, other.time);
	}

	public List<Node> getShortestPathTo() {
		List<Node> path = new ArrayList<>();
		path.add(this);
		Node node = this.getPrevNode();
		while (node != null && !path.contains(node)) {
			path.add(node);
			node = node.getPrevNode();
		}

		/* Reverse them to get the Path */

		Collections.reverse(path);
		return path;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", time=" + time + ", prevNode=" + prevNode + ", neighbours=" + neighbours + "]";
	}

}
