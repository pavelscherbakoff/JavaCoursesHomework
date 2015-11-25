package com.epam.lowcoster.shared;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {

	private int flight_id;
	private String flight_number;
	private String departure;
	private String arrival;
	private Date departure_time;
	private Date arrival_time;
	private int base_price;
	private int seats;
	private int free_seats;

	@Override
	public String toString() {
		return flight_number + " / " + departure + " (" + departure_time + ") - " + arrival + " (" + arrival_time + ") / "
				+ base_price + "$ / " + free_seats + " seats are free";
	}

	public int getFlightId() {
		return flight_id;
	}

	public void setFlightId(int flightId) {
		this.flight_id = flightId;
	}

	public int getBasePrice() {
		return base_price;
	}

	public void setBasePrice(int basePrice) {
		this.base_price = basePrice;
	}
	
	public int getSeats() {
		return seats;
	}

	public int getFreeSeats() {
		return free_seats;
	}

	public void setFreeSeats(int freeSeats) {
		this.free_seats = freeSeats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getFlightNumber() {
		return flight_number;
	}

	public void setFlightNumber(String flightNumber) {
		this.flight_number = flightNumber;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Date getDepartureTime() {
		return departure_time;
	}

	public void setDepartureTime(Date departureTime) {
		this.departure_time = departureTime;
	}

	public Date getArrivalTime() {
		return arrival_time;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrival_time = arrivalTime;
	}

}
