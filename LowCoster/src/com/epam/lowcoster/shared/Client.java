package com.epam.lowcoster.shared;

import java.io.Serializable;

public class Client implements Serializable {

	private int client_id, passport_id;
	private String first_name, second_name, sex;

	public int getClientId() {
		return client_id;
	}

	public void setClientId(int clientId) {
		this.client_id = clientId;
	}

	public int getPassportId() {
		return passport_id;
	}

	public void setPassportId(int passportId) {
		this.passport_id = passportId;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getSecondName() {
		return second_name;
	}

	public void setSecondName(String secondName) {
		this.second_name = secondName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
