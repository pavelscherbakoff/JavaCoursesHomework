package com.epam.lowcoster.server;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.epam.lowcoster.shared.Client;
import com.epam.lowcoster.shared.Flight;
import com.epam.lowcoster.shared.OrderedTicket;

public class DBManager {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			Reader resourceReader = Resources.getResourceAsReader("resources/config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceReader);
			sqlSessionFactory.getConfiguration().addMapper(ClientMapper.class);
			sqlSessionFactory.getConfiguration().addMapper(FlightMapper.class);
			sqlSessionFactory.getConfiguration().addMapper(TicketMapper.class);
			sqlSessionFactory.getConfiguration().addMapper(OrderedTicketMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Integer getClientId(String name, String password) throws IllegalArgumentException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClientMapper mapper = session.getMapper(ClientMapper.class);
			Client client = mapper.getClient(name, password);
			if (null == client) {
				throw new IllegalArgumentException("Client not found");
			}
			return client.getClientId();
		} finally {
			session.close();
		}
	}

	public static List<String> getDeparturesList() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FlightMapper mapper = session.getMapper(FlightMapper.class);
			List<String> departures = mapper.getDepartures();
			if (departures.isEmpty()) {
				throw new IllegalArgumentException("There are no flights");
			}
			return departures;
		} finally {
			session.close();
		}
	}

	public static List<String> getArrivalsList() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FlightMapper mapper = session.getMapper(FlightMapper.class);
			List<String> arrivals = mapper.getArrivals();
			if (arrivals.isEmpty()) {
				throw new IllegalArgumentException("There are no flights");
			}
			return arrivals;
		} finally {
			session.close();
		}
	}

	public static List<Flight> getFlights(String departure, String arrival, Date date) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FlightMapper mapper = session.getMapper(FlightMapper.class);
			List<Flight> flights = mapper.getFlights(departure, arrival,
					new SimpleDateFormat("yyyy-MM-dd").format(date) + "%");
			if (flights.isEmpty()) {
				throw new IllegalArgumentException("There are no flights");
			}
			return flights;
		} finally {
			session.close();
		}
	}

	public static List<Flight> orderFlight(Integer userId, Flight object, boolean withBaggage, boolean isBusiness,
			String totalPrice) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FlightMapper flightMapper = session.getMapper(FlightMapper.class);
			TicketMapper ticketMapper = session.getMapper(TicketMapper.class);

			if (flightMapper.getFreeSeats(object.getFlightId()) == 0) {
				throw new IllegalArgumentException("There are no empty seats");
			}

			flightMapper.decreaseFreeSeats(object.getFlightId());
			ticketMapper.createTicket(0, object.getFlightId(), userId, withBaggage, isBusiness, totalPrice, false);
			session.commit();
			List<Flight> flights = flightMapper.getFlights(object.getDeparture(), object.getArrival(),
					new SimpleDateFormat("yyyy-MM-dd").format(object.getDepartureTime()) + "%");
			if (flights.isEmpty()) {
				throw new IllegalArgumentException("Error happened");
			}
			return flights;
		} finally {
			session.close();
		}
	}

	public static List<OrderedTicket> getMyFlights(Integer userId) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			OrderedTicketMapper mapper = session.getMapper(OrderedTicketMapper.class);
			List<OrderedTicket> myFlights = mapper.getMyFlights(userId);
			return myFlights;
		} finally {
			session.close();
		}
	}

	public static void payTicket(int ticketId) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			TicketMapper mapper = session.getMapper(TicketMapper.class);
			mapper.payTicket(ticketId);
			session.commit();
		} finally {
			session.close();
		}
	}

	public static void addClient(String login, String password, String firstName, String secondName, String sex,
			String passportId) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClientMapper mapper = session.getMapper(ClientMapper.class);
			mapper.addClient(login, password, firstName, secondName, sex, passportId);
			session.commit();
		} finally {
			session.close();
		}
	}

	public static void cancelOrder(int ticketId, int flightId) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			TicketMapper ticketMapper = session.getMapper(TicketMapper.class);
			FlightMapper flightMapper = session.getMapper(FlightMapper.class);
			
			ticketMapper.cancelOrder(ticketId);
			flightMapper.increaseFreeSeats(flightId);
			session.commit();
		} finally {
			session.close();
		}
	}
}
