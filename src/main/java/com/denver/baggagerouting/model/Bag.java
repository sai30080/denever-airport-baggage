package com.denver.baggagerouting.model;


public class Bag {
    private final String id;
    private final String entryGate;
    private final String flightNo;

    public Bag(String id, String entryGate, String flightNo) {
        this.id = id;
        this.entryGate = entryGate;
        this.flightNo = flightNo;
    }

    public String getId() {
        return id;
    }

    public String getEntryGate() {
        return entryGate;
    }

    public String getFlightNo() {
        return flightNo;
    }

	@Override
	public String toString() {
		return "Bag [id=" + id + ", entryGate=" + entryGate + ", flightNo=" + flightNo + "]";
	}
    
    
}
