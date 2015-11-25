package com.epam.lowcoster.server;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface TicketMapper {
	
	@Insert("insert into ticket values (#{param1}, #{param2}, #{param3}, #{param4}, #{param5}, #{param6}, #{param7})")
	void createTicket(Integer param1, Integer param2, Integer param3, boolean param4, boolean param5, String param6, boolean param7);
	
	@Update("update ticket set is_paid = '1' where ticket_id = #{param1}")
	void payTicket(Integer param1);

	@Delete("delete from ticket where ticket_id = #{param1}")
	void cancelOrder(int param1);

}
