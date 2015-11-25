package com.epam.lowcoster.client;

import java.util.Date;
import java.util.List;

import com.epam.lowcoster.shared.Flight;
import com.epam.lowcoster.shared.OrderedTicket;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LowCosterServiceAsync {
	
	void logIn(String login, String password, AsyncCallback<Integer> asyncCallback);

	void getDeparturesList(AsyncCallback<List<String>> asyncCallback);

	void getArrivalsList(AsyncCallback<List<String>> asyncCallback);

	void searchFlights(String departure, String arrival, Date date, AsyncCallback<List<Flight>> asyncCallback);
	
	void orderFlight(Integer userId, Flight object, boolean withBaggage, boolean isBusiness, String totalPrice, AsyncCallback<List<Flight>> asyncCallback);

	void searchMyFlights(Integer userId, AsyncCallback<List<OrderedTicket>> asyncCallback);

	void payTicket(int ticketId, AsyncCallback<Integer> asyncCallback);

	void registerClient(String login, String password, String firstName, String secondName, String sex, String passwordId,
			AsyncCallback<Integer> asyncCallback);

	void cancelOrder(int ticketId, int flightId, AsyncCallback<Integer> asyncCallback);
}
