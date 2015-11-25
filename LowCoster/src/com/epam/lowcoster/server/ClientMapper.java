package com.epam.lowcoster.server;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.epam.lowcoster.shared.Client;

public interface ClientMapper {

	@Select("select * from client where login = #{param1} and password = #{param2}")
	Client getClient(String param1, String param2);

	@Insert("insert into client values (0, #{param1}, #{param2}, #{param3}, #{param4}, #{param5}, #{param6})")
	void addClient(String param1, String param2, String param3, String param4, String param5, String param6);
	
}
