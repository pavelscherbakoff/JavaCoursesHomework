package com.epam.lowcoster.shared;

import java.io.Serializable;
import java.util.Date;

public class OrderedTicket implements Serializable {

	private int ticket_id;
	private int flight_id;
	private String flight_number;
	private String departure;
	private String arrival;
	private Date departure_time;
	private Date arrival_time;
	private boolean is_baggage, is_business, is_paid;
	private int price;
	
	public int getFlightId() {
		return flight_id;
	}

	public void setFlightId(int flight_id) {
		this.flight_id = flight_id;
	}
	
	public int getTicketId() {
		return ticket_id;
	}

	public void setTicketId(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	
	public boolean isBaggage() {
		return is_baggage;
	}

	public void setBaggage(boolean is_baggage) {
		this.is_baggage = is_baggage;
	}

	public boolean isBusiness() {
		return is_business;
	}

	public void setBusiness(boolean is_business) {
		this.is_business = is_business;
	}

	public boolean isPaid() {
		return is_paid;
	}

	public void setPaid(boolean is_paid) {
		this.is_paid = is_paid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
