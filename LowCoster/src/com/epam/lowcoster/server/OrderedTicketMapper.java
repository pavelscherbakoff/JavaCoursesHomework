package com.epam.lowcoster.server;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.epam.lowcoster.shared.OrderedTicket;

public interface OrderedTicketMapper {

	@Select("select a.flight_id, b.ticket_id, a.flight_number, a.departure, a.departure_time, a.arrival, a.arrival_time, b.is_baggage, b.is_business, b.is_paid, b.price from flight a join ticket b on a.flight_id = b.flight_id where b.client_id = #{param1}")
	List<OrderedTicket> getMyFlights(Integer param1);
}
