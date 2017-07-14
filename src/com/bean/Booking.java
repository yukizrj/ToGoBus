package com.bean;

public class Booking {
	private int booking_id;
	private int schedule_id;
	private String name;
	private String email;
	private String source;
	private String destination;
	private String departure_time;
	private String arrival_time;
	private int price;
	private java.sql.Date datetime;
	private int plate;
	private int passnum;
	private String phone;
	public Booking(int schedule_id, String name, String email, int passnum, String phone) {
		super();
		this.schedule_id = schedule_id;
		this.name = name;
		this.email = email;
		this.passnum=passnum;
		this.phone=phone;
	}
	private int seats;
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public java.sql.Date getDatetime() {
		return datetime;
	}
	public void setDatetime(java.sql.Date datetime) {
		this.datetime = datetime;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	public int getPassnum() {
		return passnum;
	}
	public void setPassnum(int passnum) {
		this.passnum = passnum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
