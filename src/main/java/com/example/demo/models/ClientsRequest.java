package com.example.demo.models;

public class ClientsRequest {

	private String name;
	private String lastname;
	private long mobile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public ClientsRequest(String name, String lastname, long mobile) {
	 
		this.name = name;
		this.lastname = lastname;
		this.mobile = mobile;
	}

	public ClientsRequest() {
	 
	}

	@Override
	public String toString() {
		return "ClientsRequest [name=" + name + ", lastname=" + lastname + ", mobile=" + mobile + "]";
	}

}
