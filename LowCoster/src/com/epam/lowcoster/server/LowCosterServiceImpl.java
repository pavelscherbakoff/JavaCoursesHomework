package com.epam.lowcoster.server;

import java.util.Date;
import java.util.List;

import com.epam.lowcoster.client.LowCosterService;
import com.epam.lowcoster.shared.Flight;
import com.epam.lowcoster.shared.OrderedTicket;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LowCosterServiceImpl extends RemoteServiceServlet implements LowCosterService {

	@Override
	public Integer logIn(String username, String password) {
		Integer result = DBManager.getClientId(username, password);
		return result;
	}

	@Override
	public List<String> getDeparturesList() {
		List<String> result = DBManager.getDeparturesList();
		return result;
	}

	@Override
	public List<String> getArrivalsList() {
		List<String> result = DBManager.getArrivalsList();
		return result;
	}

	@Override
	public List<Flight> searchFlights(String departure, String arrival, Date date) {
		List<Flight> result = DBManager.getFlights(departure, arrival, date);
		return result;
	}

	@Override
	public List<Flight> orderFlight(Integer userId, Flight object, boolean withBaggage, boolean isBusiness,
			String totalPrice) {
		DBManager.orderFlight(userId, object, withBaggage, isBusiness, totalPrice);
		return searchFlights(object.getDeparture(), object.getArrival(), object.getDepartureTime());
	}

	@Override
	public List<OrderedTicket> searchMyFlights(Integer userId) {
		List<OrderedTicket> myFlights = DBManager.getMyFlights(userId);
		return myFlights;
	}

	@Override
	public Integer payTicket(int ticketId) {
		DBManager.payTicket(ticketId);
		return null;
	}

	@Override
	public Integer registerClient(String login, String password, String firstName, String secondName, String sex,
			String passwordId) {
		DBManager.addClient(login, password, firstName, secondName, sex, passwordId);
		return null;
	}

	@Override
	public Integer cancelOrder(int ticketId, int flightId) {
		DBManager.cancelOrder(ticketId, flightId);
		return null;
	}
}
