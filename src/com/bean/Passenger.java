package com.bean;

public class Passenger {
	private int passenger_id;
	private String name;
	private int phone;
	private String email;
	private int schedule_id;
	public Passenger(int passenger_id, String name, int phone, String email, int schedule_id) {
		super();
		this.passenger_id = passenger_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.schedule_id = schedule_id;
	}
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	
}
