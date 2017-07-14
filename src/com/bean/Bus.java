package com.bean;

public class Bus {
	private int plate;
	private String model;
	private int capacity;
	private int route_id;
	public Bus(int plate, String model, int capacity, int route_id) {
		super();
		this.plate = plate;
		this.model = model;
		this.capacity = capacity;
		this.route_id = route_id;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	
	
}
