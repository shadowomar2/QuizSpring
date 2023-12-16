package com.example.demo.models;

public class ClientsResponse {

	private long id;
	private String name;
	private String lastname;
	private long mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "ClientsResponse [id=" + id + ", name=" + name + ", lastname=" + lastname + ", mobile=" + mobile + "]";
	}

	public ClientsResponse(long id, String name, String lastname, long mobile) {

		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.mobile = mobile;
	}

	public ClientsResponse() {

	}

}
