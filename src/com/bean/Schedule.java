package com.bean;

public class Schedule {
	private int schedule_id;
	private int plate;
	private int route_id;
	private String date;
	private String departure_time;
	private String arrival_time;
	private int seat_left;
	private int price;
	public Schedule(int schedule_id, int plate, int route_id, String date, String departure_time, String arrival_time, int seat_left,int price) {
		super();
		this.schedule_id = schedule_id;
		this.plate = plate;
		this.route_id = route_id;
		this.date=date;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.price=price;
		this.seat_left=seat_left;
	}
	
	public Schedule() {
		
	}

	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public int getSeat_left() {
		return seat_left;
	}
	public void setSeat_left(int seat_left) {
		this.seat_left = seat_left;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
