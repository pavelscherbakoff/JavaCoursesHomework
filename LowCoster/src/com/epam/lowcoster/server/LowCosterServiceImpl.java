package com.epam.lowcoster.server;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lowcoster.client.LowCosterService;
import com.epam.lowcoster.shared.Flight;
import com.epam.lowcoster.shared.OrderedTicket;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LowCosterServiceImpl extends RemoteServiceServlet implements LowCosterService {

	static final Logger logger = LogManager.getLogger(LowCosterServiceImpl.class.getName());

	@Override
	public Integer logIn(String username, String password) {
		Integer result = DBManager.getClientId(username, password);
		logger.info("User " + username + " is logged in");
		return result;
	}

	@Override
	public List<String> getDeparturesList() {
		List<String> result = DBManager.getDeparturesList();
		logger.info("Departureds are found");
		return result;
	}

	@Override
	public List<String> getArrivalsList() {
		List<String> result = DBManager.getArrivalsList();
		logger.info("Arrivals are found");
		return result;
	}

	@Override
	public List<Flight> searchFlights(String departure, String arrival, Date date) {
		List<Flight> result = DBManager.getFlights(departure, arrival, date);
		logger.info("Flights are found for query: departure = " + departure + ", arrival = " + arrival + ", date = " + date);
		return result;
	}

	@Override
	public List<Flight> orderFlight(Integer userId, Flight object, boolean withBaggage, boolean isBusiness,
			String totalPrice) {
		DBManager.orderFlight(userId, object, withBaggage, isBusiness, totalPrice);
		logger.info("Flight is ordered for userId " + userId + ": " + object.toString());
		return searchFlights(object.getDeparture(), object.getArrival(), object.getDepartureTime());
	}

	@Override
	public List<OrderedTicket> searchMyFlights(Integer userId) {
		List<OrderedTicket> myFlights = DBManager.getMyFlights(userId);
		logger.info("Flights for user " + userId + " are found");
		return myFlights;
	}

	@Override
	public void payTicket(int ticketId) {
		DBManager.payTicket(ticketId);
		logger.info("Ticket " + ticketId + " is paid");
	}

	@Override
	public void registerClient(String login, String password, String firstName, String secondName, String sex,
			String passwordId) {
		DBManager.addClient(login, password, firstName, secondName, sex, passwordId);
		logger.info("User " + login + " is registered");
	}

	@Override
	public void cancelOrder(int ticketId, int flightId) {
		DBManager.cancelOrder(ticketId, flightId);
		logger.info("Order is cancelled. TicketId " + ticketId + ", FlightId " +flightId);
	}
}
