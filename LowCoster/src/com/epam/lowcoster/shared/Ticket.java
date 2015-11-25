package com.epam.lowcoster.shared;

import java.io.Serializable;

public class Ticket implements Serializable {

	private int ticket_id, flight_id, client_id, price;
	private boolean is_baggage, is_business, is_paid;

	public int getTicketId() {
		return ticket_id;
	}

	public void setTicketId(int ticketId) {
		this.ticket_id = ticketId;
	}

	public int getFlightId() {
		return flight_id;
	}

	public void setFlightId(int flightId) {
		this.flight_id = flightId;
	}

	public int getClientId() {
		return client_id;
	}

	public void setClientId(int clientId) {
		this.client_id = clientId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isBaggage() {
		return is_baggage;
	}

	public void setBaggage(boolean isBaggage) {
		this.is_baggage = isBaggage;
	}

	public boolean isBusiness() {
		return is_business;
	}

	public void setBusiness(boolean isBusiness) {
		this.is_business = isBusiness;
	}

	public boolean isPaid() {
		return is_paid;
	}

	public void setPaid(boolean isPaid) {
		this.is_paid = isPaid;
	}

}
