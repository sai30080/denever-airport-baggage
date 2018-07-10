package com.denver.baggagerouting.model;


public class Edge {
    private final Node source;
    private final Node destination;
    private final int time;

    
    public Edge(String sourceName, String destinationName, Integer time) {
        this.source = new Node(sourceName);
        this.destination = new Node(destinationName);
        this.time = time;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getTime() {
        return time;
    }

	@Override
	public String toString() {
		return "DirectedEdge [source=" + source + ", destination=" + destination + ", time=" + time + "]";
	}
    
    
}
