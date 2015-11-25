package com.epam.lowcoster.client;

import java.util.Date;
import java.util.List;
import com.epam.lowcoster.shared.Flight;
import com.epam.lowcoster.shared.OrderedTicket;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("lowCoster")
public interface LowCosterService extends RemoteService {
	
	Integer logIn(String login, String passwords);
	
	List<String> getDeparturesList();
	
	List<String> getArrivalsList();
	
	List<Flight> searchFlights(String departure, String arrival, Date date);
	
	List<Flight> orderFlight(Integer userId, Flight object, boolean withBaggage, boolean isBusiness, String totalPrice);
	
	List<OrderedTicket> searchMyFlights(Integer userId);
	
	Integer payTicket(int ticketId);
	
	Integer registerClient(String login, String password, String firstName, String secondName, String sex, String passwordId);
	
	Integer cancelOrder(int ticketId, int flightId);
}
