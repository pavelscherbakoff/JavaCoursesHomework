package com.epam.lowcoster.server;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.epam.lowcoster.shared.Flight;

public interface FlightMapper {
	
	@Select("select distinct departure from flight")
	List<String> getDepartures();
	
	@Select("select distinct arrival from flight")
	List<String> getArrivals();

	@Select("select * from flight where departure = #{param1} and arrival = #{param2} and departure_time like #{param3}")
	List<Flight> getFlights(String param1, String param2, String param3);
	
	@Update("update flight set free_seats = free_seats - 1 where flight_id = #{param1}")
	void decreaseFreeSeats(Integer param1);

	@Select("select free_seats from flight where flight_id = #{param1}")
	Integer getFreeSeats(Integer param1);

	@Update("update flight set free_seats = free_seats + 1 where flight_id = #{param1}")
	void increaseFreeSeats(Integer param1);
}
